import java.text.SimpleDateFormat
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.DateFormat
import java.util.logging.Logger
import java.util.logging.Level


/**
* Agregar todos los parametros a un mapa
* @param args Lista de parametros x Llave, X+1 valor
*/
static addParameters(Object... args) {
	int posK = 0
	int posV = 1

	List<List<Object>> tmp_parametros = new ArrayList<ArrayList<Object>>()
	List<Object> tmp_param = new ArrayList<Object>()

	while (posV <= args.size()){
		// agregar a lista temporal
		tmp_param = new ArrayList<Object>()
		tmp_param.add(args[posK])
		tmp_param.add(args[posV])
		// agregar a lista
		tmp_parametros.add(tmp_param)
		// incrementar posicion
		posK = posK + 2
		posV = posV + 2
	}
	
	return tmp_parametros
}

/**
*	Construye un mapa a partir del values (data) generado en el formulario como texto
*/
static buildMapa (String data) {
	def mapaTmp = [ : ]
	
	if(data == null || data.isEmpty()){
		return mapaTmp
	}
	
	// obtener elementos separados por , eliminar comilla sencilla
	def elementos = data.replace("[","").replace("]","").split(",")
	
	elementos.each {
		elemento ->
		// separar por =
		def keyValue = elemento.split("=")
		
		def key_ = keyValue[0].replace("'", "").trim()
		def value_ = keyValue[1].replace("'", "").trim()

		// validar si hay lista separada por ; -
		def separador = ""
		
		/*
		if(value_.contains(";")){
			separador = ";"
		} else if (value_.contains("-")){
			separador = "-"
		}
		*/
		
		// validar si hay separador de lista
		if(!separador.isEmpty()) {
			def subList = value_.split(separador)
			def tmpLista = []
			// construir lista y agregar como elemento del mapa
			subList.each{
				e ->
				tmpLista.add(e)
			}
			mapaTmp.put(key_, tmpLista)
		} else {
			mapaTmp.put(key_, value_)
		}
	}
	return mapaTmp
}

/**
*	Valida el valor (value), que no sea null, ni contenga el texto 'null' o 'NULL', en cuyo caso retorna vacio
*/
static validateValue(value){
	def emptyValue = ""
	if(value == null){
		return emptyValue
	}
	// null, NULL, Null
	if(value instanceof java.lang.String){
		if(value == null || value.toUpperCase().equals('NULL')){
			return emptyValue
		}
		return value.trim()
	}
	return value
}

/**
*	concatena multiples valores (ks) de un mapa (m) separados por espacio
*/
static getMapValue (Map m, List ks) {
	def res = ""
	ks.each{
		k->
		res += validateValue(m.get(k)) + " "
	}
	return res.substring(0, res.length()-1)
}

/**
*	obtiene el valor(key) de un mapa(m), en caso de valro invalido retorna vacio
*/
static getMapValue (Map m, String key) {
	return validateValue( m.get(key) )
}

/**
* Obtiene el valor de un mapa (m), en caso de ser inválido, utiliza el valor por defecto (defaultValue)
*/
static getMapValue (Map m, key, defaultValue) {
	def value = validateValue( m.get(key) )
	if( validateValue(value).isEmpty() || validateValue(value).equals("")) {
		return defaultValue
	}
	return value
}

/**
* Divide el valor de (texto) utilizando (separator) y retorna la posición (pos)
*/
static getValueSplitPos(texto, separator, pos){
	try{
		return validateValue( (texto.split(separator)[pos]) )
	}catch(Exception ex){
		return ""
	}
}

static getValueValues(String data, List ks){
	def tmpResult = ""
	ks.each{
		k->
		def tmp = ""
		try{
			def pattern = k + "\\s{0,9}=\\s{0,9}'(.*?)'"
			tmp = (data =~ pattern)[0][1]
		}catch(Exception ex){}
		
		tmpResult += validateValue( tmp ) + " "
	}
	return tmpResult
}

/**
*	Obtiene el codigo de la forma XXXXX-(codigo)
*/
static extractCodigo(String data){
	
	def value = ""
	try{
		data = data.replace("(", "").replace(")","")
		value = data.split("-")[1]
		value = value.trim()
	}catch(Exception ex){}
	
	return value
}

/**
*	Obtiene el valor (key) de values(data)
*/
static getValueValues(String data, String key){
	def tmp = ""
	try{
		def pattern = key + "\\s{0,9}=\\s{0,9}'(.*?)'"
		tmp = (data =~ pattern)[0][1]
	}catch(Exception ex){}
	
	return validateValue( tmp )
}

/**
*	Obtiene el valor (key) de values(data), en caso de ser inválido utiliza (defaultValue)
*/
static getValueValues(String data, String key, defaultValue){
	def value = getValueValues( data, key)
	if(value.isEmpty()){
		return defaultValue
	}
	return value
}

