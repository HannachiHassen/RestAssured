package com.restassured;

import com.github.javafaker.Faker;

import com.pojo.Employee2;
import com.pojo.Student;

public class BuilderDesingPatternTest {

	public BuilderDesingPatternTest() {
		// TODO Auto-generated constructor stub
	}
	
	public void builderTest() {
		/**
		 * Immutability
		 * No of parameters increases the readability decrease
		 * if you want to ignore some fileds, it becomes difficult to create multiple constructors
		 * 
		 * Builder design pattern  External Builder
		 */
		 new StudentBuilder().builder().setId(10);
	
	}

}
