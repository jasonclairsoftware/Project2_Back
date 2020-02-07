package com.bitbyte.daos;

import com.bitbyte.entities.Location;

public interface LocationDAO {

	
	
			//create
			Location createLocation(Location location);
			
			//read
			Location getLocationById(int id); 
//			Location getLocationByGeoLocation(String geolocation); 
			
			//update
			Location updateLocation(Location location); 
			
			//delete
//			 boolean deleteLocation(Location location); 
			
	
}
