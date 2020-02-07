package com.bitbyte.daos;

import com.bitbyte.entities.Client;



public interface ClientDAO {

	//create
		Client createClient(Client client);
		
		//read
		Client getClientById(int id); 
		Client getClientByUsername(String username); 
		
		//update
		Client updateClient(Client client); 
		
		//delete
		 boolean deleteClient(Client client); 
		
	
	
}
