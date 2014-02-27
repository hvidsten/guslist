package edu.gac.mcs270.hvidsten.guslist.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.gac.mcs270.hvidsten.guslist.shared.PostData;
@RemoteServiceRelativePath("addpost") 
public interface AddPostDataService extends RemoteService {
		
		
	public void addPostDataToServer(PostData post);
		
}
