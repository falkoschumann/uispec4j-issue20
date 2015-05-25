package de.muspellheim.uispec4j;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Contact {

	@Id
	private String name;
	
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
