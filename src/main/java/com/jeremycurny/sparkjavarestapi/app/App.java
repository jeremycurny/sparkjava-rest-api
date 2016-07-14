package com.jeremycurny.sparkjavarestapi.app;

import static spark.Spark.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jeremycurny.sparkjavarestapi.controller.impl.UserController;

import spark.Spark;

public class App {
	
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	
    public static void main( String[] args ) {
    	
    	UserController userController = new UserController();
    	
    	Spark.staticFileLocation("/web");

    	before((req, res) -> {
    		logger.info(req.requestMethod() + " " + req.uri());
        });
    	
    	before((req, res) -> {
    		res.header("Access-Control-Allow-Headers", "Authorization, Content-Type");
    		res.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
    		res.header("Access-Control-Allow-Origin", "*");
    	});
    	options("/*", (req, res) -> "");
    	
    	get("/users", (req, res) -> userController.find(req, res));
    	get("/users/:id", (req, res) -> userController.findById(req, res));
    	post("/users", (req, res) -> userController.create(req, res));
    	put("/users/:id", (req, res) -> userController.updateById(req, res));
    	delete("/users/:id", (req, res) -> userController.deleteById(req, res));
    	
    	exception(Exception.class, (e, req, res) -> {
    		String message = e.getClass().getName() + ": " + e.getMessage();
    		logger.error(message);
    		res.type("application/json");
    	    res.status(500);
    	    res.body(message);
    	});
  
    }
}
