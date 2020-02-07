package com.bitbyte.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

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

	
	
	
	
	
	
	public Client getClientByUsername(String username) {
		
		Session sess = sf.openSession();
		
		Criteria crit = sess.createCriteria(Client.class); 
		crit.add(Restrictions.like("username", username)); 
		

		List<Client> clients = crit.list(); 
		
		sess.close();
		
		for(Client c : clients) {
			return c;
		}
		return null;
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
//	public boolean deleteClient(Client client) {
//		Session sess = sf.openSession();
//		sess.beginTransaction(); 
//		sess.delete(client);
//		sess.getTransaction().commit(); 
//		sess.close();
//		return true;
//	}

	

}
