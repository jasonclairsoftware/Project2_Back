package com.bitbyte.daotests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bitbyte.daos.ClientDAOHibernate;
import com.bitbyte.daos.ItemDAOHibernate;
import com.bitbyte.daos.LocationDAOHibernate;
import com.bitbyte.entities.Client;
import com.bitbyte.entities.Item;
import com.bitbyte.entities.Location;

public class ItemDAOTests {

	ItemDAOHibernate idh = new ItemDAOHibernate(); 
	ClientDAOHibernate cdh = new ClientDAOHibernate();
	LocationDAOHibernate ldh = new LocationDAOHibernate();
	@Test
	public void createItem() {
		Client client = new Client();	// This will get ignored and get set to null
		client = cdh.getClientById(5); 
		Location location = new Location();
		location = ldh.getLocationById(1); 
		Item item = new Item(0, "computer", "new", 100, client, location);
		item = idh.createItem(item); 
		System.out.println(item);
	}
	

	
	@Test
	public void getItemById() {
		Item item = new Item();
		item=idh.getItemById(1);
		System.out.println(item);
	}
	
	@Test 
	public void getItemByName() {
		Item item = new Item();
		item = idh.getItemByName("computer");
		System.out.println(item);
	}
	

//	public Item(int iId, String name, String description, int value, Client client, Location location) {
	
	@Test 
	public void updateItem() {
	Item item = new Item();
	item = idh.getItemById(1); 
	
//	item.setName("Charzard");
//	item.setValue(50);
//	item.setLocation(null);
	item.setClient(null);
	
	item = idh.updateItem(item); 
	System.out.println(item);
		
	}
	
	 //unsuccessful
//	public void deleteItem() {
//	Client client = new Client();
//	client = cdh.getClientById(5); 
//	Location location = new Location();
//	location = ldh.getLocationById(1); 
//	Item item = new Item(2, "newsage", "new", 100, client, location);
//	item = idh.getItemById(2); 
//	item.setName("newsage");
//	item.setValue(100);
//	item = idh.updateItem(item); 
//	System.out.println(item);
		
	

}
