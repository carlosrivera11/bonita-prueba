import FunctionsDataBase

static getMessage(jndi, codigo){
	def sql = "Select descripcion FROM mensajes where codigo = '" + codigo + "'"
	return FunctionsDataBase.getSingleData(jndi, sql)
}

static getCiudad(jndi, descripcion){
	def sql = "Select Codigo FROM Ciudad where Descripcion = '" + descripcion + "'"
	return FunctionsDataBase.getSingleData(jndi, sql)
}

static getCodigoBarrio(jndi, descripcion){
	def sql = "Select Codigo FROM Barrio where Descripcion = '" + descripcion + "'"
	return FunctionsDataBase.getSingleData(jndi, sql)
}

static getParentesco(jndi, descripcion){
	def sql = "Select Codigo FROM Parentesco where Descripcion = '" + descripcion + "'"
	return FunctionsDataBase.getSingleData(jndi, sql)
}

static getActividadLaboral(jndi, codigo){
	def sql = "Select Descripcion FROM ActividadLaboral where Descripcion = '" + codigo + "'"
	return FunctionsDataBase.getSingleData(jndi, sql)
}

static getCargo(jndi, descripcion){
	def sql = "Select Codigo FROM Cargo where Descripcion = '" + descripcion + "'"
	return FunctionsDataBase.getSingleData(jndi, sql)
}

static getNivelEducativo(jndi, descripcion){
	def sql = "Select Codigo FROM NivelEducativo where Descripcion = '" + descripcion + "'"
	return FunctionsDataBase.getSingleData(jndi, sql)
}

static getTipoDocumento(jndi, descripcion){
	def sql = "Select Codigo FROM TipoDocumento where Descripcion = '" + descripcion + "'"
	return FunctionsDataBase.getSingleData(jndi, sql)
}

static getCodigoAsesor(jndi, descripcion){
	def sql = "Select Codigo FROM AsesorVenta where Descripcion = '" + descripcion + "'"
	return FunctionsDataBase.getSingleData(jndi, sql)
}

static getCodigoProducto(jndi, descripcion){
	def sql = "Select Codigo FROM Producto where Descripcion = '" + descripcion + "'"
	return FunctionsDataBase.getSingleData(jndi, sql)
}

static getCodigoAgencia(jndi, descripcion){
	def sql = "Select Codigo FROM Agencia where Descripcion = '" + descripcion + "'"
	return FunctionsDataBase.getSingleData(jndi, sql)
}

static getDescripcionAgencia(jndi, codigo){
	def sql = "Select Descripcion FROM Agencia where Codigo = '" + codigo + "'"
	return FunctionsDataBase.getSingleData(jndi, sql)
}

static getCodigoFormaPago(jndi, descripcion){
	def sql = "Select Codigo FROM FormaPago where Descripcion = '" + descripcion + "'"
	return FunctionsDataBase.getSingleData(jndi, sql)
}

static getCiudadDescripcion(jndi, codigo){
	def sql = "Select Descripcion FROM Ciudad where Descripcion = '" + codigo + "'"
	return FunctionsDataBase.getSingleData(jndi, sql)
}

static getParentescoDescripcion(jndi, codigo){
	def sql = "Select Descripcion FROM Parentesco where cast(codigo as varchar(20)) = '" + codigo + "'"
	return FunctionsDataBase.getSingleData(jndi, sql)
}

static getNivelEducativoDescripcion(jndi, codigo){
	def sql = "Select Descripcion FROM NivelEducativo where cast(codigo as varchar(20)) = '" + codigo + "'"
	return FunctionsDataBase.getSingleData(jndi, sql)
}

static getCodigoCargo(jndi, descripcion){
 def sql = "Select Codigo FROM Cargo where Descripcion = '" + descripcion + "'"
 return FunctionsDataBase.getSingleData(jndi, sql)
}

static getCodigoReporteAnualCostos(jndi, descripcion){
 def sql = "Select Codigo FROM ReciboReporteAnual where Descripcion = '" + descripcion + "'"
 return FunctionsDataBase.getSingleData(jndi, sql)
}

static getCodigoEstrato(jndi, descripcion){
 def sql = "Select Codigo FROM Estrato where Descripcion = '" + descripcion + "'"
 return FunctionsDataBase.getSingleData(jndi, sql)
}

static getCodigoEnvioCorrespondencia(jndi, descripcion){
 def sql = "Select Codigo FROM EnvioCorrespondencia where Descripcion = '" + descripcion + "'"
 return FunctionsDataBase.getSingleData(jndi, sql)
}

static getCodigoActividadLaboral(jndi, descripcion){
	def sql = "Select Codigo FROM ActividadLaboral where Descripcion = '" + descripcion + "'"
	return FunctionsDataBase.getSingleData(jndi, sql)
}

static getCodigoNacionalidad(jndi, descripcion){
	def sql = "Select Codigo FROM Pais where Descripcion = '" + descripcion + "'"
	return FunctionsDataBase.getSingleData(jndi, sql)
}