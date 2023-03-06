package com.restassured;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import io.restassured.response.Response;

public final class DeleteRequest {

	public DeleteRequest() {
		// TODO Auto-generated constructor stub
	}
	@Test
	public void deleteEmployee() {
	Response response = given()
			.param("id", 3)
			.log()
			.all()
			.delete("http://localhost:3000/emmployees/{id}");
	
	System.out.println(response.getStatusCode());
	System.out.println(response.getTime());
	System.out.println(response.getTimeIn(TimeUnit.SECONDS));
	System.out.println(response.getContentType());		
	System.out.println(response.getHeader("Content-Type"));
	}

}
