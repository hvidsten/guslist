package edu.gac.mcs270.hvidsten.guslist.server;

import edu.gac.mcs270.hvidsten.guslist.client.AdDataService;
import edu.gac.mcs270.hvidsten.guslist.client.GusList;
import edu.gac.mcs270.hvidsten.guslist.shared.AdData;
import edu.gac.mcs270.hvidsten.guslist.shared.FieldVerifier;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class AdDataServiceImpl extends RemoteServiceServlet implements
		AdDataService {

	public AdData getAdDataFromServer() throws IllegalArgumentException{ 
		return GusListModel.getAdData();
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");
	}
}
