package com.parkinglot.domain;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class ParkingCollectionRequest {
	@NotNull(message = "mai ni krne ka allow")
	private String someThing;
	@ApiModelProperty(notes = "Vehicle Entry time", required = true)
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Date entryTime;
	@ApiModelProperty(notes = "Vehicle exit time", required = true)
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Date exitTime;
	
	@ApiModelProperty(notes = "Vehicle related extra info", required = true)
	private Vehicle vehicle;
	
	@ApiModelProperty(notes = "Parking Spot")
	private ParkingSpot parkingSpot;
	
	
	
	
	
	public String getSomeThing() {
		return someThing;
	}
	public void setSomeThing(String someThing) {
		this.someThing = someThing;
	}
	public Date getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}
	public Date getExitTime() {
		return exitTime;
	}
	public void setExitTime(Date exitTime) {
		this.exitTime = exitTime;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public ParkingSpot getParkingSpot() {
		return parkingSpot;
	}
	public void setParkingSpot(ParkingSpot parkingSpot) {
		this.parkingSpot = parkingSpot;
	}
	
	
	
}
