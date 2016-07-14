package com.jeremycurny.sparkjavarestapi.manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateManager {

	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
      
    public static Session openSession() {
    	return sessionFactory.openSession();
    }
}
