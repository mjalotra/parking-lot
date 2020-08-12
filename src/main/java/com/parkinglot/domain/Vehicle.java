package com.parkinglot.domain;

import io.swagger.annotations.ApiModelProperty;

public class Vehicle {
	@ApiModelProperty(notes = "registration number of vehicle", required = true)
	private String registerationNumber;
	private String color;
	
	public Vehicle() {
		
	}

	public Vehicle(String registerationNumber) {
		super();
		this.registerationNumber = registerationNumber;
	}
	public String getRegisterationNumber() {
		return registerationNumber;
	}
	public void setRegisterationNumber(String registerationNumber) {
		this.registerationNumber = registerationNumber;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Vehicle {registerationNumber=" + registerationNumber + "}";
	}
	
	
	
}
