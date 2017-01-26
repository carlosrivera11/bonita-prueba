import Functions

import java.util.logging.Logger
import java.util.logging.Level
	
static getRequestActualizarIngDatosCliente(Map mapaParams) {

	Logger LOG = Logger.getLogger("getRequestActualizarIngDatosCliente")
	
	try{
		def xmlEnviar = ""
		//def xmlWS = """<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:bpm="http://bpm.ejb.bdagencias.confiar.coop/"><soapenv:Header/><soapenv:Body><bpm:ActualizarIngDatosCliente><oActualizarIngDatosClientePeticion><actividadLaboral>{actividadLaboral}</actividadLaboral><agenciaAsesoria>{agenciaAsesoria}</agenciaAsesoria><agenciaSolicitante>{agenciaSolicitante}</agenciaSolicitante><ahorrosInversiones>{ahorrosInversiones}</ahorrosInversiones><apellido1>{apellido1}</apellido1><apellido2>{apellido2}</apellido2><areaPrestacion>{areaPrestacion}</areaPrestacion><arriendo>{arriendo}</arriendo><asesorVenta>{asesorVenta}</asesorVenta><asesorVisita>{asesorVisita}</asesorVisita><autorizaInformacionCanal>{autorizaInformacionCanal}</autorizaInformacionCanal><barrioResidencia>{barrioResidencia}</barrioResidencia><calificacionEmpresa>{calificacionEmpresa}</calificacionEmpresa><cargo>{cargo}</cargo><ciudadCuentaExterior>{ciudadCuentaExterior}</ciudadCuentaExterior>OP{ciudadDirEmpresa}<ciudadDirResidencia>{ciudadDirResidencia}</ciudadDirResidencia><ciudadExpDocumento>{ciudadExpDocumento}</ciudadExpDocumento><ciudadNacimiento>{ciudadNacimiento}</ciudadNacimiento>OP{ciudadNegocio}<ciudadOtraDireccion>{ciudadOtraDireccion}</ciudadOtraDireccion><codigoCIIU>{codigoCIIU}</codigoCIIU><comoConocioConfiar>{comoConocioConfiar}</comoConocioConfiar><conyugeRecibeIngresos>{conyugeRecibeIngresos}</conyugeRecibeIngresos><correoElectronico>{correoElectronico}</correoElectronico><cualConocioConfiar>{cualConocioConfiar}</cualConocioConfiar><cualNecesidad>{cualNecesidad}</cualNecesidad><cuotasAdicionales>OP{cuotasAdicionales}</cuotasAdicionales><cuotasDeudasCIFIN>OP{cuotasDeudasCIFIN}</cuotasDeudasCIFIN><cuotasDeudasDatacredito>OP{cuotasDeudasDatacredito}</cuotasDeudasDatacredito><declaraRenta>{declaraRenta}</declaraRenta><deduccionesLegales>OP{deduccionesLegales}</deduccionesLegales><descripcionNecesidad>{descripcionNecesidad}</descripcionNecesidad><deudasFinanciera>OP{deudasFinanciera}</deudasFinanciera><deudasTerceros>OP{deudasTerceros}</deudasTerceros><digitoV>{digitoV}</digitoV>OP{direccioNegocio}<direccionEmpresa>{direccionEmpresa}</direccionEmpresa><direccionResidencia>{direccionResidencia}</direccionResidencia><empresa>{empresa}</empresa><entidadExterior>{entidadExterior}</entidadExterior><envioCorrespondencia>{envioCorrespondencia}</envioCorrespondencia><envioTC>{envioTC}</envioTC><estadoCivil>{estadoCivil}</estadoCivil><estrato>{estrato}</estrato><extension>{extension}</extension><familiarTrabajeConfiar>{familiarTrabajeConfiar}</familiarTrabajeConfiar><fechaExpedicionDoc>{fechaExpedicionDoc}</fechaExpedicionDoc><fechaIngreso>{fechaIngreso}</fechaIngreso><fechaInicioOperacion>{fechaInicioOperacion}</fechaInicioOperacion><fechaNacimiento>{fechaNacimiento}</fechaNacimiento><fechaUltimaVisitaNegocio>{fechaUltimaVisitaNegocio}</fechaUltimaVisitaNegocio><gastosFamiliares>{gastosFamiliares}</gastosFamiliares><genero>{genero}</genero><identificacion>{identificacion}</identificacion><indicativo>{indicativo}</indicativo><manejaCuentasExterior>{manejaCuentasExterior}</manejaCuentasExterior><manejaRecursosPublicos>{manejaRecursosPublicos}</manejaRecursosPublicos><montoCuentaExterior>{montoCuentaExterior}</montoCuentaExterior><nacionalidad>{nacionalidad}</nacionalidad><nitEmpresa>{nitEmpresa}</nitEmpresa><nitFamiliarConfiar>{nitFamiliarConfiar}</nitFamiliarConfiar><nivelEducativo>{nivelEducativo}</nivelEducativo><nombre>{nombre}</nombre><nombreArrendador>{nombreArrendador}</nombreArrendador><nombreArrendadorLocal>{nombreArrendadorLocal}</nombreArrendadorLocal><nombreFamiliarConfiar>{nombreFamiliarConfiar}</nombreFamiliarConfiar><nombreNegocio>{nombreNegocio}</nombreNegocio><numUnidadesNegocio>{numUnidadesNegocio}</numUnidadesNegocio><numeroAsesoria>{numeroAsesoria}</numeroAsesoria><numeroCuentaExterior>{numeroCuentaExterior}</numeroCuentaExterior><numeroEmpresas>{numeroEmpresas}</numeroEmpresas><numeroHijos>{numeroHijos}</numeroHijos><operacionMonedaExtranjera>{operacionMonedaExtranjera}</operacionMonedaExtranjera><otraDireccion>{otraDireccion}</otraDireccion><otrasDeducciones>{otrasDeducciones}</otrasDeducciones><otrosActivos>{otrosActivos}</otrosActivos><otrosGastos>OP{otrosGastos}</otrosGastos><otrosIngresosFamiliares>{otrosIngresosFamiliares}</otrosIngresosFamiliares><otrosIngresosPropios>{otrosIngresosPropios}</otrosIngresosPropios><otrosPasivos>OP{otrosPasivos}</otrosPasivos><pagaIndustriaComercio>{pagaIndustriaComercio}</pagaIndustriaComercio><paisCuenta>{paisCuenta}</paisCuenta><parentescoFamiliar>{parentescoFamiliar}</parentescoFamiliar><pension>{pension}</pension><personaPEPS>{personaPEPS}</personaPEPS><personasCargo>{personasCargo}</personasCargo><poseeVehiculo>{poseeVehiculo}</poseeVehiculo><primeraVezSectorFinanciero>{primeraVezSectorFinanciero}</primeraVezSectorFinanciero><propiedadRaiz>{propiedadRaiz}</propiedadRaiz><regimenSeguridadSocial>{regimenSeguridadSocial}</regimenSeguridadSocial><registradoCamaraComercio>{registradoCamaraComercio}</registradoCamaraComercio><renovacionesContrato>{renovacionesContrato}</renovacionesContrato><reporteAnualCostos>{reporteAnualCostos}</reporteAnualCostos><requiereVisitaNegocio>{requiereVisitaNegocio}</requiereVisitaNegocio><salario>{salario}</salario>OP{sectorActividadEconomica}<tamanoEmpresa>{tamanoEmpresa}</tamanoEmpresa>OP{telefonoArrendador}<telefonoArrendadorLocal>{telefonoArrendadorLocal}</telefonoArrendadorLocal>OP{telefonoEmpresa}<telefonoFamiliar>{telefonoFamiliar}</telefonoFamiliar><telefonoFijo>{telefonoFijo}</telefonoFijo><telefonoMovil>{telefonoMovil}</telefonoMovil>OP{telefonoNegocio}<tiempoMeses>{tiempoMeses}</tiempoMeses><tieneRUT>{tieneRUT}</tieneRUT>OP{tieneReferenciasComerciales}<tieneUnidadNegocio>{tieneUnidadNegocio}</tieneUnidadNegocio><tipoAsesoria>{tipoAsesoria}</tipoAsesoria><tipoContrato>{tipoContrato}</tipoContrato><tipoDocumento>{tipoDocumento}</tipoDocumento>OP{tipoLocal}<tipoMoneda>{tipoMoneda}</tipoMoneda>OP{tipoNegocio}<tipoNominaSector>{tipoNominaSector}</tipoNominaSector><tipoOperacionExterior>{tipoOperacionExterior}</tipoOperacionExterior><tipoProductoExterior>{tipoProductoExterior}</tipoProductoExterior><tipoSolicitante>{tipoSolicitante}</tipoSolicitante><tipoVivienda>{tipoVivienda}</tipoVivienda><tituloObtenido>{tituloObtenido}</tituloObtenido><totaOtrosIngresos>{totaOtrosIngresos}</totaOtrosIngresos><totalActivos>{totalActivos}</totalActivos><totalEgresos>OP{totalEgresos}</totalEgresos><totalIngresos>{totalIngresos}</totalIngresos><totalPasivos>{totalPasivos}</totalPasivos>OP{ubicacionPuestoTrabajo}<valorPropiedad>OP{valorPropiedad}</valorPropiedad><valorVehiculo>OP{valorVehiculo}</valorVehiculo></oActualizarIngDatosClientePeticion></bpm:ActualizarIngDatosCliente></soapenv:Body></soapenv:Envelope>"""
		def xmlWS = """<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:bpm="http://bpm.ejb.bdagencias.confiar.coop/"><soapenv:Header/><soapenv:Body><bpm:ActualizarIngDatosCliente><oActualizarIngDatosClientePeticion><actividadLaboral>{actividadLaboral}</actividadLaboral><agenciaAsesoria>{agenciaAsesoria}</agenciaAsesoria><agenciaSolicitante>{agenciaSolicitante}</agenciaSolicitante><ahorrosInversiones>{ahorrosInversiones}</ahorrosInversiones><apellido1>{apellido1}</apellido1><apellido2>{apellido2}</apellido2><areaPrestacion>{areaPrestacion}</areaPrestacion>OP{arriendo}<asesorVenta>{asesorVenta}</asesorVenta><asesorVisita>{asesorVisita}</asesorVisita><autorizaInformacionCanal>{autorizaInformacionCanal}</autorizaInformacionCanal><barrioResidencia>{barrioResidencia}</barrioResidencia>OP{calificacionEmpresa}<cargo>{cargo}</cargo><ciudadCuentaExterior>{ciudadCuentaExterior}</ciudadCuentaExterior>OP{ciudadDirEmpresa}<ciudadDirResidencia>{ciudadDirResidencia}</ciudadDirResidencia><ciudadExpDocumento>{ciudadExpDocumento}</ciudadExpDocumento><ciudadNacimiento>{ciudadNacimiento}</ciudadNacimiento>OP{ciudadNegocio}<ciudadOtraDireccion>{ciudadOtraDireccion}</ciudadOtraDireccion><codigoCIIU>{codigoCIIU}</codigoCIIU>OP{comoConocioConfiar}<conyugeRecibeIngresos>{conyugeRecibeIngresos}</conyugeRecibeIngresos><correoElectronico>{correoElectronico}</correoElectronico>OP{cualConocioConfiar}<cualNecesidad>{cualNecesidad}</cualNecesidad>OP{cuotasAdicionales}OP{cuotasDeudasCIFIN}OP{cuotasDeudasDatacredito}<declaraRenta>{declaraRenta}</declaraRenta>OP{deduccionesLegales}OP{descripcionNecesidad}OP{deudasFinanciera}OP{deudasTerceros}<digitoV>{digitoV}</digitoV>OP{direccioNegocio}<direccionEmpresa>{direccionEmpresa}</direccionEmpresa><direccionResidencia>{direccionResidencia}</direccionResidencia><empresa>{empresa}</empresa>OP{entidadExterior}<envioCorrespondencia>{envioCorrespondencia}</envioCorrespondencia><envioTC>{envioTC}</envioTC><estadoCivil>{estadoCivil}</estadoCivil><estrato>{estrato}</estrato>OP{extension}<familiarTrabajeConfiar>{familiarTrabajeConfiar}</familiarTrabajeConfiar><fechaExpedicionDoc>{fechaExpedicionDoc}</fechaExpedicionDoc>OP{fechaIngreso}OP{fechaInicioOperacion}<fechaNacimiento>{fechaNacimiento}</fechaNacimiento>OP{fechaUltimaVisitaNegocio}<gastosFamiliares>{gastosFamiliares}</gastosFamiliares><genero>{genero}</genero><identificacion>{identificacion}</identificacion>OP{listasReferencias}OP{listasOtrosIngreso}<indicativo>{indicativo}</indicativo><manejaCuentasExterior>{manejaCuentasExterior}</manejaCuentasExterior><manejaRecursosPublicos>{manejaRecursosPublicos}</manejaRecursosPublicos><montoCuentaExterior>{montoCuentaExterior}</montoCuentaExterior><nacionalidad>{nacionalidad}</nacionalidad><nitEmpresa>{nitEmpresa}</nitEmpresa><nitFamiliarConfiar>{nitFamiliarConfiar}</nitFamiliarConfiar><nivelEducativo>{nivelEducativo}</nivelEducativo><nombre>{nombre}</nombre>OP{nombreArrendador}OP{nombreArrendadorLocal}OP{nombreFamiliarConfiar}OP{nombreNegocio}<numUnidadesNegocio>{numUnidadesNegocio}</numUnidadesNegocio><numeroAsesoria>{numeroAsesoria}</numeroAsesoria>OP{numeroCuentaExterior}OP{numeroEmpresas}<numeroHijos>{numeroHijos}</numeroHijos><operacionMonedaExtranjera>{operacionMonedaExtranjera}</operacionMonedaExtranjera>OP{otraDireccion}OP{otrasDeducciones}<otrosActivos>{otrosActivos}</otrosActivos>OP{otrosGastos}OP{otrosIngresosFamiliares}<otrosIngresosPropios>{otrosIngresosPropios}</otrosIngresosPropios>OP{otrosPasivos}OP{pagaIndustriaComercio}OP{paisCuenta}<parentescoFamiliar>{parentescoFamiliar}</parentescoFamiliar>OP{pension}<personaPEPS>{personaPEPS}</personaPEPS><personasCargo>{personasCargo}</personasCargo><poseeVehiculo>{poseeVehiculo}</poseeVehiculo><primeraVezSectorFinanciero>{primeraVezSectorFinanciero}</primeraVezSectorFinanciero><propiedadRaiz>{propiedadRaiz}</propiedadRaiz><regimenSeguridadSocial>{regimenSeguridadSocial}</regimenSeguridadSocial>OP{registradoCamaraComercio}OP{renovacionesContrato}<reporteAnualCostos>{reporteAnualCostos}</reporteAnualCostos><requiereVisitaNegocio>{requiereVisitaNegocio}</requiereVisitaNegocio><salario>{salario}</salario>OP{sectorActividadEconomica}OP{tamanoEmpresa}OP{telefonoArrendador}OP{telefonoArrendadorLocal}OP{telefonoEmpresa}OP{telefonoFamiliar}<telefonoFijo>{telefonoFijo}</telefonoFijo><telefonoMovil>{telefonoMovil}</telefonoMovil>OP{telefonoNegocio}OP{tiempoMeses}<tieneRUT>{tieneRUT}</tieneRUT>OP{tieneReferenciasComerciales}<tieneUnidadNegocio>{tieneUnidadNegocio}</tieneUnidadNegocio><tipoAsesoria>{tipoAsesoria}</tipoAsesoria>OP{tipoContrato}<tipoDocumento>{tipoDocumento}</tipoDocumento>OP{tipoLocal}<tipoMoneda>{tipoMoneda}</tipoMoneda>OP{tipoNegocio}<tipoNominaSector>{tipoNominaSector}</tipoNominaSector><tipoOperacionExterior>{tipoOperacionExterior}</tipoOperacionExterior>OP{tipoProductoExterior}<tipoSolicitante>{tipoSolicitante}</tipoSolicitante><tipoVivienda>{tipoVivienda}</tipoVivienda><tituloObtenido>{tituloObtenido}</tituloObtenido>OP{totaOtrosIngresos}OP{totalActivos}OP{totalEgresos}<totalIngresos>{totalIngresos}</totalIngresos>OP{totalPasivos}OP{ubicacionPuestoTrabajo}OP{valorPropiedad}OP{valorVehiculo}</oActualizarIngDatosClientePeticion></bpm:ActualizarIngDatosCliente></soapenv:Body></soapenv:Envelope>"""
		xmlEnviar = FunctionsWebService.putXmlData(xmlWS, mapaParams)
		
		return xmlEnviar
	} catch(Exception ex){
		return ex.getMessage()
		LOG.log(Level.SEVERE, ex.getMessage())
		throw ex
	}
}


