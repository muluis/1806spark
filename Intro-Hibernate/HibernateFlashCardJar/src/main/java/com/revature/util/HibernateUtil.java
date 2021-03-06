package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	/*
	 * Use the Configuration Interface 
	 */

	private static SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	public static Session getSession(){
		return sf.openSession(); //open a new session; in the future we will use getCurrentSession() w/ Spring
	}
}
