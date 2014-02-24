package edu.gac.mcs270.hvidsten.guslist.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.gac.mcs270.hvidsten.guslist.shared.AdData;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface AdDataServiceAsync {
	void getAdDataFromServer(
			AsyncCallback<AdData> asyncCallback);
}