static getRequestListaGrupoFamiliarRespuesta(Map mapaParams) {
	
		Logger LOG = Logger.getLogger("getRequestListaGrupoFamiliar")
		
		try{
			def xmlEnviar = ""
			def xmlWS = """<listaGrupoFamiliarRespuesta><actividadLaboralFamiliar>{actividadLaboralFamiliar}</actividadLaboralFamiliar><apellidoFamiliar1>{apellidoFamiliar1}</apellidoFamiliar1><apellidoFamiliar2>{apellidoFamiliar2}</apellidoFamiliar2><beneficiarioSocial>{beneficiarioSocial}</beneficiarioSocial><cargoFamiliar>{cargoFamiliar}</cargoFamiliar><ciudadFamiliar>{ciudadFamiliar}</ciudadFamiliar><fechaNacimientoFamiliar>{fechaNacimientoFamiliar}</fechaNacimientoFamiliar><generoFamiliar>{generoFamiliar}</generoFamiliar><nitFamiliar>{nitFamiliar}</nitFamiliar><nivelEducativoFamiliar>{nivelEducativoFamiliar}</nivelEducativoFamiliar><nombreFamiliar>{nombreFamiliar}</nombreFamiliar><parentescoFamiliar>{parentescoFamiliar}</parentescoFamiliar><telefonoFamiliar>{telefonoFamiliar}</telefonoFamiliar><tipoDocumentoFamiliar>{tipoDocumentoFamiliar}</tipoDocumentoFamiliar></listaGrupoFamiliarRespuesta>"""
		
		xmlEnviar = FunctionsWebService.putXmlData(xmlWS, mapaParams)		
		
		return xmlEnviar
	} catch(Exception ex){
		return ex.getMessage()
		LOG.log(Level.SEVERE, ex.getMessage())
		throw ex
	}

}


