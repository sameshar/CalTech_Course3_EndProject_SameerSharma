package com.BookingMyCabBuddy.service;

import java.awt.PageAttributes.MediaType;
import java.text.DecimalFormat;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

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
	
	@Autowired
    private RestTemplate restTemplate;
	
	public String createBooking(String source, String destination, String email) {
			System.out.println("ServiceClass Input received ~ > " + source + " " + destination + " " + email);
				if (email != null) {
				String exists = custDAO.existsByEmail(email);
				System.out.println("Email is " + exists);
		        if (exists == null) {
		        	return "Customer Email entered do not exist. <a href='http://localhost:8762/#customerPortalForm'>Register here</a>";
		        } else {
		        	// this is calling fareCal object and storing as String value
		        	//String bookingDetails = restTemplate.getForObject("http://localhost:8763/farecal/" + source + "/" + destination, String.class);
		        	//System.out.println("Service Class ~ createBooking Method ~ bookingDetails" + bookingDetails);
		        	
		        	double bookingRate =  restTemplate.getForObject("http://localhost:8763/ratecal", double.class);
		        	System.out.println("Rate received: $" + bookingRate);
		        	
		        	double bookingDistance =  restTemplate.getForObject("http://localhost:8763/distancecal", double.class);
		        	System.out.println("Distance received: $" + bookingDistance);
		        	
		        	double bookingFinalAmtRaw = bookingDistance * bookingRate;
		    		DecimalFormat df1 = new DecimalFormat("#.##");
		    		double formattedValueDistance = Double.parseDouble(df1.format(bookingFinalAmtRaw));
		    		double bookingFinalAmt = formattedValueDistance;
		        	
		        	Booking bookingDetails = new Booking();
		        	bookingDetails.setSource(source);
		        	bookingDetails.setDestination(destination);
		        	bookingDetails.setEmail(email);
		        	bookingDetails.setDistancetravelled(bookingDistance);
		        	bookingDetails.setRatepermile(bookingRate);
		        	bookingDetails.setFinalamt(bookingFinalAmt);
		        	
		        	System.out.println("Booking ready to save: " + bookingDetails);
		        	
		        	
		        	bookingdao.save(bookingDetails);
		        	return "Booking Saved";
		        }
			}
				return "end to booking service class";
			}
	
//	public String callFareCalculationMS(String souce, String destination ) {
//        String url = "http://localhost:8763//farecal/{source}/{destination}";
//        return restTemplate.getForObject(url, String.class);
//    }
}
	




