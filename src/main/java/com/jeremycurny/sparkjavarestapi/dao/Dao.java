package com.jeremycurny.sparkjavarestapi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

abstract public class Dao {

	protected static SessionFactory sessionFactory;

	protected static Session openSession() {
		if (sessionFactory == null) {
			sessionFactory = new Configuration().configure().buildSessionFactory();

		}
		return sessionFactory.openSession();
	}

	protected static Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

}
