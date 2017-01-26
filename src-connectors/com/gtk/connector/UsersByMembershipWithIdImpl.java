/**
 * 
 */
package com.gtk.connector;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

import org.bonitasoft.engine.api.IdentityAPI;
import org.bonitasoft.engine.connector.ConnectorException;
import org.bonitasoft.engine.identity.Role;
import org.bonitasoft.engine.identity.User;
import org.bonitasoft.engine.identity.UserMembership;

/**
 * The connector execution will follow the steps 1 - setInputParameters() -->
 * the connector receives input parameters values 2 - validateInputParameters()
 * --> the connector can validate input parameters values 3 - connect() --> the
 * connector can establish a connection to a remote server (if necessary) 4 -
 * executeBusinessLogic() --> execute the connector 5 - getOutputParameters()
 * --> output are retrieved from connector 6 - disconnect() --> the connector
 * can close connection to remote server (if any)
 */
public class UsersByMembershipWithIdImpl extends
		AbstractUsersByMembershipWithIdImpl {

	@Override
	protected void executeBusinessLogic() throws ConnectorException {
		// Get access to the connector input parameters
		// getGrupo();
		// getRol();

		try {
			IdentityAPI api = apiAccessor.getIdentityAPI();
			Map<String, String> mapaUsuarios = new HashMap<String, String>();
			Role rol = api.getRoleByName(getRol());

			List<UserMembership> membresiasRol = api.getUserMembershipsByRole(
					rol.getId(), 0, 250);

			for (UserMembership membresia : membresiasRol) {

				if (membresia.getGroupName().equals(getGrupo())) {

					User usuarioAsociado = api.getUserByUserName(membresia
							.getUsername());

					String usuarioConcat = usuarioAsociado.getFirstName() + " "
							+ usuarioAsociado.getLastName();
					String usuarioConId = usuarioAsociado.getId()
							+ "-" + usuarioConcat;
					mapaUsuarios.put(usuarioConcat, usuarioConId);
				}

			}

			Map<String, String> treeMap = new TreeMap<String, String>(mapaUsuarios);
			setMapaUsuarios(treeMap);
		} catch (Exception e) {

			e.printStackTrace();
		}

		// WARNING : Set the output of the connector execution. If outputs are
		// not set, connector fails
		// setMapaUsuarios(mapaUsuarios);

	}

	@Override
	public void connect() throws ConnectorException {
		// [Optional] Open a connection to remote server

	}

	@Override
	public void disconnect() throws ConnectorException {
		// [Optional] Close connection to remote server

	}

}