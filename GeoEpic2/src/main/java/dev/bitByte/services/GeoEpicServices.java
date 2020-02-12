package dev.bitByte.services;

import java.util.List;

import dev.bitByte.entities.Client;
import dev.bitByte.entities.Item;
import dev.bitByte.entities.Location;

public interface GeoEpicServices {

	
	//CLIENTS
	public Client login(String username, String password);
	public Client createClient(String username, String password); // only to create clients, not managers
	public List<Client> getAllClients();
	public Client getClientById(int id); 
	
	
	//ITEMS
	public Item createItem(Item item);
	public Item getItemById(int id);
	public List<Item> getItemsForLocation(int location);
	public List<Item> getItemsForClient(Client client);
	public Item updateItem(Item item); // can be used for Item swap
	public List<Item> getAllItems();
	public Item deleteItem(Item item);
	
	
	//LOCATIONS
	public Location createLocation(Location location);
	public String getGeoLocationById(int id);
	public Location updateLocation(Location location); // can use for changing the clue, and for moving the location
	public Location getLocationById(int id); 
	
	
}
