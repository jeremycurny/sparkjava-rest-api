package com.jeremycurny.sparkjavarestapi.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.jeremycurny.sparkjavarestapi.manager.HibernateManager;
import com.jeremycurny.sparkjavarestapi.model.User;

public class UserService {

	public static User create(User user) {
		Session session = HibernateManager.openSession();
		Transaction transaction = session.beginTransaction();
		session.persist(user);
		transaction.commit();
		session.close();
		return user;
	}

	public static boolean deleteById(int id) {
		final Session session = HibernateManager.openSession();
		final Transaction transaction = session.beginTransaction();
		final Query query = session.createQuery("from User where id = :id");
		query.setParameter("id", id);
		User user = (User) query.getSingleResult();
		session.delete(user);
		transaction.commit();
		session.close();
		return true;
	}

	public static List<User> find() {
		final Session session = HibernateManager.openSession();
		final Transaction transaction = session.beginTransaction();
		final Query query = session.createQuery("from User");
		final List<User> users = (List<User>) query.getResultList();
		transaction.commit();
		session.close();
		return users;
	}

	public static User findById(int id) {
		final Session session = HibernateManager.openSession();
		final Transaction transaction = session.beginTransaction();
		final Query query = session.createQuery("from User where id = :id");
		query.setParameter("id", id);
		User user = (User) query.getSingleResult();
		transaction.commit();
		session.close();
		return user;
	}

	public static User updateById(int id, User user) {
		final Session session = HibernateManager.openSession();
		final Transaction transaction = session.beginTransaction();
		final Query query = session.createQuery("from User where id = :id");
		query.setParameter("id", id);
		User userUpdated = (User) query.getSingleResult();
		userUpdated.setId(user.getId());
		userUpdated.setEmail(user.getEmail());
		userUpdated.setPassword(user.getPassword());
		session.update(userUpdated);
		transaction.commit();
		session.close();
		return userUpdated;
	}

}
