package edu.gac.mcs270.hvidsten.guslist.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Seller  implements IsSerializable{
	private String name="";
	
	public Seller() {}
	
	public Seller(String string) {
		setName(string);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
