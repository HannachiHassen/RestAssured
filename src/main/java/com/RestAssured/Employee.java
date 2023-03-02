package com.RestAssured;

public final class Employee {

	public Employee(int id, String firstname, String lastname, String email, FavFood favfood) {	
		this.id=id;
		this.firstnatme=firstname;
		this.lastname=lastname;
		this.email=email;
		this.favfood=favfood;
	}

	private static int id;
	private static String firstnatme;
	private static String lastname;
	private static String email;
	private FavFood favfood;
	
	public Employee setId(int id) {
		this.id = id;
		return this;
	}
	
	public int getId() {
		return id;
	}
	
	public static void setFirstnatme(String firstnatme) {
		Employee.firstnatme = firstnatme;
	}
	
	public String getFirstnatme() {
		return firstnatme;
	}	

	
	public static void setLastname(String lastname) {
		Employee.lastname = lastname;
	}

	public String getLastname() {
		return lastname;
	}
	
	
	public static void setEmail(String email) {
		Employee.email = email;
	}
	
	public String getEmail() {
		return email;
	}		
	
	public FavFood getFavfood() {
		return favfood;
	}

	public void setFavfood(FavFood favfood) {
		this.favfood = favfood;
	}
}
