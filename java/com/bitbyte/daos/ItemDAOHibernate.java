package com.bitbyte.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.bitbyte.entities.Client;
import com.bitbyte.entities.Item;
import com.bitbyte.utils.HibernateUtil;

public class ItemDAOHibernate implements ItemDAO {

	SessionFactory sf = HibernateUtil.getSessionFactory(); 
	
	public Item createItem(Item item) {
		item.setClient(null); // make sure that items only get added to locations
		
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

	
	public Item getItemByName(String name) {
		Session sess = sf.openSession();
		
		Criteria crit = sess.createCriteria(Item.class); 
		crit.add(Restrictions.like("name", name)); 
		

		List<Item> items = crit.list(); 
		
		sess.close();
		
		for(Item i : items) {
			return i;
		}
		return null;
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