static getRequestListaOtrosIngresosRespuesta(Map mapaParams) {
	
		Logger LOG = Logger.getLogger("getRequestListaOtrosIngresosRespuesta")
		
		try{
			def xmlEnviar = ""
			def xmlWS = """<listaOtrosIngresosRespuesta><baseIngresosFamiliares>{baseIngresosFamiliares}</baseIngresosFamiliares><baseIngresosPropios>{baseIngresosPropios}</baseIngresosPropios><fuenteOtrosIngresos>{fuenteOtrosIngresos}</fuenteOtrosIngresos><ingresosFamiliares>{ingresosFamiliares}</ingresosFamiliares><ingresosPropios>{ingresosPropios}</ingresosPropios><procentajeTomado>{procentajeTomado}</procentajeTomado></listaOtrosIngresosRespuesta>"""
		
		xmlEnviar = FunctionsWebService.putXmlData(xmlWS, mapaParams)
		
		return xmlEnviar
	} catch(Exception ex){
		return ex.getMessage()
		LOG.log(Level.SEVERE, ex.getMessage())
		throw ex
	}
}


static getRequestActualizarDatosClienteServicios(Map mapaParams) {

	Logger LOG = Logger.getLogger("getRequestActualizarDatosClienteServicios")
	
	try{
		def xmlEnviar = ""
		def xmlWS = """<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:bpm="http://bpm.ejb.bdagencias.confiar.coop/"><soapenv:Header/><soapenv:Body><bpm:ActualizarDatosClienteServicios><oActualizarDatosClienteServiciosPeticion><actividadLaboral>{actividadLaboral}</actividadLaboral><agenciaAsesoria>{agenciaAsesoria}</agenciaAsesoria>OP{autorizaInformacionCanal}OP{barrioResidencia}OP{cargo}OP{ciudadDirEmpresa}<ciudadDirResidencia>{ciudadDirResidencia}</ciudadDirResidencia><codigoAsesor>{codigoAsesor}</codigoAsesor>OP{correoElectronico}OP{direccionEmpresa}<direccionResidencia>{direccionResidencia}</direccionResidencia>OP{empresa}<envioCorrespondencia>{envioCorrespondencia}</envioCorrespondencia><estrato>{estrato}</estrato>OP{extension}<identificacion>{identificacion}</identificacion>OP{indicativo}OP{listasOtrosIngreso}<nacionalidad>{nacionalidad}</nacionalidad>OP{otraDireccion}OP{otrosIngresosFamiliares}OP{otrosIngresosPropios}OP{pension}<reporteAnualCostos>{reporteAnualCostos}</reporteAnualCostos>OP{salario}OP{telefonoEmpresa}OP{telefonoFijo}OP{telefonoMovil}OP{tieneUnidadNegocio}<tipoDocumento>{tipoDocumento}</tipoDocumento>OP{totaOtrosIngresos}<totalIngresos>{totalIngresos}</totalIngresos></oActualizarDatosClienteServiciosPeticion></bpm:ActualizarDatosClienteServicios></soapenv:Body></soapenv:Envelope>"""
		xmlEnviar = FunctionsWebService.putXmlData(xmlWS, mapaParams)
		
		return xmlEnviar
	} catch(Exception ex){
		return ex.getMessage()
		LOG.log(Level.SEVERE, ex.getMessage())
		throw ex
	}
}

