package com.jeremycurny.sparkjavarestapi.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.jeremycurny.sparkjavarestapi.dao.Dao;
import com.jeremycurny.sparkjavarestapi.model.User;

public class UserDao extends Dao {

	public static void delete(User user) {
		Session session = UserDao.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(user);
		transaction.commit();
		session.close();
	}

	public static boolean deleteById(int id) {
		boolean deleted = false;
		Session session = UserDao.openSession();
		Transaction transaction = session.beginTransaction();
		User user = (User) session.createCriteria(User.class).add(Restrictions.idEq(id)).uniqueResult();
		if (user != null) {
			session.delete(user);
			deleted = true;
		}
		transaction.commit();
		session.close();
		return deleted;
	}

	public static List<User> select() {
		Session session = UserDao.openSession();
		Transaction transaction = session.beginTransaction();
		List<User> users = session.createCriteria(User.class).list();
		transaction.commit();
		session.close();
		return users;
	}

	public static User selectById(int id) {
		Session session = UserDao.openSession();
		Transaction transaction = session.beginTransaction();
		User user = (User) session.createCriteria(User.class).add(Restrictions.idEq(id)).uniqueResult();
		transaction.commit();
		session.close();
		return user;
	}

	public static void insert(User user) {
		Session session = UserDao.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		session.close();
	}

	public static void insertOrUpdate(User user) {
		Session session = UserDao.openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(user);
		transaction.commit();
		session.close();
	}

	public static void update(User user) {
		Session session = UserDao.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(user);
		transaction.commit();
		session.close();
	}

}
