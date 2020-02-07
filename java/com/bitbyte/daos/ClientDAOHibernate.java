package com.bitbyte.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.bitbyte.entities.Client;
import com.bitbyte.utils.HibernateUtil;

public class ClientDAOHibernate implements ClientDAO {

	SessionFactory sf = HibernateUtil.getSessionFactory(); 
	
	public Client createClient(Client client) {
		Session sess = sf.openSession();
		sess.beginTransaction();
		sess.save(client);
		sess.getTransaction().commit();
		sess.close(); 
		return client;	
	}

	public Client getClientById(int id) {
		Session sess = sf.openSession();
		Client client= sess.get(Client.class, id); 
		sess.close();
		return client;
	}

	//TypeMismatchException: Provided id of the wrong type for class com.bitbyte.entities.Client. 
	//Expected: class java.lang.Integer, got class java.lang.String
	public Client getClientByUsername(String username) {
		Session sess = sf.openSession();
		Client client = sess.get(Client.class, username); 
		sess.close();
		return client;
	}

	public Client updateClient(Client client) {
		Session sess = sf.openSession();
		sess.beginTransaction(); 
		sess.update(client);
		sess.getTransaction().commit(); 
		sess.close();
		return client;
	}

	//test unsuccessful 
	public boolean deleteClient(Client client) {
		Session sess = sf.openSession();
		sess.beginTransaction(); 
		sess.update(client);
		sess.getTransaction().commit(); 
		sess.close();
		return true;
	}

	

}
