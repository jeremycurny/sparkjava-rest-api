package com.jeremycurny.sparkjavarestapi.controller.impl;

import java.util.List;

import com.jeremycurny.sparkjavarestapi.controller.RestController;
import com.jeremycurny.sparkjavarestapi.model.User;
import com.jeremycurny.sparkjavarestapi.service.UserService;
import com.jeremycurny.sparkjavarestapi.util.JsonUtil;

import spark.Request;
import spark.Response;

public class UserController extends RestController {
	
	@Override
	public Object create(Request req, Response res) {
		final User user = (User) JsonUtil.fromJson(req.body(), User.class);
		final User newUser = UserService.create(user);
		return super.resJson(req, res, 201, newUser);
	}

	@Override
	public Object deleteById(Request req, Response res) {
		final boolean bool = UserService.deleteById(Integer.parseInt(req.params(":id")));
		return super.resJson(req, res, 200, bool);
	}

	@Override
	public Object find(Request req, Response res) {
		final List<User> users = UserService.find();
		return super.resJson(req, res, 200, users);
	}

	@Override
	public Object findById(Request req, Response res) {
		final User user = UserService.findById(Integer.parseInt(req.params(":id")));
		return super.resJson(req, res, 200, user);
	}

	@Override
	public Object updateById(Request req, Response res) {
		final User user = (User) JsonUtil.fromJson(req.body(), User.class);
		final User updatedUser = UserService.updateById(Integer.parseInt(req.params(":id")), user);
		return super.resJson(req, res, 200, updatedUser);
	}

}
