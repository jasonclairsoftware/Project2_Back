package com.bitbyte.daotests;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.bitbyte.daos.ClientDAOHibernate;
import com.bitbyte.entities.Client;
import com.bitbyte.utils.HibernateUtil;

public class ClientDAOTests {

	ClientDAOHibernate cdh = new ClientDAOHibernate(); 
	
	@Test
	public void createClient() {
		Client client = new Client(0, "tester", "testerpass", false, 200);
		client = cdh.createClient(client); 
		System.out.println(client);
	}
	@Test 
	public void getClientById() {
	Client client = new Client(); 
	client = cdh.getClientById(3); 
	System.out.println(client);
	}
	
	
	
	
	@Test 
	public void getClientByUsername() {
	Client client = new Client();
	client = cdh.getClientByUsername("tester"); 
	System.out.println(client);
	}
	
	
	
	
	
	
	@Test
	public void updateClient() {
		Client client = new Client();
		client = cdh.getClientById(2); 
		client.setUsername("rohit");
		client.setPassword("rohitpw	");
		client.setManager(true);
		client = cdh.updateClient(client);
		System.out.println(client);
	}
	
	 //test unsuccessful 
//	public void deleteClient() {
//		Client client = new Client(1, "jason", "jasonpass", true); 
//		cdh.deleteClient(client); 
//		System.out.println(client);
//	}
}
