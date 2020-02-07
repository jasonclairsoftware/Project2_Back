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
		Client client = new Client();
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
		item=idh.getItemById(2);
		System.out.println(item);
	}
	
	@Test //TypeMismatchException: Provided id of the wrong type for class com.bitbyte.entities.Item. 
	//Expected: class java.lang.Integer, got class java.lang.String
	public void getItemByName() {
		Item item = new Item();
		item = idh.getItemByname("computer");
		System.out.println(item);
	}
	
	@Test 
	public void updateItem() {
	Item item = new Item(); 
	item = idh.getItemById(2); 
	item.setName("newsage");
	item.setValue(100);
	item = idh.updateItem(item); 
	System.out.println(item);
		
	}
	
	@Test //unsuccessful
	public void deleteItem() {
	Client client = new Client();
	client = cdh.getClientById(5); 
	Location location = new Location();
	location = ldh.getLocationById(1); 
	Item item = new Item(2, "newsage", "new", 100, client, location);
	item = idh.getItemById(2); 
	item.setName("newsage");
	item.setValue(100);
	item = idh.updateItem(item); 
	System.out.println(item);
		
	}

}
