package com.bitbyte.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.bitbyte.entities.Client;
import com.bitbyte.entities.Location;
import com.bitbyte.utils.HibernateUtil;

public class LocationDAOHibernate implements LocationDAO {

	SessionFactory sf = HibernateUtil.getSessionFactory(); 
	
	public Location createLocation(Location location) {
		Session sess = sf.openSession();
		sess.beginTransaction();
		sess.save(location);
		sess.getTransaction().commit();
		sess.close(); 
		return location;	
	}

	public Location getLocationById(int id) {
		Session sess = sf.openSession();
		Location location= sess.get(Location.class, id); 
		sess.close();
		return location;
	}

	//unsuccessful 
//	public Location getLocationByGeoLocation(String geolocation) {
//		Session sess = sf.openSession();
//		
//		Criteria crit = sess.createCriteria(Client.class); 
//		crit.add(Restrictions.like("geoLocation", geolocation)); 
//		
//
//		List<Location> geolocations = crit.list(); 
//		
//		sess.close();
//		
//		for(Location g : geolocations) {
//			return g;
//		}
//		return null;
//	}

	public Location updateLocation(Location location) {
		Session sess = sf.openSession();
		sess.beginTransaction(); 
		sess.update(location);
		sess.getTransaction().commit(); 
		sess.close();
		return location;
	}

	//unsuccessful 
//	public boolean deleteLocation(Location location) {
//		Session sess = sf.openSession();
//		sess.beginTransaction(); 
//		sess.update(location);
//		sess.getTransaction().commit(); 
//		sess.close();
//		return true;
//	}

}
