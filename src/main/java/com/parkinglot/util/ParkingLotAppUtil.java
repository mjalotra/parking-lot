package com.parkinglot.util;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class ParkingLotAppUtil {
	
	public long getDiffByTimeUnit(long totalDurationDiff, TimeUnit timeUnit) {
		return timeUnit.convert(totalDurationDiff, TimeUnit.MILLISECONDS);
	}
}
