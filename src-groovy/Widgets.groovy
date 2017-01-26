/** Widgets
** 	V: 1.0
**	@author: Mauricio Barrantes
**	@date:	10/03/2016
**	@description
** 	Libreria de windgets alternos
**/
import java.text.SimpleDateFormat;

/**
 * Genera widget de calendario que almacena el valor seleccionado en un widget de tipo hidden para poder ser utilizado en Bonita
 * @param String label, titulo del widget
 * @param String value, valor inicial (precarga) de la fecha como texto, puede ir vacio.  Ver: Widgets.convertirFechaEnTexto
 * @param String dateFormatHtml, formato de fecha en tipo html (diferente de formato java). dd/mm/yy 31/12/2016
 * @param String className, se debe especificar el nombre de la clase responsable de guardar la fecha
 * @param bollean readonly, determina si el widget es de solo lectura (true). En caso de true, se puede obviar los parametros dateFormat y fieldName
 */
static String calendar(String label, String value, String dateFormatHtml, String className, boolean readonly){
	def random = Calendar.getInstance().getTimeInMillis() + className.replace(" ", "") + label.replace(" ", "")
	
	def html = """<div class="bonita_form_entry"><div class="bonita_form_vertical_panel"><div><div class="bonita_form_label bonita_form_label_top" style="font-size:15px;">{LABEL}</div><input type="text" id="datepicker{RND}" readonly class="bonita_form_field bonita_form_date bonita_form_field_bottom" value="{VALUE}"></div></div></div> {SCRIPT}""";
	def script = """<script>
		\$( "#datepicker{RND}" ).datepicker({
      		changeMonth: true, changeYear: true, yearRange: "-100:+0", dateFormat:'{DATE_FORMAT}', altField: ".{CLASS_NAME}"
    	});
	</script>""";


	return html.replace("{SCRIPT}", (readonly ? "" : script)).replace("{LABEL}",label).replace("{RND}", random.toString())
		.replace("{VALUE}",value).replace("{DATE_FORMAT}",dateFormatHtml).replace("{CLASS_NAME}",className);

}

/**
 * Convierte texto(String) en fecha(Date) dado un formato. Si el texto es null o vacio retorna la fecha actual.
 * @param String formatoFechaJava, formato de fecha, por ejemplo: "dd/MM/yyyy"
 * @param String fechaTexto, cadena de texto con la fecha a convertir, por ejemplo: "31/12/2016"
**/
static Date convertirTextoEnFecha(String formatoFechaJava, String fechaTexto){
	SimpleDateFormat sdf = new SimpleDateFormat(formatoFechaJava)
	
	if(fechaTexto == null || fechaTexto.isEmpty()){
		return new Date()
	}	
	
	return sdf.parse(fechaTexto)
}

/**
 * Convierte fecha(Date) en texto(String) dado un formato.
 * @param String formatoFechaJava, formato de fecha, por ejemplo: "dd/MM/yyyy"
 * @param Date fecha, variable de tipo Date con la fecha a convertir
**/
static String convertirFechaEnTexto(String formatoFechaJava, Date fecha){
	SimpleDateFormat sdf = new SimpleDateFormat(formatoFechaJava);
	def fechaTexto = "";
	if(fecha!= null) {
		fechaTexto = sdf.format(fecha);
	}
	return fechaTexto
}

