package com.pojo;

import java.util.List;

/**
 * 
 * @author HASSEN
 *
 */
public final class Employees {	
	
	/**
	* No args constructor for use in serialization
	*
	*/
	public Employees() {
	}

	private int id;
	private String firstnatme;
	private String lastname;
	private String email;
	private List<String> jobs;
	private FavFood favfood;
	private List<Marks> marks;	
	
	/**
	 * 	
	 * @param id
	 * @param firstnatme
	 * @param lastname
	 * @param email
	 * @param jobs
	 * @param favfood
	 * @param tests
	 */
	public Employees(int id, String firstnatme, String lastname, String email, List<String> jobs, FavFood favfood, List<Marks> marks) {
		this.id = id;
		this.firstnatme = firstnatme;
		this.lastname = lastname;
		this.email = email;
		this.jobs = jobs;
		this.favfood = favfood;
		this.marks = marks;
	}

	public int getId() {
		return id;
	}
	public Employees setId(int id) {
		this.id = id;
		return this;
	}
	public String getFirstnatme() {
		return firstnatme;
	}
	public Employees setFirstnatme(String firstnatme) {
		this.firstnatme = firstnatme;
		return this;
	}
	public String getLastname() {
		return lastname;
	}
	public Employees setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public Employees setEmail(String email) {
		this.email = email;
		return this;
	}
	public List<String> getJobs() {
		return jobs;
	}
	public Employees setJobs(List<String> jobs) {
		this.jobs = jobs;
		return this;
	}
	public FavFood getFavfood() {
		return favfood;
	}
	public Employees setFavfood(FavFood favfood) {
		this.favfood = favfood;
		return this;
	}
	
	public List<Marks> getMarks() {
		return marks;
	}

	public Employees setMarks(List<Marks> marks) {
		this.marks = marks;
		return this;
	}
}
