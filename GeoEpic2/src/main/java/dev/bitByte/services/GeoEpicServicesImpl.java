package dev.bitByte.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.bitByte.entities.Client;
import dev.bitByte.entities.Item;
import dev.bitByte.entities.Location;
import dev.bitByte.repositories.ClientRepo;
import dev.bitByte.repositories.ItemRepo;
import dev.bitByte.repositories.LocationRepo;
import dev.bitByte.utils.HibernateUtil;

@Component
@Service
public class GeoEpicServicesImpl implements GeoEpicServices{

	
	private SessionFactory sf = HibernateUtil.getSessionFactory();
	
	@Autowired
	ClientRepo cr;
	
	@Autowired
	ItemRepo ir;
	
	@Autowired
	LocationRepo lr;
	
	@Override
	public Client login(String username, String password) {
		Session sess = sf.openSession();
		Criteria crit = sess.createCriteria(Client.class);
		crit.add(Restrictions.like("username", username));
		crit.add(Restrictions.like("password", password));
		List<Client> user = crit.list();
		sess.close();
		if (user.isEmpty()) {
			return null;
		}
		return user.get(0);
		}
	
	
	
	
//		if (c.getUsername().equals(username)) {
//			System.out.println("Username Matched!");
//		}
//	
//	
//		if (c.getPassword() == password) {
//			return c;
//		}else {
//			return null;
//		}
		

//	}

//	public Client(int cId, String username, String password, boolean isManager, int score)
	@Override
	public Client createClient(String username, String password) {
		Client c = new Client(0,username,password,false,0);
		cr.save(c);
		return c;
	}

	@Override
	public List<Client> getAllClients() {
		List<Client> clients = (List<Client>) cr.findAll();
		return clients;
	}
	

	@Override
	public Item createItem(Item item) {
		ir.save(item);
		return item;
	}

	@Override
	public Item getItemById(int id) {
		Item i = ir.findById(id).get();
		return i;
	}

	
	
	
	@Override
	public List<Item> getItemsForLocation(int location) {//return list of items, where l_id == location.getID
//Maybe change later, if better implementation found
		
		List<Item> allItems = this.getAllItems();
		List<Item> Litems = new ArrayList<Item>();

		for(Item i:allItems) {
			if(i.getLocation() != null) {
				if (i.getLocation().getlId() == location) {
					Litems.add(i);
				}
			}

		}

		return Litems;
	}

	
	
	
	
	
	@Override
	public List<Item> getItemsForClient(Client client) {
//Maybe change later, if better implementation found
		
		List<Item> allItems = this.getAllItems();
		List<Item> Citems = new ArrayList<Item>();
				
		for(Item i:allItems) {
			if(i.getClient() != null) {
				if (i.getClient().getcId() == client.getcId()) {
					Citems.add(i);
				}
				
			}
			
		}		
		return Citems;
	}

	
	
	
	
	
	@Override
	public Item updateItem(Item item) {
		ir.save(item);
		return item;
	}

	@Override
	public List<Item> getAllItems() {
		return (List<Item>) ir.findAll();
	}

	@Override
	public Item deleteItem(Item item) {
		ir.delete(item);
		return item;
	}

	@Override
	public Location createLocation(Location location) {
		lr.save(location);
		return location;
	}

	@Override
	public String getGeoLocationById(int id) {
		Location L = lr.findById(id).get();

		return L.getGeoLocation();
	}

	@Override
	public Location updateLocation(Location location) {
		lr.save(location);
		return location;
	}


	@Override
	public Client getClientById(int id) {
		Client c = cr.findById(id).get(); 
		return c;
	}


	@Override
	public Location getLocationById(int id) {
		Location location = lr.findById(id).get();
		return location;
	}

}
