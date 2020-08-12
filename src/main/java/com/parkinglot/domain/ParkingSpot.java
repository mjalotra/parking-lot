package com.parkinglot.domain;

public class ParkingSpot {
	private Long id;
	private String floor;
	private ParkingAddress address;
	
	public ParkingSpot() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public ParkingAddress getAddress() {
		return address;
	}
	public void setAddress(ParkingAddress address) {
		this.address = address;
	}
	
	
	
	
	
}
