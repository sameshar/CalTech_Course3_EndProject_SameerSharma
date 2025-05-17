package com.BookingMyCabBuddy.service;

import java.awt.PageAttributes.MediaType;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.BookingMyCabBuddy.bean.Booking;
import com.BookingMyCabBuddy.bean.Customer;
import com.BookingMyCabBuddy.dao.BookingDAO;
import com.BookingMyCabBuddy.dao.CustomerDAO;

@Service
public class BookingService {

	@Autowired
	BookingDAO bookingdao;
	
	@Autowired
	CustomerService custService;
	
	@Autowired
	CustomerDAO custDAO;
	
	//method to generate a random integer for bookingID
//		public int intGenerator() {
//			Random randomintgen = new Random();
//			return randomintgen.nextInt(1000);
//		}
	
	//generate bookingID
//	int bookingID = intGenerator();
//	System.out.println(bookingID);
//	booking.setBookingID(bookingID);
	
	public String createBooking(Booking booking, String email) {
			System.out.println("ServiceClass.ValidationMethod > " + booking.toString() + email.toString());
			
			//Optional<Customer> result = custDAO.findById(customer.getCustomerID());			
						
			//Business Logic
			
//			if (result.isEmpty()) {
//				return "Customer ID entered do not exist. <a href='http://localhost:8762/'>Register here</a>";
//			} else 
				if (email != null) {
				String exists = custDAO.existsByEmail(email);
				System.out.println(exists);
		        if (exists == null) {
		        	return "Customer Email entered do not exist. <a href='http://localhost:8762/#customerPortalForm'>Register here</a>";
		        } else {
		        	bookingdao.save(booking);
		        	System.out.println("Service Class ~ createBooking Method ~ " + booking);
		        	return "Booking Saved";
		        }
			}
				return "end to booking service class";
			}}