static getRequestActualizarClienteAntiguo(Map mapaParams) {
	
		Logger LOG = Logger.getLogger("getRequestActualizarClienteAntiguo")
		
		try{
			def xmlEnviar = ""
			def xmlWS = """<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:bpm="http://bpm.ejb.bdagencias.confiar.coop/"><soapenv:Header/><soapenv:Body><bpm:ActualizarClienteAntiguo><oActualizarClienteAntiguoPeticion><actividadLaboral>{actividadLaboral}</actividadLaboral><agenciaAsesoria>{agenciaAsesoria}</agenciaAsesoria><asesorVenta>{asesorVenta}</asesorVenta><autorizaInformacionCanal>{autorizaInformacionCanal}</autorizaInformacionCanal>OP{barrioResidencia}OP{cargo}OP{ciudadDirEmpresa}<ciudadDirResidencia>{ciudadDirResidencia}</ciudadDirResidencia>OP{correoElectronico}OP{direccionEmpresa}<direccionResidencia>{direccionResidencia}</direccionResidencia>OP{empresa}<envioCorrespondencia>{envioCorrespondencia}</envioCorrespondencia><estrato>{estrato}</estrato>OP{extension}<genero>{genero}</genero><identificacion>{identificacion}</identificacion>OP{indicativo}OP{listasOtrosIngreso}<nacionalidad>{nacionalidad}</nacionalidad>OP{nombreNegocio}OP{numUnidadesNegocio}<numeroAsesoria>{numeroAsesoria}</numeroAsesoria>OP{otraDireccion}OP{otrosIngresosFamiliares}OP{otrosIngresosPropios}OP{pension}OP{personaPEPS}<reporteAnualCostos>{reporteAnualCostos}</reporteAnualCostos>OP{salario}OP{telefonoEmpresa}OP{telefonoFijo}OP{telefonoMovil}<tieneUnidadNegocio>{tieneUnidadNegocio}</tieneUnidadNegocio><tipoAsesoria>{tipoAsesoria}</tipoAsesoria><tipoDocumento>{tipoDocumento}</tipoDocumento><tipoSolicitante>{tipoSolicitante}</tipoSolicitante><totalIngresos>{totalIngresos}</totalIngresos>OP{totalOtrosIngresos}</oActualizarClienteAntiguoPeticion></bpm:ActualizarClienteAntiguo></soapenv:Body></soapenv:Envelope>"""
		xmlEnviar = FunctionsWebService.putXmlData(xmlWS, mapaParams)
		
		return xmlEnviar
	} catch(Exception ex){
		return ex.getMessage()
		LOG.log(Level.SEVERE, ex.getMessage())
		throw ex
	}
}