package org.bhargav.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtil {

	private static SessionUtil sessionUtil = new SessionUtil();
	private SessionFactory sessionFactory;
	
	private SessionUtil()
	{
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		sessionFactory = configuration.buildSessionFactory();
	}
	
	public static SessionUtil getInstance()
	{
		return sessionUtil;
	}
	
	public static Session getSession()
	{
		Session session = getInstance().sessionFactory.openSession();
		return session;
	}
}
