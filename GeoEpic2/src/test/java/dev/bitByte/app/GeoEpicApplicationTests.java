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
	
	@Test
	//does not work yet
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
	
	@Test
	void createItem() {
		Client client = new Client();
		client.setcId(2);
		Item item = new Item(0, "test1", "testingdescription", 0, client, null);
		item = ges.createItem(item);
		System.out.println(item);
	}
	
	
	@Test
	void getItemById() {
		Item item = ges.getItemById(12);
		System.out.println(item);
	}
	
	@Test
	void getItemsForLocation() {
	}
	
	@Test
	void getItemsForClient() {
	}
	
	@Test
	void updateItem() {
	}
	
	@Test
	void getAllItems() {
		List<Item> items = ges.getAllItems();
		for (Item i:items) {
			System.out.println(i);
		}
	}
	
	@Test
	void deleteItem() {
	}
	
	@Test
	void createLocation() {
	}
	
	@Test
	//works
	void getLocationById() {
		String location = ges.getLocationById(2);
		System.out.println(location);
	}
	
	@Test
	void updateLocation() {
	}
	

}
