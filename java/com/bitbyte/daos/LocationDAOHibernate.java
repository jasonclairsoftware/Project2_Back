package com.bitbyte.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


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
	public Location getLocationByGeoLocation(String geolocation) {
		Session sess = sf.openSession();
		Location location = sess.get(Location.class, geolocation); 
		sess.close();
		return location;
	}

	public Location updateLocation(Location location) {
		Session sess = sf.openSession();
		sess.beginTransaction(); 
		sess.update(location);
		sess.getTransaction().commit(); 
		sess.close();
		return location;
	}

	//unsuccessful 
	public boolean deleteLocation(Location location) {
		Session sess = sf.openSession();
		sess.beginTransaction(); 
		sess.update(location);
		sess.getTransaction().commit(); 
		sess.close();
		return true;
	}

}
