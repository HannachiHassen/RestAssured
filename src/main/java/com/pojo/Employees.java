package com.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Use lombok plugin (IntelliJ doesn't need the plugin), and dependency to generate getter & setter, contractor,...
 * @author HASSEN
 *
 */
@Getter
@Setter
@AllArgsConstructor
public final class Employees {

	/**
	* No args constructor for use in serialization
	*
	*/
	protected Employees() {

	}
	
	private int id;
	private String firstnatme;
	private String lastname;
	private String email;
	private List<String> jobs;
	private FavFood favfood;
	private List<Tests> tests;	

}
