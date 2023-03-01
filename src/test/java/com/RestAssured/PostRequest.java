package com.RestAssured;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public final class PostRequest {

	public PostRequest() {	}
	
	// 1. Passing json body as String --> Not recommended	
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
	
	// 2. Passing json body as String --> Recommended
	public void postTest2() {
		
	}
	
}
