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

	public static List<PostData> getPostData() {
		// Should connect to some database manager and return data.
		//  For testing, just create test PostData object
		List<PostData> data = new ArrayList<PostData>();
		data.add(new PostData("bike", "Schwinn 10 speed - almost new!", 50.0,
				 new Seller("Joe Cool"), new Buyer("Jill Cool")));
		data.add(new PostData("book", "Moby Dick - a classic!", 2.0,
				 new Seller("Hermann Melville"), new Buyer("Mark Twain")));
		
		return data;
	}
}
