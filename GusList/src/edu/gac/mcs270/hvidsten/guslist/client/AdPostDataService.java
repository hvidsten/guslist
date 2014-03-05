package edu.gac.mcs270.hvidsten.guslist.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.gac.mcs270.hvidsten.guslist.shared.PostData;

@RemoteServiceRelativePath("addpost") 

public interface AdPostDataService extends RemoteService {
	void addPostDataToServer(PostData post);
}
