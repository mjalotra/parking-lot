package com.parkinglot.repository;

import java.math.BigDecimal;
import java.util.List;

import com.parkinglot.domain.ParkingCollectionRequest;
import com.parkinglot.domain.ParkingCollectionStore;

public interface ParkingDetailsRepository {

	void storeParkingInfoPostCollection(BigDecimal totalCharge, ParkingCollectionRequest collectionRequest);

	List<ParkingCollectionStore> generateReport();
}
