package com.gtk.connector;

import org.bonitasoft.engine.connector.AbstractConnector;
import org.bonitasoft.engine.connector.ConnectorValidationException;

public abstract class AbstractUsersByMembershipWithIdImpl extends
		AbstractConnector {

	protected final static String GRUPO_INPUT_PARAMETER = "grupo";
	protected final static String ROL_INPUT_PARAMETER = "rol";
	protected final String MAPAUSUARIOS_OUTPUT_PARAMETER = "mapaUsuarios";

	protected final java.lang.String getGrupo() {
		return (java.lang.String) getInputParameter(GRUPO_INPUT_PARAMETER);
	}

	protected final java.lang.String getRol() {
		return (java.lang.String) getInputParameter(ROL_INPUT_PARAMETER);
	}

	protected final void setMapaUsuarios(java.util.Map mapaUsuarios) {
		setOutputParameter(MAPAUSUARIOS_OUTPUT_PARAMETER, mapaUsuarios);
	}

	@Override
	public void validateInputParameters() throws ConnectorValidationException {
		try {
			getGrupo();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("grupo type is invalid");
		}
		try {
			getRol();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("rol type is invalid");
		}

	}

}
