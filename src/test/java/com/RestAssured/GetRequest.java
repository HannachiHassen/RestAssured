package com.RestAssured;

import static io.restassured.RestAssured.*;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;

import io.restassured.http.*;
import io.restassured.response.*;

 public final class GetRequest {
	
	/**
	 * RestAssured support BDD way and non BDD way
	 */
	
	@Test
	public void getTest() {
		//sugarcoated methods -->readability
		//given().get("http://localhost:3000/emmployees").then().statusCode(200);
		
		Response response=given().get("http://localhost:3000/emmployees");
		response.prettyPrint();
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getTimeIn(TimeUnit.SECONDS));	
		System.out.println(response.getContentType());
		
		System.out.println(response.getHeader("Content-Type"));
		
		Headers headers=response.headers();
		for(Header header:headers) {
			System.out.println(header.getName());
			System.out.println(header.getValue());
		}			
	}
}
