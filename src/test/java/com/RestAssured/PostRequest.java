package com.RestAssured;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public final class PostRequest {

	public PostRequest() {	
		
	}
	
	/**
	 * 
	 * Passing JSON body as String --> Not recommended	
	   1. Easy to copy and past --> can be used to quickly check the behavior
	   2. Not recommended for larger JSON or dynamic JSON
	 * 
	 */
	
	@Test
	public void postTest() {
		String rebBody="{\r\n"
				+ "				\"id\":\"15\",\r\n"
				+ "				\"first_name\":\"amuthan\",\r\n"
				+ "				\"last_name\":\"sakthivel\",\r\n"
				+ "				\"email\":\"abcd@gmail.com\"\r\n"
				+ "		        }";
		
		Response response=given()
				.header("Content-Type","application/json")
				.header("Content-Type",ContentType.JSON)
				.body(rebBody)
				.log()
				.all()
				.post("http://localhost:3000/emmployees");
		
		response.prettyPrint();
		System.out.println(response.getStatusCode());
	}
	
	/**
	 * 
	 * Pass it from external file
	   1. You cannot get the request form the file and print it on the console
	   2. Use this only for Static data
	 * 
	 */

	@Test
	public void postTest2() {
		Response response=given()
				.header("Content-Type",ContentType.JSON)
				.body(new File(System.getProperty("user.dir") + "/test.json"))
				.post("http://localhost:3000/emmployees");
		
		response.prettyPrint();
		System.out.println(response.getStatusCode());
	}
	
	/**
	 * 
	 * Read request body from an external file and convert to string
	   1. Logs the request body into the console
	   2. Change few parameters in the request
	   3. Not suitable for request having lot of dynamic parameters 
	 * @throws IOException
	 */
		
	@Test
	public void postTest3() throws IOException {
		byte[] bytes=Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "/test.json"));
		String reqBody=new String(bytes);
		
		String replace = reqBody.replace("15", "425");
		
		Response response=given()
				.header("Content-Type",ContentType.JSON)
				.log()
				.all()
				.body(replace)
				.post("http://localhost:3000/emmployees");
		
		response.prettyPrint();
		System.out.println(response.getStatusCode());
	}
	
	/**
	 * Read request body from an external file and convert to string
	 * Use JavaFaker dependency to generate data
	 * @throws IOException
	 */
	@Test
	public void postTest4() throws IOException {
		byte[] bytes=Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "/test.json"));
		String reqBody=new String(bytes);
		
		String replace = reqBody.replace("15", String.valueOf(new Faker().number().numberBetween(100, 1000)))
								.replace("fname",new Faker().name().firstName())
								.replace("lname", new Faker().name().lastName());
		
		Response response=given()
				.header("Content-Type",ContentType.JSON)
				.log()
				.all()
				.body(replace)
				.post("http://localhost:3000/emmployees");
		
		response.prettyPrint();
		System.out.println(response.getStatusCode());
	}
	
	/**
	 * Using map and list from java
	 *  { } --> Map interface
	 *  [] --> List
	 *  
	 *  seriallisers --> converts your language objects --> byte stream --> JSON
	 *  verbose , not suitable for very big JSON file
	 *  generic type needs to be mentioned 
	 */
	@Test
	public void postTest5(){
		
		Map<String, Object> map= new LinkedHashMap<>();
		map.put("id", new Faker().number().numberBetween(100, 1000) );
		map.put("fname", "amuthan");
		map.put("lname", "skitavel");
		map.put("email", "abcd@gmail.com");
		map.put("email", "abcdf@gmail.com");  // "":["abcd@gmail.com","abcdf@gmail.com"]
		
	
		/*
		List<String> listJobs= new ArrayList<>();
		listJobs.add("tester");
		listJobs.add("trainer");
		
		map.put("jobs", listJobs);
		*/
		
		map.put("jobs", Arrays.asList("tester","trainer"));
		
		Map<String, Object> food = new HashMap<>();
		food.put("breakfast", "idly");
		food.put("lunch", "rice");
		
		/*
		List<String> dinnerFood= new ArrayList<>();
		dinnerFood.add("chapathi");
		dinnerFood.add("milk");
		
		food.put("dinner", dinnerFood);
		*/
		
		food.put("dinner", Arrays.asList("chapathi","milk"));
		map.put("favFood", food);
		
		Response response=given()
				.header("Content-Type", ContentType.JSON)
				.log()
				.all()
				.body(map)
				.post("http://localhost:3000/emmployees");

		response.prettyPrint();
		System.out.println(response.getStatusCode());
	}
	
	@Test
	public void postTest6() {
		/**
		 * Using exteranl JSON library
		 * Having some collection that can slove the problems we had with using Map and list
		 * { } --> JsonObject
		 * [] --> JsonArray
		 */
		JSONObject obj=new JSONObject();
		obj.put("id", new Faker().number().numberBetween(100, 1000) );
		obj.put("fname", "amuthan");
		obj.put("lname", "skitavel");
		obj.put("email", "abcd@gmail.com");
		obj.accumulate("email", "abcdf@gmail.com");
		obj.append("email", "query@gmail.com");
		obj.putOpt("email1", null);   //if the value is not null, then only I want to add it 
		// obj.putOnce("fname", "sdfc"); //duplicate 
		
		JSONArray listofJobs=new JSONArray();
		listofJobs.put("tester");
		listofJobs.put("tester");
		
		obj.put("jobs", listofJobs);
		
		JSONObject food = new JSONObject();
		food.put("breakfast", "idly");
		food.put("lunch", "rice");
		
		JSONArray listofFood=new JSONArray();
		listofFood.put("chapathi");
		listofFood.put("milk");
		food.put("dinner", listofFood);
		
		obj.put("favFood", food);
		
		Response response=given()
				.header("Content-Type", ContentType.JSON)
				.log()
				.all()
				.body(obj.toMap()) // jackson helps to serialise
				.post("http://localhost:3000/emmployees");

		response.prettyPrint();
		System.out.println(response.getStatusCode());
		
	}
}
