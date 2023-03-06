package com.pojo;


import lombok.AllArgsConstructor;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.*;

@Getter
@AllArgsConstructor
@ToString
@JsonInclude (value=JsonInclude.Include.NON_EMPTY, content=Include.NON_NULL)
@Builder
public final class Student {
	private int id;
	private String firstnatme;
	private String lastname;
	private String email;
	
	public static String address; //static field
	
	/**
	 * Static Inner Class
	 * @author HASSEN
	 *
	 */

	public static class StudentBuilder1 {
		private int id;
		private String firstnatme;
		private String lastname;
		private String email;
				
		
		 public static StudentBuilder1 builder() {
		 
			return new StudentBuilder1();
		}		

		public StudentBuilder1 setId(int id) {
			this.id = id;
			return this;
		}

		public StudentBuilder1 setFirstnatme(String firstnatme) {
			this.firstnatme = firstnatme;
			return this;
		}

		public StudentBuilder1 setLastname(String lastname) {
			this.lastname = lastname;
			return this;
		}

		public StudentBuilder1 setEmail(String email) {
			this.email = email;
			return this;
		}		
		
		public Student build() {
			return new Student(this.id, this.firstnatme, this.lastname, this.email);
		}		
	}
}
