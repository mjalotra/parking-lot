package com.parkinglot;

import javax.annotation.PreDestroy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages= {"com.parkinglot"})
public class ParkingLotApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingLotApplication.class, args);

	}
	
	@PreDestroy
	 public void onShutDown() {
	  System.out.println("mayank- closing application...final resource cleanup");
	 }


}
