package edu.gac.mcs270.hvidsten.guslist.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.gac.mcs270.hvidsten.guslist.client.AddPostDataService;
import edu.gac.mcs270.hvidsten.guslist.shared.PostData;


@SuppressWarnings("serial")
public class AddPostDataServiceImpl extends RemoteServiceServlet implements AddPostDataService {

	@Override
	public void addPostDataToServer(PostData post) {
		GusListModel.addPost(post);
		//System.out.println("got to server");
	}

}
