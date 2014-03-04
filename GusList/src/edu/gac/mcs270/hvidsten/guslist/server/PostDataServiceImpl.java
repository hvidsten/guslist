package edu.gac.mcs270.hvidsten.guslist.server;

import java.util.List;

import edu.gac.mcs270.hvidsten.guslist.client.PostDataService;
import edu.gac.mcs270.hvidsten.guslist.shared.PostData;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class PostDataServiceImpl extends RemoteServiceServlet implements
		PostDataService {
	
	private GusListModel model = new GusListModel();

	public List<PostData> getPostDataFromServer() { 
		List<PostData> data = model.getPostData();
		return data;
	}

	public void addPostDataToServer(PostData postData) {
		model.addPost(postData);
	}
}
