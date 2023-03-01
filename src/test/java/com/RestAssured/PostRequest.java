package com.RestAssured;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public final class PostRequest {

	public PostRequest() {	}
	
	// 1. Passing JSON body as String --> Not recommended	
	// Easy to copy and past --> can be used to quickly check the behavior
	// Not recommended for larger JSON or dynamic JSON
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
	
	// 2. Passing from external file --> Recommended
	// You cannot get the request form the file and print it on the console
	@Test
	public void postTest2() {
		Response response=given()
				.header("Content-Type",ContentType.JSON)
				.body(new File(System.getProperty("user.dir") + "/test.json"))
				.post("http://localhost:3000/emmployees");
		response.prettyPrint();
		System.out.println(response.getStatusCode());
	}
}
