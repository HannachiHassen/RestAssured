package com.restassured;

import com.pojo.Student;

import lombok.Setter;

@Setter
public final class StudentBuilder {

	private int id;
	private String firstnatme;
	private String lastname;
	private String email;
	
	public StudentBuilder builder() {
		return this;
	}
	
	public Student build() {
		return new Student(this.id, this.firstnatme, this.lastname, this.email);
	}
}
