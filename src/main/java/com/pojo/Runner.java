package com.pojo;

public final class Runner {

	public Runner() {	}
	
	/**
	 * When we have to use setter and when we have to use constructor
	 * @param args
	 */
	public static void main(String[] args) {
		Student student =new Student("adhdh", "gahe", "tester");
		System.out.println(student.getFirstname());
		System.out.println(student.getLastname());
		System.out.println(student.getMajor());
	}
}
