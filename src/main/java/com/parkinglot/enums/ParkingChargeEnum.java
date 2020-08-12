package com.parkinglot.enums;

import java.math.BigDecimal;

public enum ParkingChargeEnum {
	
	LESS_THAN_2(new BigDecimal(5) , new BigDecimal(7)),
	BETWEEN_2_TO_5(new BigDecimal(8) , new BigDecimal(10)),
	BETWEEN_5_TO_10(new BigDecimal(12) , new BigDecimal(15)),
	BETWEEN_10_TO_15(new BigDecimal(18) , new BigDecimal(22)),
	BETWEEN_15_TO_24(new BigDecimal(25) , new BigDecimal(30));
	
	private BigDecimal weekendAmount;
	private BigDecimal weekdayAmount;
	
	ParkingChargeEnum(BigDecimal weekendAmount, BigDecimal weekdayAmount){
		this.weekendAmount = weekendAmount;
		this.weekdayAmount = weekdayAmount;
	}

	public BigDecimal getWeekendAmount() {
		return this.weekendAmount;
	}

	public BigDecimal getWeekdayAmount() {
		return this.weekdayAmount;
	}
	
}
