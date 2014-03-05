package edu.gac.mcs270.hvidsten.guslist.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.gac.mcs270.hvidsten.guslist.client.AdPostDataService;
import edu.gac.mcs270.hvidsten.guslist.shared.PostData;


@SuppressWarnings("serial")
public class AdPostDataServiceImpl extends RemoteServiceServlet implements
		AdPostDataService {

	@Override
	public void addPostDataToServer(PostData post) {
		// TODO Auto-generated method stub
		GusListModel.createPostData(post);
	}
}
