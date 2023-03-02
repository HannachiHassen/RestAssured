package com.pojo;

public final class Tests {

	/**
	* No args constructor for use in serialization
	*
	*/
	public Tests() {
		
	}
	
	private int manual;
	private int automation;
	
	/**
	 * 
	 * @param manual
	 * @param automation
	 */
	public Tests(int manual, int automation) {
		this.manual = manual;
		this.automation = automation;
	}
		
	public int getManual() {
		return manual;
	}

	public Tests setManual(int manual) {
		this.manual = manual;
		return this;
	}

	public int getAutomation() {
		return automation;
	}

	public Tests setAutomation(int automation) {
		this.automation = automation;
		return this;
	}	

}
