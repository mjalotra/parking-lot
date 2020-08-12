package com.parkinglot.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkinglot.enums.ParkingChargeEnum;
import com.parkinglot.service.ParkingCollectionService;
import com.parkinglot.util.ParkingLotAppUtil;

@Service
public class ParkingCollectionServiceImpl implements ParkingCollectionService {
	
	@Autowired
	private ParkingLotAppUtil util;
	
	@Override
	public BigDecimal calculateAmount(Date entryTime, Date exitTime) {
		if(exitTime.compareTo(entryTime)>0) {
			long totalDurationDiff = Math.abs(exitTime.getTime() - entryTime.getTime());
			long diffD = TimeUnit.DAYS.convert(totalDurationDiff, TimeUnit.MILLISECONDS);
			if(diffD < 1) {
				int exDay = exitTime.getDay();
				int enDay = entryTime.getDay();
				if(exDay == 6 || exDay == 0 || enDay == 6 || enDay == 0) {
					return amountForWeekends(totalDurationDiff);
				}else {
					return amountForWeekdays(totalDurationDiff);
				}
			}else {
				throw new IllegalArgumentException("Total parking time cannot surpass 24hours");
			}	
		}
		else{
			throw new IllegalArgumentException("ExitTime must always be greater than entry time");
		}
	}

	private BigDecimal amountForWeekends(long totalDurationDiff) {
		Long diffM = util.getDiffByTimeUnit(totalDurationDiff, TimeUnit.MINUTES);
		if(diffM<120L) {
			return ParkingChargeEnum.LESS_THAN_2.getWeekendAmount();
		}else if((diffM>120L && diffM<=300L)){
			return ParkingChargeEnum.BETWEEN_2_TO_5.getWeekendAmount();
		}else if((diffM>300L && diffM<=600L)){
			return ParkingChargeEnum.BETWEEN_5_TO_10.getWeekendAmount();
		}else if((diffM>600L && diffM<=900L)){
			return ParkingChargeEnum.BETWEEN_10_TO_15.getWeekendAmount();
		}
		return ParkingChargeEnum.BETWEEN_15_TO_24.getWeekendAmount();
	}

	private BigDecimal amountForWeekdays(long totalDurationDiff) {
		Long diffM = util.getDiffByTimeUnit(totalDurationDiff, TimeUnit.MINUTES);
		if(diffM<=120L) {
			return ParkingChargeEnum.LESS_THAN_2.getWeekdayAmount();
		}else if((diffM>120L && diffM<=300L)){
			return ParkingChargeEnum.BETWEEN_2_TO_5.getWeekdayAmount();
		}else if((diffM>300L && diffM<=600L)){
			return ParkingChargeEnum.BETWEEN_5_TO_10.getWeekdayAmount();
		}else if((diffM>600L && diffM<=900L)){
			return ParkingChargeEnum.BETWEEN_10_TO_15.getWeekdayAmount();
		}
		return ParkingChargeEnum.BETWEEN_15_TO_24.getWeekdayAmount();
	}

}
