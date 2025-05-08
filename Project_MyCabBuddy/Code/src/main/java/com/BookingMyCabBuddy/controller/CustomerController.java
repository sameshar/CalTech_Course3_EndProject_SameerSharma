package com.BookingMyCabBuddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BookingMyCabBuddy.bean.Customer;
import com.BookingMyCabBuddy.dao.CustomerDAO;
import com.BookingMyCabBuddy.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;

	// http://localhost:8762/createcustomer
	@PostMapping(value = "createcustomer", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String createCustomer(@ModelAttribute Customer customer) {
		System.out.println(customer.toString());
		return customerService.createCustomer(customer);
		//return "customer";
	}
	

}
