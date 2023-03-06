package com.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Use lombok plugin (IntelliJ doesn't need the plugin), and dependency to generate getter & setter, contractor,...
 * @author HASSEN
 *
 */
@Getter
@AllArgsConstructor
@JsonInclude (value=JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder(value={"firstname", "jobs"})
@JsonIgnoreProperties(value= {"firstname"})
public final class Employee2{

	/**
	* No args constructor for use in serialization
	*
	*/
	public Employee2(int id, String lastname, String email) {
		this.id = id;
		this.lastname = lastname;
		this.email = email;
	}
	
	private int id;
	private String firstnatme;
	private String lastname;
	private String email;

}
