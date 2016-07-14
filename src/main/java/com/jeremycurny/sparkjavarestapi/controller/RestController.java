package com.jeremycurny.sparkjavarestapi.controller;

import com.jeremycurny.sparkjavarestapi.util.JsonUtil;

import spark.Request;
import spark.Response;

abstract public class RestController {
	
	public abstract Object create(Request req, Response res);
	
	public abstract Object deleteById(Request req, Response res);

	public abstract Object find(Request req, Response res);

	public abstract Object findById(Request req, Response res);
	
	public abstract Object updateById(Request req, Response res);
	
	protected String resJson(Request req, Response res, int httpStatus, Object object) {
		res.type("application/json");
		res.status(httpStatus);
		return JsonUtil.toJson(object);
	}
	
}
