package com.restassured;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public final class UpdateRequest {

	public UpdateRequest() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void updateTest() {
		JSONObject object = new JSONObject();
		object.put("firstname", "shdfk");
		object.put("email", "test1@gmail.com");

		Response response = given().header("Content-Type", ContentType.JSON)
				.log()
				.all()
				.body(object)
				.put("http://localhost:3000/emmployees/1");

		response.prettyPrint();
		System.out.println(response.getStatusCode());
	}

}
