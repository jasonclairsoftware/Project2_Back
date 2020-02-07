package com.bitbyte.daotests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bitbyte.daos.ClientDAOHibernate;
import com.bitbyte.daos.LocationDAOHibernate;
import com.bitbyte.entities.Client;
import com.bitbyte.entities.Location;

public class LocationDAOTests {

	LocationDAOHibernate ldh = new LocationDAOHibernate(); 
	
	@Test
	public void createLocation() {
		Location location = new Location(0, "delete me", "12345678"); 
		location = ldh.createLocation(location); 
		System.out.println(location);
	}
	
	@Test
	public void getLocationById() {
		Location location = ldh.getLocationById(5);
		System.out.println(location);
	}
	
	//TypeMismatchException: Provided id of the wrong type for class com.bitbyte.entities.Location. 
	//Expected: class java.lang.Integer, got class java.lang.String
	
//	public void getLocationByGeoLocation() {
//		Location location = new Location(); 
//		location = ldh.getLocationByGeoLocation("412412");
//		System.out.println(location);
//	}
	
	@Test
	public void updateLocation() {
		Location location = new Location();
		location = ldh.getLocationById(5); 
		location.setClue("delete me soon");
		location.setGeoLocation("478932489743879234");
		location = ldh.updateLocation(location);
		System.out.println(location);
	}
	
	//unsuccessful 
//	public void deleteLocation() {
//		Location location = new Location(1, "newclue", "newgeolocation");
//		ldh.deleteLocation(location); 
//		System.out.println(location);
//	}

}
