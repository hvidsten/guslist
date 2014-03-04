/*
 * Model class for GusList app. 
 * Note: Model is on server side. Messages passed to Model
 *  from Controller must be done through RPC methods. 
 *  Model has static methods to simplify RPC calls 
 *    (see AdDataServiceImpl.java)
 */
package edu.gac.mcs270.hvidsten.guslist.server;

import java.util.ArrayList;
import java.util.List;

import edu.gac.mcs270.hvidsten.guslist.shared.PostData;
import edu.gac.mcs270.hvidsten.guslist.shared.Buyer;
import edu.gac.mcs270.hvidsten.guslist.shared.Seller;

public class GusListModel {

//	private static List<PostData> PostData();
//		// Should connect to some database manager and return data.
//		//  For testing, just create test PostData object
//		List<PostData> data = new ArrayList<PostData>();
//		data.add(new PostData("bike", "Schwinn 10 speed - almost new!", 50.0,
//				 new Seller("Joe Cool"), new Buyer("Jill Cool")));
//		data.add(new PostData("book", "Moby Dick - a classic!", 2.0,
//				 new Seller("Hermann Melville"), new Buyer("Mark Twain")));
//		
//		return data;
//		
//	}
	
	private static List<PostData> data;
	
	public void GustListModel(){
		data = new ArrayList<PostData>();
		data.add(new PostData("bike", "Schwinn 10 speed - almost new!", 50.0,
				 new Seller("Joe Cool"), new Buyer("Jill Cool")));
		data.add(new PostData("book", "Moby Dick - a classic!", 2.0,
				 new Seller("Hermann Melville"), new Buyer("Mark Twain")));
	}
	
	
	public static List<PostData> getPostData(){
		return data;
	}
	public static void setPostData(List<PostData> rename){
		data = rename;
	}
	
	public static void addPostData(PostData post){
		data.add(post);
	}
	

}
