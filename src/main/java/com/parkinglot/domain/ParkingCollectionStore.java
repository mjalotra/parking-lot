package com.parkinglot.domain;

import java.math.BigDecimal;
import java.util.Date;

public class ParkingCollectionStore {
	private Date entryTime;
	private Date exitTime;
	private Vehicle vehicleInfo;
	private BigDecimal parkingCharge;
	private ParkingSpot parkingSpot;

	public ParkingCollectionStore(Date entryTime, Date exitTime, Vehicle vehicleInfo, BigDecimal parkingCharge,
			ParkingSpot parkingSpot) {
		super();
		this.entryTime = entryTime;
		this.exitTime = exitTime;
		this.vehicleInfo = vehicleInfo;
		this.parkingCharge = parkingCharge;
		this.parkingSpot = parkingSpot;
	}
	
	public ParkingCollectionStore(Date entryTime, Date exitTime, Vehicle vehicleInfo, BigDecimal parkingCharge) {
		super();
		this.entryTime = entryTime;
		this.exitTime = exitTime;
		this.vehicleInfo = vehicleInfo;
		this.parkingCharge = parkingCharge;
		
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
	public Vehicle getVehicleInfo() {
		return vehicleInfo;
	}
	public void setVehicleInfo(Vehicle vehicleInfo) {
		this.vehicleInfo = vehicleInfo;
	}
	public BigDecimal getParkingCharge() {
		return parkingCharge;
	}
	public void setParkingCharge(BigDecimal parkingCharge) {
		this.parkingCharge = parkingCharge;
	}
	public ParkingSpot getParkingSpot() {
		return parkingSpot;
	}
	public void setParkingSpot(ParkingSpot parkingSpot) {
		this.parkingSpot = parkingSpot;
	}

	@Override
	public String toString() {
		return "ParkingCollectionStore = {entryTime=" + entryTime + ", exitTime=" + exitTime + ", vehicleInfo="
				+ vehicleInfo + ", parkingCharge=" + parkingCharge + "}";
	}
	
	
	
}
