package com.pojo;

public final class Marks {

	/**
	* No args constructor for use in serialization
	*
	*/
	public Marks() {
		
	}
	
	private int manual;
	private int automation;
	
	/**
	 * 
	 * @param manual
	 * @param automation
	 */
	public Marks(int manual, int automation) {
		this.manual = manual;
		this.automation = automation;
	}
		
	public int getManual() {
		return manual;
	}

	public Marks setManual(int manual) {
		this.manual = manual;
		return this;
	}

	public int getAutomation() {
		return automation;
	}

	public Marks setAutomation(int automation) {
		this.automation = automation;
		return this;
	}	

}
