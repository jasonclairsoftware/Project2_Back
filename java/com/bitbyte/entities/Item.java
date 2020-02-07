package com.bitbyte.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table(name = "ITEM")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "i_id")
	private int iId; 
	@Column(name = "name")
	private String name; 
	@Column(name = "description")
	private String description; 
	@Column(name = "value")
	private int value; 
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "c_id")
	private Client client; 
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "l_id")
	private Location location; 

	
	
	
	public Item() {
		super();
	}
	
	 

	public Item(int iId, String name, String description, int value, Client client, Location location) {
		super();
		this.iId = iId;
		this.name = name;
		this.description = description;
		this.value = value;
		this.client = client;
		this.location = location;
	}



	@Override
	public String toString() {
		return "Item [iId=" + iId + ", name=" + name + ", description=" + description + ", value=" + value + ", client="
				+ client + ", location=" + location + "]";
	}

	public int getiId() {
		return iId;
	}

	public void setiId(int iId) {
		this.iId = iId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
