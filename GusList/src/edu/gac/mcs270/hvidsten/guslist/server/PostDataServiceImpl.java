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

	public List<PostData> getPostDataFromServer() { 
		List<PostData> data = GusListModel.getPostData();
		return data;
	}
	
	GusListModel database = new GusListModel();
	
	public void addPostDataToServer(PostData entry){
		GusListModel.addPostData(entry);
	}

	
}
