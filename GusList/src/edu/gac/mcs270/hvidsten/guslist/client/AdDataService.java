package edu.gac.mcs270.hvidsten.guslist.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.gac.mcs270.hvidsten.guslist.shared.AdData;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface AdDataService extends RemoteService {
	AdData getAdDataFromServer();
}
