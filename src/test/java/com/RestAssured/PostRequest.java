package com.RestAssured;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
		
		String replace = reqBody.replace("15", String.valueOf(new Faker().number().numberBetween(100, 1000)));
		
		Response response=given()
				.header("Content-Type",ContentType.JSON)
				.log()
				.all()
				.body(replace)
				.post("http://localhost:3000/emmployees");
		
		response.prettyPrint();
		System.out.println(response.getStatusCode());
	}
}
