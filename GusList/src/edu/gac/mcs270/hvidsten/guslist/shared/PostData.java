package edu.gac.mcs270.hvidsten.guslist.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

// All Objects that will be passed from server to client (or vice-versa) 
// must implement the IsSerializable interface
public class PostData implements IsSerializable {
	private String title="no title";
	private String description="empty";
	private double price=0.0;
	private Seller seller=null;
	private Buyer buyer=null;
	
	// GWT serializable Objects need a no=argument constructor
	public PostData() {}
	
	public PostData(String t, String d, double p, Seller s, Buyer b){
		title = t;
		description = d;
		price = p;
		seller = s;
		buyer = b;
	}
	
	public PostData(String t, String d, double p, Seller s){
		title = t;
		description = d;
		price = p;
		seller = s;
	}

	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public double getPrice(){
		return price;
	}
	
	public Seller getSeller(){
		return seller;
	}
	
	public Buyer getBuyer() {
		return buyer;
	}
}

