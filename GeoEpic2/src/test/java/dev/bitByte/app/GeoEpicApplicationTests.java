package dev.bitByte.app;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import dev.bitByte.entities.Client;
import dev.bitByte.entities.Item;
import dev.bitByte.entities.Location;
import dev.bitByte.services.GeoEpicServices;

@SpringBootTest
//@Transactional
class GeoEpicApplicationTests {

	@Autowired
	GeoEpicServices ges;
	
	@Test //this works 
	void getClientById() {
		Client client = ges.getClientById(2); 
		System.out.println(client);
		
	}
	
	@Test
	//NOT WORKING 
	void login() {
		Client c = ges.login("jason", "jasonpass");
		System.out.println("Result is " + c);
	}
	
	@Test //this works
	void createClient() {
		Client c = new Client();
		c = ges.createClient("adam", "adampass"); 
		System.out.println(c);
		
	}

	@Test //this works
	void getAllClients() {
		List<Client> clients = ges.getAllClients();
		for (Client c : clients) {
				System.out.println(c);
		}
	}
	
	@Test //this works 
	void createItem() {
		Client client = new Client();
		client.setcId(2);
		Item item = new Item(0, "test1", "testingdescription", 0, client, null);
		item = ges.createItem(item);
		System.out.println(item);
	}
	
	
	@Test //this works
	void getItemById() {
		Item item = ges.getItemById(12);
		System.out.println(item);
	}
	
	@Test //this works 
	void getItemsForLocation() {
		
		
		List<Item> allItems = ges.getItemsForLocation(1); 
		for (Item i: allItems) {
		System.out.println(i);
		}
	}
	
	@Test //this works
	void getItemsForClient() {
		
		
		List<Item> allItems = ges.getItemsForClient(ges.getClientById(2)); 
		for (Item i: allItems) {
			System.out.println(i);
		}
		
		
	}
	
	@Test //this works 
	void updateItem() {
		
		Item item = ges.getItemById(2);
		item.setName("MAGNEMITE");
		item.setDescription("GREY BALLS WITH EYES");
		item.setValue(25);
		item.setClient(null);
		item.setLocation(ges.getLocationById(3));
		item = ges.updateItem(item); 
		System.out.println(item);
		
	}
	
	@Test //this works
	void getAllItems() {
		List<Item> items = ges.getAllItems();
		for (Item i:items) {
			System.out.println(i);
		}
	}
	
	@Test //this works
	void deleteItem() {
		
		Item item = ges.deleteItem(ges.getItemById(26)); 
	}
	
	
	@Test //this works 
	void createLocation() {
		
		Location location = new Location (0, "testytesty", "012345"); 
		location = ges.createLocation(location); 
		System.out.println(location);
	}
	
	@Test //this works 
	void getLocationById() {
		Location location = ges.getLocationById(2); 
		System.out.println(location);
		
	}
	
	@Test
	//this works
	void getGeoLocationById() {
		String location = ges.getGeoLocationById(2);
		System.out.println(location);
	}
	
	@Test //this works 
	void updateLocation() {
		
		Location location = ges.getLocationById(6); 
		location.setClue("I am testing you");
		location.setGeoLocation("654321");
		location = ges.updateLocation(location); 
		System.out.println(location);
	}
	

}
