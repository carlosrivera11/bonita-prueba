import java.io.BufferedReader
import java.io.ByteArrayOutputStream
import java.io.InputStreamReader
import java.io.OutputStream

import java.net.HttpURLConnection
import java.net.URL
import java.net.URLConnection

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import javax.sql.DataSource

import javax.naming.Context
import java.io.BufferedReader
import java.io.ByteArrayOutputStream
import java.io.InputStreamReader
import java.io.OutputStream
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLConnection
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

import javax.naming.Context
import javax.naming.InitialContext
import javax.sql.DataSource
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.xml.sax.InputSource
import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.NodeList

import java.util.logging.Logger
import java.util.logging.Level

static callWS(String serviceURL, String soapAction, String soapRequest) {

	Logger LOG = Logger.getLogger("consumeService")

	HttpURLConnection httpConn = null
	Document document = null

	try {
		
		// abrir conexion
		URL url = new URL(serviceURL);
		URLConnection connection = url.openConnection();
		httpConn = (HttpURLConnection)connection;
		ByteArrayOutputStream bout = new ByteArrayOutputStream();

		// preparar request
		String xmlInput = soapRequest
		byte[] buffer = new byte[xmlInput.length()];
		buffer = xmlInput.getBytes();
		bout.write(buffer);
		byte[] b = bout.toByteArray();

		//Configurar los parámetros HTTP
		httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
		httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
		httpConn.setRequestProperty("SOAPAction", soapAction);
		httpConn.setRequestMethod("POST");
		httpConn.setDoOutput(true);
		httpConn.setDoInput(true);
		
		//Escribe el contenido del request a un outputstream de la conexion HTTP
		OutputStream out = httpConn.getOutputStream();

		out.write(b);
		out.close();
		
		// leer response
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		document = factory.newDocumentBuilder().parse(httpConn.getInputStream());
		
		document.getDocumentElement().normalize();

	}catch(Exception ex){
		LOG.log(Level.SEVERE, ex.getMessage(), ex)
		throw ex
	}finally {
		httpConn.disconnect()
	}

	return document
}

static extractAsList(String tag, Document document, Map config) {
	Logger LOG = Logger.getLogger("extractAsList 1")
	
	try{
		NodeList nl = document.getElementsByTagName(tag)
		
		def lista = []
		
		for (int i = 0; i < nl.getLength(); i++) {
			Node solicitud = nl.item(i)
		
			def mapa = [:]
			NodeList dataSolicitud = solicitud.getChildNodes()
			for (int j = 0; j < dataSolicitud.getLength(); j++) {
				Node data = dataSolicitud.item(j)
				
				if(config == null){
					mapa.put( data.getNodeName(), data.getTextContent() )
				} else {
					def keyVal = config.get( data.getNodeName() )
					// obtener valor configurado en config
					if(keyVal != null && !keyVal.isEmpty()) {
						mapa.put( keyVal, data.getTextContent() )
					}
				}
			}
			
			lista.add(mapa)
		}
		
		return lista
	} catch(Exception ex){
		LOG.log(Level.SEVERE, ex.getMessage(), ex)
		throw ex
	}
}

static extractAsList(String tag, Document document) {
	Logger LOG = Logger.getLogger("extractAsList 2")
	try{
		return extractAsList(tag, document, null)
	}catch(Exception ex){
		LOG.log(Level.SEVERE, ex.getMessage(), ex)
		throw ex
	}
}

static extractSingleValue(String tag, Document document) {
	Logger LOG = Logger.getLogger("extractSingleValue")
	
	try{
		NodeList nl = document.getElementsByTagName(tag)
		
		def lista = []
		
		if(nl.getLength() > 0){
			return nl.item(0).getTextContent()
		}
		
		return ""

	} catch(Exception ex){
		LOG.log(Level.SEVERE, ex.getMessage(), ex)
		throw ex
	}
}

static putXmlData(xml, source) {
	if (source instanceof java.util.Map){
		source.each{
			k, v ->
			def value
			if ( v == null || v instanceof java.lang.String ) {
				def tmpValue
				
				if(v == null || v.toUpperCase().contains("NULL")) {
					tmpValue = ""
				} else {
					tmpValue = v.trim()
				}
				
				// valor predefinido
				def tmpKey = "{" + k + "}"
				// validar si es cadena OPcional
				if( xml.contains("OP" + tmpKey) ) {

						if( !tmpValue.isEmpty() && k.equals("listasOtrosIngreso")) {
								tmpValue = tmpValue
							}    
							else if( !tmpValue.isEmpty() ) {
									tmpValue = buildTag(k, tmpValue)
							}
							tmpKey = "OP" + tmpKey
				}
				// validar si es cadena Obligatoria
				else if( xml.contains("O" + tmpKey) ) {
					if( !tmpValue.isEmpty() ) {
						tmpValue = buildTag(k, tmpValue)
					}
					tmpKey = "O" + tmpKey
				}

				// reemplazar valor
				xml = xml.replace(tmpKey, tmpValue)
			}
		}
		// eliminar los OPcionales restantes
		xml = xml.replaceAll("OP\\{[a-z A-Z 0-9]*\\}", "")
		return xml
	} else if (source instanceof java.util.List) {
		def xmlConcat = ""
		source.each {
			mapa ->
			xmlConcat += putXmlData(xml, mapa)
		}
		return xmlConcat
	}
	
	return ""
}

static buildTag(tag, value){
	return "<" + tag + ">" + value + "</" + tag + ">"
}