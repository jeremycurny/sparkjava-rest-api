package com.jeremycurny.sparkjavarestapi.service;

import java.util.List;

import com.jeremycurny.sparkjavarestapi.dao.impl.UserDao;
import com.jeremycurny.sparkjavarestapi.model.User;

public class UserService {

	public static User create(User user) {
		UserDao.insert(user);
		return user;
	}

	public static boolean deleteById(int id) {
		return UserDao.deleteById(id);
	}

	public static List<User> find() {
		return UserDao.select();
	}

	public static User findById(int id) {
		return UserDao.selectById(id);
	}

	public static User updateById(int id, User user) {
		user.setId(id);
		UserDao.update(user);
		return user;
	}

}
