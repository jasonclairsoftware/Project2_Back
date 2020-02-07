package com.bitbyte.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bitbyte.entities.Client;
import com.bitbyte.entities.Item;
import com.bitbyte.utils.HibernateUtil;

public class ItemDAOHibernate implements ItemDAO {

	SessionFactory sf = HibernateUtil.getSessionFactory(); 
	
	public Item createItem(Item item) {
		Session sess = sf.openSession();
		sess.beginTransaction();
		sess.save(item);
		sess.getTransaction().commit();
		sess.close(); 
		return item;	
	}

	public Item getItemById(int id) {
		Session sess = sf.openSession();
		Item item= sess.get(Item.class, id); 
		sess.close();
		return item;
	}

	//unsuccessful 
	public Item getItemByname(String name) {
		Session sess = sf.openSession();
		Item item = sess.get(Item.class, name); 
		sess.close();
		return item;
	}

	public Item updateItem(Item item) {
		Session sess = sf.openSession();
		sess.beginTransaction(); 
		sess.update(item);
		sess.getTransaction().commit(); 
		sess.close();
		return item;
	}

	//unsuccessful 
	public boolean deleteItem(Item item) {
		Session sess = sf.openSession();
		sess.beginTransaction(); 
		sess.update(item);
		sess.getTransaction().commit(); 
		sess.close();
		return true;	}

}
