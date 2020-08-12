package com.parkinglot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parkinglot.domain.ParkingCollectionRequest;
import com.parkinglot.domain.ParkingCollectionStore;
import com.parkinglot.repository.ParkingDetailsRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/report")
public class ParkingReportController {
	
	@Autowired
	private ParkingDetailsRepository parkingDetailsRepository;
	
	@GetMapping("/generate")
	@ApiOperation(value = "print report of collections", produces = "application/json")
	public ResponseEntity<List<ParkingCollectionStore>> collectAmount(){
		return ResponseEntity.ok(parkingDetailsRepository.generateReport());
	}
}
