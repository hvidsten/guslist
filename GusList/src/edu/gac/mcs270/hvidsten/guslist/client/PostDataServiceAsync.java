package edu.gac.mcs270.hvidsten.guslist.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.gac.mcs270.hvidsten.guslist.shared.PostData;


public interface PostDataServiceAsync {
	public void getPostDataFromServer(AsyncCallback<List<PostData>> asyncCallback);
}
