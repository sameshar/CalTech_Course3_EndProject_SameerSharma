package com.BookingMyCabBuddy.controller;

import java.net.http.HttpRequest;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
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
	@PostMapping(value = "/createbooking", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public Booking createBooking(@ModelAttribute Booking booking, Model mm) {
		//System.out.println(booking.toString());
		mm.addAttribute(booking);
		System.out.println(booking);
		//return bookingService.createBooking(booking, email);
		return booking;
//	}

//	@PostMapping(value = "createbooking", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//	public String createBooking(HttpServletRequest req, Booking booking) {
//		String email = req.getParameter("email");
//		String source_loc = req.getParameter("source_loc");
//		String destination_loc = req.getParameter("destination_loc");
//		int distanceTravelled = Integer.parseInt(req.getParameter("distanceTravelled"));
//		int ratePerMile = Integer.parseInt(req.getParameter("ratePerMile"));
//		int finalAmt = Integer.parseInt(req.getParameter("finalAmt"));
//		
//		booking.setEmail(email);
//		booking.setSource_loc(source_loc);
//		booking.setDestination_loc(destination_loc);
//		booking.setDistanceTravelled(distanceTravelled);
//		booking.setRatePerMile(ratePerMile);
//		booking.setFinalAmt(finalAmt);
//		
//		System.out.println(booking.toString());
//		System.out.println("Test");
//		//bookingService.createBooking(booking, email);
//		return "hello";
	}

}
