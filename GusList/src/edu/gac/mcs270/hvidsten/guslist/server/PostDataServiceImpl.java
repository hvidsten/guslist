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

	private GusListModel Model = new GusListModel();
	public List<PostData> getPostDataFromServer() { 
		List data = Model.getPostData();
		return data;
	}
	
	public void addPostDataToServer(PostData post){
		Model.addPostData(post);
	}
	
}
