package com.RestAssured;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public final class PostRequest {

	public PostRequest() {	}
	
	// 1. Passing json body as String --> Not recommanded	
	@Test
	public void postTest() {
		Response response=given().body("{\r\n"
				+ "				\"id\":\"15\",\r\n"
				+ "				\"first_name\":\"amuthan\",\r\n"
				+ "				\"last_name\":\"sakthivel\",\r\n"
				+ "				\"email\":\"abcd@gmail.com\"\r\n"
				+ "		        }")
				.log()
				.all()
				.post("http://localhost:3000/emmployees");
		response.prettyPrint();
		System.out.println(response.getStatusCode());
	}	
}
