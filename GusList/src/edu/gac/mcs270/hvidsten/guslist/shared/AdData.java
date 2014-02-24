package edu.gac.mcs270.hvidsten.guslist.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class AdData implements Serializable{
	private static final long serialVersionUID = -6859712450638708061L;
	private List<Datum>data = new ArrayList<Datum>();
	
	public AdData(){}

	public void addDatum(String title, String descr, double price,
			Seller seller, Buyer buyer) {
		Datum d = new Datum(title, descr, price, seller, buyer);
		data.add(d);
	}
}

class Datum implements Serializable {
	private static final long serialVersionUID = 4315858349310884313L;
	private String title="";
	private String description="empty";
	private double price=0.0;
	private Seller seller=null;
	private Buyer buyer=null;
	
	public Datum(String t, String d, double p, Seller s, Buyer b){
		title = t;
		description = d;
		price = p;
		seller = s;
		buyer = b;
	}
}
