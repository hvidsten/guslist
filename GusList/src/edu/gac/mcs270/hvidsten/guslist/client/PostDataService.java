package edu.gac.mcs270.hvidsten.guslist.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.gac.mcs270.hvidsten.guslist.shared.PostData;

/**
 * The client side stub for the RPC service.
 */
// Note: Name needs to match url-pattern in web.xml
@RemoteServiceRelativePath("postdata") 
public interface PostDataService extends RemoteService {
	public List<PostData> getPostDataFromServer();

	void addPostDataToServer(PostData postData);

}
