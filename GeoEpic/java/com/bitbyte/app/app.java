package com.bitbyte.app;

import org.hibernate.SessionFactory;

import com.bitbyte.utils.HibernateUtil;

public class app {

	public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory(); 
		sf.close();

	}

}
