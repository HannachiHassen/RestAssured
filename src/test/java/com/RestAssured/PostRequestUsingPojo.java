package com.RestAssured;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public final class PostRequestUsingPojo {

	public PostRequestUsingPojo() {	}
	
	/**
	 * Plain Old Java Object
	 * { } --> Class file
	 * [ ] --> List<Type>
	 */
	@Test
	public void pojoTest() {
		/*
		List<String> dinner= new ArrayList<>();
		dinner.add("dosa");
		dinner.add("milk");
		FavFood favfood=new FavFood("chapathi", "rice",dinner);
		*/
		
		FavFood favFood=new FavFood("chapathi", "rice",Arrays.asList("dosa", "milk"));
		Employee employee=new Employee(345, "dsfgdg", "skjhdg", "sdgeg@gmail.com",favFood);
		
		Response response=given()
				.header("Content-Type","application/json")
				.header("Content-Type",ContentType.JSON)
				.body(employee)
				.log()
				.all()
				.post("http://localhost:3000/emmployees");
		
		response.prettyPrint();
		System.out.println(response.getStatusCode());
	}

}
