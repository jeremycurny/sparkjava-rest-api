package com.jeremycurny.sparkjavarestapi.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtil {

	private static Gson gson = new GsonBuilder().create();

	public static Object fromJson(String json, Class typeOfT) {
		return gson.fromJson(json, typeOfT);
	}

	public static String toJson(Object object) {
		return gson.toJson(object);
	}

}
