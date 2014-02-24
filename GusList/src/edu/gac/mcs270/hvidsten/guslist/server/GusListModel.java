/*
 * Model class for GusList app. 
 * Note: Model is on server side. Messages passed to Model
 *  from Controller must be done through RPC methods. 
 *  Model has static methods to simplify RPC calls 
 *    (see AdDataServiceImpl.java)
 */
package edu.gac.mcs270.hvidsten.guslist.server;

import edu.gac.mcs270.hvidsten.guslist.client.GusList;
import edu.gac.mcs270.hvidsten.guslist.shared.AdData;
import edu.gac.mcs270.hvidsten.guslist.shared.Buyer;
import edu.gac.mcs270.hvidsten.guslist.shared.Seller;

public class GusListModel {

	public static AdData getAdData() {
		// Should connect to some database manager and return data.
		//  For testing, just create test AdData object
		AdData data = new AdData();
		data.addDatum("bike", "Schwinn 10 speed - almost new!", 50.0,
				 new Seller("Joe Cool"), new Buyer("Jill Cool"));
		data.addDatum("book", "Moby Dick - a classic!", 2.0,
						 new Seller("Hermann Melville"), new Buyer("Mark Twain"));
		
		return null;
	}
}
