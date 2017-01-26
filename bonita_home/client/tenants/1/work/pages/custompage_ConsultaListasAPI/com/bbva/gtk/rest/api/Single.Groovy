package com.bbva.gtk.rest.api;

import groovy.json.JsonBuilder

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import org.apache.http.HttpHeaders
import org.bonitasoft.web.extension.ResourceProvider
import org.bonitasoft.web.extension.rest.RestApiResponse
import org.bonitasoft.web.extension.rest.RestApiResponseBuilder
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import com.bonitasoft.web.extension.rest.RestAPIContext
import com.bonitasoft.web.extension.rest.RestApiController

import javax.sql.DataSource

import javax.naming.Context
import javax.naming.InitialContext
import java.sql.Connection
import groovy.sql.Sql

class Single implements RestApiController {

	private static final Logger LOGGER = LoggerFactory.getLogger(Single.class)
	
	private static Map<String, Object> mapaCache = new HashMap<String, Object>()

	@Override
	RestApiResponse doHandle(HttpServletRequest request, RestApiResponseBuilder responseBuilder, RestAPIContext context) {
		// To retrieve query parameters use the request.getParameter(..) method.
		// Be careful, parameter values are always returned as String values

		// Retrieve c parameter
		def params = [];
		def c = request.getParameter "c"
		boolean add2Cache = true
		def resultado = null
		Connection con = null
		def paramValueObject = null
		def listData = null
		String listDatacadena
		def paramValue
		Properties props = loadProperties("configuration.properties", context.resourceProvider)
		
		resultado = []
						
		if (c == null) {
			return buildResponse(responseBuilder, HttpServletResponse.SC_BAD_REQUEST, """{"error" : "the parameter c is missing"}""")
		}
		
		if(mapaCache.containsKey(c)){
			resultado = mapaCache.get(c)
			return buildResponse(responseBuilder, HttpServletResponse.SC_OK, new JsonBuilder(resultado).toPrettyString())
		}
		
		LOGGER.info("Parametros API 1")	
		
		try{
			con = getConnection(props.get("jndi"))
		}catch(Exception ex){
			LOGGER.error("Error db connection: " + props.get("jndi"), ex)
			LOGGER.info(ex);
			return buildResponse(responseBuilder, HttpServletResponse.SC_INTERNAL_SERVER_ERROR,"""{"error" : "server connection"}""")
		}
		
		LOGGER.info("Parametros API2")	
		try{
		//	paramValueObject = Eval.me("SELECT ID, CONSULTA, ESTRUCTURA FROM API_CONSULTA_LISTAS WHERE ID='"+c+"'")
		}catch(Exception ex){
			return buildResponse(responseBuilder, HttpServletResponse.SC_BAD_REQUEST,"""{"error" : "getting value"}""")
		}
		LOGGER.info("Parametros API3")		
		
			def sql0 = null
			
			try{
					sql0 = new Sql(con)
					// row method
					def getRowData = { row ->
						listDatacadena=	row[2]
						paramValue= row[1]	
					}
					
					sql0.eachRow("SELECT ID, CONSULTA, ESTRUCTURA FROM API_CONSULTA_LISTAS WHERE ID='"+c+"'", params, getRowData)
					LOGGER.info("SELECT ID, CONSULTA, ESTRUCTURA FROM API_CONSULTA_LISTAS WHERE ID='"+c+"'")	
					
				}catch(Exception ex){
				
					return buildResponse(responseBuilder, HttpServletResponse.SC_INTERNAL_SERVER_ERROR,"""{"error" : "fetching data"}""")
				}finally{
					//sql0.close()
				}
		
		
		LOGGER.error("linea paramValue: " + paramValue)
		LOGGER.error("linea listDatacadena: " + listDatacadena)
		listData = []
		listData= listDatacadena.split(",")
		
		LOGGER.error("linea paramValue: " + listData)
		
		
				
			if(paramValue != null && !paramValue.isEmpty()){
										
			// is String
			if(paramValue.toUpperCase().startsWith("SELECT") ){
				
				// validar si usa parametros
				
				if(paramValue.contains("?")){
					// si se utiliza parametros de busqueda, no agregar al cache
					add2Cache = false
					def p = request.getParameter "p"
					if(p == null || p.isEmpty()) {
						//return buildResponse(responseBuilder, HttpServletResponse.SC_BAD_REQUEST, """{"error" : "missing params configuration"}""")
						params.add(null)
						 LOGGER.info("parametro: nulo " )
						   
					} else {
						   params = p.split(",").toList()
						   LOGGER.info("parametro: " + params)
						   LOGGER.info("parametro: " + p.split(","))
						
					}
				}
				
				
				
				
				LOGGER.error("casi al sql: " + listDatacadena)
				def sql = null
				try{
					sql = new Sql(con)
			
					// row method
					def getRowData2 = { row2 ->
						
						def map = [:]
						
						for(i in 0..listData.size()-1){
							map.put(listData[i], row2[i])
						}
						resultado.add( map )
					}
					
					sql.eachRow(paramValue, params, getRowData2)

				}catch(Exception ex){
					LOGGER.error("Error sql: " + paramValueObject, ex)
					return buildResponse(responseBuilder, HttpServletResponse.SC_INTERNAL_SERVER_ERROR,"""{"error" : "fetching data"}""")
				}finally{
					sql.close()
				}
				
				if (resultado.size() == 0){
					resultado = ""
				} else if (resultado.size() == 1){
					resultado = resultado[0]
				}
			} else {
				resultado = paramValueObject
				//resultado = Eval.me(paramValueObject)
			}
		}else{
			return buildResponse(responseBuilder, HttpServletResponse.SC_BAD_REQUEST, """{"error" : "missing configuration"}""")
		}
		
		if(add2Cache){
			mapaCache.put(c, resultado)
		}

		// Prepare the result
		//def result = [ c : resultado]

		// Send the result as a JSON representation
		// You may use buildPagedResponse if your result is multiple
		return buildResponse(responseBuilder, HttpServletResponse.SC_OK, new JsonBuilder(resultado).toPrettyString())
	}

