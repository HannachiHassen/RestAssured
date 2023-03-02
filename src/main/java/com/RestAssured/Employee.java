package com.RestAssured;

import java.util.List;

public final class Employee {	

	/**
	 * Constructor
	 * @param id
	 * @param firstnatme
	 * @param lastname
	 * @param email
	 * @param jobs
	 * @param favfood
	 */
	public Employee(int id, String firstnatme, String lastname, String email, List<String> jobs, FavFood favfood) {
		this.id = id;
		this.firstnatme = firstnatme;
		this.lastname = lastname;
		this.email = email;
		this.jobs = jobs;
		this.favfood = favfood;
	}

	private int id;
	private String firstnatme;
	private String lastname;
	private String email;
	private List<String> jobs;
	private FavFood favfood;
	
	public int getId() {
		return id;
	}
	public Employee setId(int id) {
		this.id = id;
		return this;
	}
	public String getFirstnatme() {
		return firstnatme;
	}
	public Employee setFirstnatme(String firstnatme) {
		this.firstnatme = firstnatme;
		return this;
	}
	public String getLastname() {
		return lastname;
	}
	public Employee setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public Employee setEmail(String email) {
		this.email = email;
		return this;
	}
	public List<String> getJobs() {
		return jobs;
	}
	public Employee setJobs(List<String> jobs) {
		this.jobs = jobs;
		return this;
	}
	public FavFood getFavfood() {
		return favfood;
	}
	public Employee setFavfood(FavFood favfood) {
		this.favfood = favfood;
		return this;
	}
}
