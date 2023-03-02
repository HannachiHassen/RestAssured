package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public final class Student {

	protected Student() {

	}
	
	private  String firstname;
	private String lastname;
	private String major;

}