	/**
	 * Build an HTTP response.
	 *
	 * @param  responseBuilder the Rest API response builder
	 * @param  httpStatus the status of the response
	 * @param  body the response body
	 * @return a RestAPIResponse
	 */
	RestApiResponse buildResponse(RestApiResponseBuilder responseBuilder, int httpStatus, Serializable body) {
		return responseBuilder.with {
			withResponseStatus(httpStatus)
			withResponse(body)
			build()
		}
	}

	/**
	 * Returns a paged result like Bonita BPM REST APIs.
	 * Build a response with content-range data in the HTTP header.
	 *
	 * @param  responseBuilder the Rest API response builder
	 * @param  body the response body
	 * @param  p the page index
	 * @param  c the number of result per page
	 * @param  total the total number of results
	 * @return a RestAPIResponse
	 */
	RestApiResponse buildPagedResponse(RestApiResponseBuilder responseBuilder, Serializable body, int p, int c, long total) {
		return responseBuilder.with {
			withAdditionalHeader(HttpHeaders.CONTENT_RANGE,"$p-$c/$total");
			withResponse(body)
			build()
		}
	}

	/**
	 * Load a property file into a java.util.Properties
	 */
	Properties loadProperties(String fileName, ResourceProvider resourceProvider) {
		Properties props = new Properties()
		resourceProvider.getResourceAsStream(fileName).withStream { InputStream s ->
			props.load s
		}
		props
	}
	
	Connection getConnection(jndi){
		try{
			def context = new InitialContext()
			def ds = context.lookup(jndi)
			return ds.getConnection()
		}catch(Exception ex){
			throw ex
		}
	}

}
