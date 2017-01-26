package com.company.rest.api;

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
import com.bonitasoft.engine.api.IdentityAPI

import org.bonitasoft.engine.identity.ContactData
import org.bonitasoft.engine.identity.User

class Index implements RestApiController {

    private static final Logger LOGGER = LoggerFactory.getLogger(Index.class)

    @Override
    RestApiResponse doHandle(HttpServletRequest request, RestApiResponseBuilder responseBuilder, RestAPIContext context) {
        // To retrieve query parameters use the request.getParameter(..) method.
        // Be careful, parameter values are always returned as String values

        // Retrieve cedula parameter
        def cedula = request.getParameter "cedula"
        if (cedula == null && !cedula.isEmpty()) {
            return buildResponse(responseBuilder, HttpServletResponse.SC_BAD_REQUEST,"""{"error" : "the parameter cedula is missing"}""")
        }
		
		Properties props = loadProperties("configuration.properties", context.resourceProvider)
		String campoCedula = props["campoCedula"]
		
		IdentityAPI iapi = context.getApiClient().getIdentityAPI()
		
		def listaUsuarios = null
		try{
			listaUsuarios = iapi.getUserIdsWithCustomUserInfo(campoCedula, cedula, false, 0, 1)
		}catch(Exception ex){
			return buildResponse(responseBuilder, HttpServletResponse.SC_BAD_REQUEST,"""{"error" : "fallo al consultar usuario con cedula"}""")
		}
		
		def result = [ "nombre" : "" , "apellido" : "", "mail" : ""]
		if (listaUsuarios != null && !listaUsuarios.isEmpty()) {
			try {
				ContactData contactData = iapi.getUserContactData(listaUsuarios[0], false)
				User user = iapi.getUser(listaUsuarios[0])
				
				result.nombre = user.getFirstName()
				result.apellido = user.getLastName()
				result.mail = contactData.getEmail()
			}catch(Exception e){
				return buildResponse(responseBuilder, HttpServletResponse.SC_BAD_REQUEST,"""{"error" : "fallo al consultar datos usuario"}""")
			}
		}
		
        return buildResponse(responseBuilder, HttpServletResponse.SC_OK, new JsonBuilder(result).toPrettyString())
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

}
