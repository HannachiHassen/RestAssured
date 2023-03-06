package com.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

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
@JsonInclude (value=JsonInclude.Include.NON_EMPTY)
//@JsonPropertyOrder(alphabetic = true)
@JsonPropertyOrder(value={"firstname", "jobs"})
@JsonIgnoreProperties(value= {"firstname"})
public final class Employee1{

	/**
	* No args constructor for use in serialization
	*
	*/
	protected Employee1() {

	}
	
	private int id;
	private String firstnatme;
	private String lastname;
	
	/**
	 * Use @JsonIgnore to ignore 
	 */
	@JsonIgnore
	private String email;
	private List<String> jobs;
	private FavFood favfood;
	private List<Marks> marks;	

}
