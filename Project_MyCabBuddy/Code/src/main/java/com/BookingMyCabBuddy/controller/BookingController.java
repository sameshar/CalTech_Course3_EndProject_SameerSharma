package com.BookingMyCabBuddy.controller;

import java.net.http.HttpRequest;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BookingMyCabBuddy.bean.Booking;
import com.BookingMyCabBuddy.bean.Customer;
import com.BookingMyCabBuddy.service.BookingService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	

	//http://localhost:8762/createbooking
//	@PostMapping(value = "createbooking")
//	public String createBooking(@ModelAttribute Booking booking, String email) {
//		System.out.println(booking.toString());
//		System.out.println("Test");
//		return bookingService.createBooking(booking, email);
//		//return "hello";
//	}

	@PostMapping(value = "createbooking")
	public String createBooking(HttpServletRequest req, Booking booking) {
		String email = req.getParameter("email");
		String source_loc = req.getParameter("source_loc");
		String destination_loc = req.getParameter("destination_loc");
		int distanceTravelled = Integer.parseInt(req.getParameter("distanceTravelled"));
		int ratePerMile = Integer.parseInt(req.getParameter("ratePerMile"));
		int finalAmt = Integer.parseInt(req.getParameter("finalAmt"));
		
		booking.setEmail(email);
		booking.setSource_loc(source_loc);
		booking.setDestination_loc(destination_loc);
		booking.setDistanceTravelled(distanceTravelled);
		booking.setRatePerMile(ratePerMile);
		booking.setFinalAmt(finalAmt);
		
		System.out.println(booking.toString());
		System.out.println("Test");
		return bookingService.createBooking(booking, email);
		//return "hello";
	}

}