/**
*	Obtiene un objeto de DecimalFormat, utilizado para almacenar información o enviar a WS "###.##"
*/
static getDecimalFormat(){
	String pattern = "###.##"
	DecimalFormatSymbols dfs = new DecimalFormatSymbols()
	dfs.setDecimalSeparator((char)'.')
	DecimalFormat df = new DecimalFormat(pattern, dfs)
	return df
}

/**
*	Obtiene un objeto de DecimalFormat, utilizado para visualización, en los formularios por ejemplo "#,##0.##"
*/
static getDecimalFormatForms(){
	String pattern = "#,##0.##"
	DecimalFormatSymbols dfs = new DecimalFormatSymbols()
	dfs.setDecimalSeparator((char)',')
	dfs.setGroupingSeparator((char)'.')
	DecimalFormat df = new DecimalFormat(pattern, dfs)
	return df
}

/**
*	Formatea un valor (value) utililizando un decimal format de entrada (dfin),
*   y lo convierte con otro decimal format de salida (dfout). Por ejemplo 2.500.000  convertirlo a 2500000
*/
static formatString(String value, DecimalFormat dfin, DecimalFormat dfout){
	try{
		return dfout.format(dfin.parse(value))
	}catch(Exception ex){
		return "0"
	}
}

/**
* obtiene un numero teniendo en cuenta el formato definido en df
*/
static parseNumeric (Map m, String k) {
	DecimalFormat df = getDecimalFormat()
	return parseNumeric(m, k, df)
}
	
static parseNumeric (Map m, String k, DecimalFormat df) {
	def tv = getMapValue(m, k)
	// validar si el valor es vacio, si lo es retornar 0
	return (tv.isEmpty() ? new BigDecimal("0") : df.parse(tv))
}

/**
*	Obtiene fecha actual con formato dd/MM/yyyy
*/
static getFecha(){
	Date fechaActual = new Date();
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	String fechaGeneracion = format.format(fechaActual);
					   
	return fechaGeneracion
}

/**
*	Obtiene fecha actual con formato dd/MM/yyyy HH:mm:ss
*/
static getFechaFull(){
	Date fechaActual = new Date();
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	String fechaGeneracion = format.format(fechaActual);
					   
	return fechaGeneracion
}

/**
*	Transforma una fecha del formato dd/MM/yyyy
*/
static getFechaConfiar(String fechaFormatoInicial) {
	if(fechaFormatoInicial != null && !fechaFormatoInicial.isEmpty() ){
		try{
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			String nuevaCadena =  fechaFormatoInicial.split("/")[1]+"/" +fechaFormatoInicial.split("/")[0] +"/" +  fechaFormatoInicial.split("/")[2];
			Date d1 = df.parse(nuevaCadena);
			return df.format(d1)
		}catch(Exception ex){
			Logger.getLogger("getFechaConfiar").log(Level.SEVERE, "Error convirtiendo fecha: " + fechaFormatoInicial + " Mensaje: " + ex.getMessage())
		}
	}
	return ""
}

static getFieldString(String value){
	return value.replace("|",",")
}

static getFieldNumeric(Object value){
	return value.replace(".",",")
}

static getStringField(Object field){
	return field.trim().replace(",","|")
}

static getStringNumericField(Object field){
	return field.trim().replace(".","").replace(",",".")
}

static getStringObject(Object obj) {
	return obj.inspect().replace(",","|").replace("'",";")
}
 
static getObjectString(String value){
	return Eval.me(value.replace("'","").replace("|",",").replace(";","'"))
}

static sumarValoresCampos(String... valoresCampos){
	def total = 0
	DecimalFormat dfFormulario = getDecimalFormatForms()
	valoresCampos.each{
		valor ->
		try{
			total += dfFormulario.parse(valor)
		}catch(Exception ex){
		}
	}
	return dfFormulario.format(total)
}

static formatGroupData(groupData){
	def resultado = []
	
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	
	groupData.each{
		row->
		
		def rowData = [:]
		row.each{
			k, v->
			def value
			
			if(v instanceof java.util.Date){
				value = format.format(v)
			}else if (v instanceof java.lang.String){
				value = v.trim()
			}else{
				value = v
			}
			rowData.put(k, value)
						
		}
		
		resultado.add(rowData)
	}
	
	return resultado
}


static formatGroupData2(groupData){
	def resultado = []
	
	SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	
	groupData.each{
		row->
		
		def rowData = [:]
		row.each{
			k, v->
			def value
			
			if(v instanceof java.util.Date){
				value = format.format(v)
			}else if (v instanceof java.lang.String){
				value = v.trim()
			}else{
				value = v
			}
			rowData.put(k, value)
						
		}
		
		resultado.add(rowData)
	}
	
	return resultado
}