package com.FareCalcuator.controller;

import java.text.DecimalFormat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.FareCalcuator.bean.fareBean;

@RestController
public class fareController {

	// for Source Distance
	
	private double randomNum1() {
		double randomRawNum1 = Math.random()*10;
		DecimalFormat df = new DecimalFormat("#.##");
		double formattedValue = Double.parseDouble(df.format(randomRawNum1));
		double randomNum1 = formattedValue;
		System.out.println("Random Number 1 (first attempt) " + randomNum1);
		if (randomNum1==0) {
			randomRawNum1 = Math.random()*10;
			DecimalFormat df1 = new DecimalFormat("#.##");
			formattedValue = Double.parseDouble(df1.format(randomRawNum1));
			randomNum1 = formattedValue;
			System.out.println("Random Number 1 was 0 so (Second attempt) " + randomNum1);
		}
		return randomNum1;}
	
	// for Destination Distance
	
	private double randomNum2() {
		double randomRawNum2 = Math.random()*10;
		DecimalFormat df = new DecimalFormat("#.##");
		double formattedValue = Double.parseDouble(df.format(randomRawNum2));
		double randomNum2 = formattedValue;
		System.out.println("Random Number 2 (First Attempt) " + randomNum2);
		if (randomNum2==0) {
			randomRawNum2 = Math.random()*10;
			DecimalFormat df1 = new DecimalFormat("#.##");
			formattedValue = Double.parseDouble(df1.format(randomRawNum2));
			randomNum2 = formattedValue;
			System.out.println("Random Number 2 was 0  (Second Attempt) " + randomNum2);
		}
		return randomNum2;}
	
	// For Rate generation
	
	private double randomRate() {
		double randomRawRate = Math.random()*10;
		DecimalFormat df = new DecimalFormat("#.##");
		double formattedValue = Double.parseDouble(df.format(randomRawRate));
		double randomRate = formattedValue;
		System.out.println("Random Rate (First Attempt) " + randomRate);
		if (randomRate==0) {
			randomRate = Math.round(Math.random()*10);
		}
		return randomRate;}
	
	// http://localhost:8763/farecal
	@GetMapping(value = "/farecal/{source}/{destination}")
	public fareBean fareCalculation(@PathVariable String source, @PathVariable String destination) {
		fareBean fare1 = new fareBean();

		double sourceMiles = randomNum1();
		double destMiles = randomNum2();
		double distanceraw = sourceMiles + destMiles;
		
		DecimalFormat df1 = new DecimalFormat("#.##");
		double formattedValueDistance = Double.parseDouble(df1.format(distanceraw));
		double distance = formattedValueDistance;
		
		double rate = randomRate();
		double finalamountraw = rate * distance;
		
		DecimalFormat df = new DecimalFormat("#.##");
		double formattedValue = Double.parseDouble(df.format(finalamountraw));
		
		double finalamount = formattedValue;
		
		
		
		System.out.println("Distance is " + distance + " miles.");
		System.out.println("Rate is $" + rate);
		System.out.println("Final amount of this trip is $" + finalamount);
		
		fare1.setRate(rate);
		fare1.setDistance(distance);
		fare1.setFinalamount(finalamount);
		fare1.setDestination(destination);
		fare1.setSource(source);
		
		return fare1;
	}
	
	// http://localhost:8763/ratecal
	@GetMapping(value = "/ratecal")
	public double rateCalculation() {	
		double rate = randomRate();
		System.out.println("Rate is $" + rate);

		return rate;
	}
	
	// http://localhost:8763/distancecal
	@GetMapping(value = "/distancecal")
	public double distanceCal() {	
		double sourceMiles = randomNum1();
		double destMiles = randomNum2();
		double distanceraw = sourceMiles + destMiles;
		
		DecimalFormat df1 = new DecimalFormat("#.##");
		double formattedValueDistance = Double.parseDouble(df1.format(distanceraw));
		double distance = formattedValueDistance;

		return distance;
	}
	

	}
