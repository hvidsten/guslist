package edu.gac.mcs270.hvidsten.guslist.client;

import edu.gac.mcs270.hvidsten.guslist.shared.AdData;
import edu.gac.mcs270.hvidsten.guslist.shared.FieldVerifier;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;

public class GusList implements EntryPoint {
	private final GusListView glView = new GusListView();
	private final AdDataServiceAsync adDataService = GWT
			.create(AdDataService.class);

	public void onModuleLoad() {
	    // Wire controller to view
		//  Note: Model is on server side - can only
		//   communicate to Model through RPC calls
		//   Cannot wire it directly as a class attribute
		glView.setController(GusList.this);
		// Show welcome page
		glView.viewWelcomePage();
		//RootPanel rootPanel = RootPanel.get();
		//rootPanel.clear();
	}
	
	
	public GusListView getView() {
		return glView;
	}
	
	public void viewAdDataFromServer() {
		AdData[] results = null;
		adDataService.getAdDataFromServer(
				new AsyncCallback<AdData>() {
					public void onFailure(Throwable caught) {
						return;
					}

					@Override
					public void onSuccess(AdData data) {
						glView.viewAdData(data);
					}
				});
	}
}
