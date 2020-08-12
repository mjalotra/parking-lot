package com.parkinglot.controller;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parkinglot.domain.ParkingCollectionRequest;
import com.parkinglot.repository.ParkingDetailsRepository;
import com.parkinglot.service.ParkingCollectionService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/collector")
public class ParkingCollectionController {
	
	@Autowired
	private ParkingCollectionService collectionService;
	
	@Autowired
	private ParkingDetailsRepository parkingDetailsRepository;
	
	@PostMapping("/collect-amount")
	@ApiOperation(value = "parking cost calculating API based upon given enrty and exit time", consumes = "application/json", produces = "application/json")
	public ResponseEntity<BigDecimal> collectAmount(@RequestBody ParkingCollectionRequest collectionRequest){
		BigDecimal totalCharge = collectionService.calculateAmount(collectionRequest.getEntryTime(), collectionRequest.getExitTime());
		parkingDetailsRepository.storeParkingInfoPostCollection(totalCharge, collectionRequest);
		return ResponseEntity.ok(totalCharge);
	}
	
	
	@PostMapping("/test")
	@ApiOperation(value = "test", consumes = "application/json", produces = "application/json")
	public ResponseEntity<BigDecimal> test(@Valid @RequestBody ParkingCollectionRequest collectionRequest){
		System.out.println(collectionRequest.getSomeThing());
		/*
		 * HATEOAS (Hypermedia As The Engine of Application State) 
		 * 
		 * add jar spring boot starter hateos
		 * 
		 * EntityModel model = new EntityModel(user); 
		 * ebMvcLinkBuilder linkTo =
		 * WebMvcLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).
		 * collectAmount());
		 * 
		 * model.add(linkTo.withRel("collect-amount"));
		 */
		return ResponseEntity.ok(null);
	}
	
}
