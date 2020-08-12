package com.parkinglot.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.parkinglot.domain.ParkingCollectionRequest;
import com.parkinglot.domain.ParkingCollectionStore;
import com.parkinglot.domain.Vehicle;
import com.parkinglot.repository.ParkingDetailsRepository;

@Component
public class ParkingDetailsRepositoryImpl implements ParkingDetailsRepository {
	
	
	List<ParkingCollectionStore> tempParkingStore = null;
	@PostConstruct
	public void init() {
		this.tempParkingStore = new ArrayList<>();
	}
	
	public void storeParkingInfoPostCollection(BigDecimal parkingCharge, ParkingCollectionRequest collectionRequest) {
		ParkingCollectionStore store = 
					new ParkingCollectionStore(
							collectionRequest.getEntryTime(),
							collectionRequest.getExitTime(),
							new Vehicle(collectionRequest.getVehicle().getRegisterationNumber()), parkingCharge);
		this.tempParkingStore.add(store);
	}

	@Override
	public List<ParkingCollectionStore> generateReport() {
		return this.tempParkingStore;
	}
}
