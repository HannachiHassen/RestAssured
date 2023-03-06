package com.pojo;

import java.util.Arrays;
import java.util.List;

public final class Runner {

	public Runner() {	}
	
	/**
	 * When we have to use setter and when we have to use constructor
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		FavFood favFood=new FavFood("chapathi", "rice", Arrays.asList("dosa", "milk"));
		Marks tests1= new Marks(85,90);
		Marks tests = new Marks(95,68);
		List<Marks> listofTests=Arrays.asList(tests1,tests);
		Employees employee=new Employees(345, "dsfgdg", "skjhdg", "sdgeg@gmail.com", Arrays.asList("tester","trainer"), favFood, listofTests);
		System.out.println(employee.getId());
		System.out.println(employee.getFirstnatme());
		System.out.println(employee.getLastname());
		System.out.println(employee.getEmail());
		System.out.println(employee.getJobs());	
	}
}
