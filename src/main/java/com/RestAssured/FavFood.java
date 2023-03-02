package com.RestAssured;

import java.util.ArrayList;
import java.util.List;

public final class FavFood {

	/**
	 * Constructor
	 * @param breakfast
	 * @param lunch
	 */
	public FavFood(String breakfast, String lunch, List<String> dinner) {
		this.breakfast=breakfast;
		this.lunch=lunch;
		this.dinner=dinner;
	}
	
	private String breakfast;
	private String lunch;
	private List<String> dinner= new ArrayList<>();
	
	public List<String> getDinner() {
		return dinner;
	}
	public FavFood setDinner(List<String> dinner) {
		this.dinner = dinner;
		return this;
	}
	
	public String getBreakfast() {
		return breakfast;
	}
	public FavFood setBreakfast(String breakfast) {
		this.breakfast = breakfast;
		return this;
	
	}
	
	public String getLunch() {
		return lunch;
	}
	public FavFood setLunch(String lunch) {
		this.lunch = lunch;
		return this;
	}	

}
