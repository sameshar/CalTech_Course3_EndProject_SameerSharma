package com.BookingMyCabBuddy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BookingMyCabBuddy.bean.Booking;
import com.BookingMyCabBuddy.service.BookingService;

@RestController
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	

	//http://localhost:8762/createbooking
	@PostMapping(value = "/createbooking", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createBooking(@RequestBody Booking booking) {
		System.out.println("Booking Controller recieved: " + booking);
		
		String sourceValueReceived = booking.getSource();
		String destValueReceived = booking.getDestination();
		String emailValueReceived = booking.getEmail();
		
		System.out.println("Booking Controller ~ Values extracted: " + sourceValueReceived + " " + destValueReceived + " " + emailValueReceived);
		
		return bookingService.createBooking(sourceValueReceived, destValueReceived, emailValueReceived);
		//return "ok";
	}

}
