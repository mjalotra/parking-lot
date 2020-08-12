package com.parkinglot.service;

import java.math.BigDecimal;
import java.util.Date;

public interface ParkingCollectionService {
	
	public BigDecimal calculateAmount(Date entryTime, Date exitTime);
}
