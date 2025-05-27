package com.BookingMyCabBuddy.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BookingMyCabBuddy.bean.Customer;
import com.BookingMyCabBuddy.service.CustomerService;


@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;

//	// http://localhost:8762/createcustomer
//	@PostMapping(value = "/createcustomer", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//	public String createCustomer(@ModelAttribute("customer") Customer customer, Model mm) {
//		System.out.println(customer.toString());
//		mm.addAttribute("customer", new Customer());
//		String result = customerService.createCustomer(customer);
//		mm.addAttribute("message", result);
//		return "index";
//	}
	
	// http://localhost:8762/createcustomer
	@PostMapping(value = "/createcustomer", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Integer createCustomer(@RequestBody Customer customer) {
		System.out.println(customer);
		String result = customerService.createCustomer(customer);
		return 1;
	}
	
	
//	// http://localhost:8762/findcustomer/{customerid}
//	@GetMapping(value = "findcustomer/{customerid}")
//	public String findcustomer(@PathVariable("customerid") int customerid, Model mm) {
//		System.out.println("Controller ~ FindCustomer Method " + customerid);
//		mm.addAttribute("customer", new Customer());
//		Optional<Customer> customer = customerService.findCustomer(customerid);
//		System.out.println(customer);
//		if (customer.isPresent()) {
//            mm.addAttribute("message", customer);
//        } else {
//            mm.addAttribute("message", "Customer ID does not exist.");
//        }
//		return "index";
//	}
	
	// http://localhost:8762/findcustomer/{customerid}
	@GetMapping(value = "findcustomer/{customerid}")
	public ResponseEntity<Customer> findcustomer(@PathVariable int customerid) {
		System.out.println("Controller ~ FindCustomer Method " + customerid);
		Optional<Customer> customer = customerService.findCustomer(customerid);
		System.out.println(customer);
		return ResponseEntity.of(customer);
//		if (customer.isPresent()) {
//            return customer;
//        } else {
//        	Customer customer1 = null;
//        	customer1.setCustomerid(customerid);
//        	customer1.setCustomername(null);
//        	customer1.setEmail(null);
//        	customer1.setPaymentmethod(null);
//        	customer1.setPhonenumber(null);
//            return Optional.of(customer1);
//        }
	}
	
		// http://localhost:8762/updatecustomer/{customerid}
		@PutMapping(value = "/updatecustomer/{customerid}", consumes = MediaType.APPLICATION_JSON_VALUE)
		public String updatecustomer(@PathVariable("customerid") int customerid, @RequestBody Customer customer, Model mm){
			System.out.println("Controller ~ Update method received " + customerid + " " + customer); 
			Optional<Customer> custidresult = customerService.findCustomer(customerid);
			System.out.println("Controller ~ Update method ~ Customer ID Search result: " + custidresult); 
			if (custidresult.isPresent()) {
				customerService.updateCustomer(customerid, customer);
				return "index";
//				mm.addAttribute("message", csreponse);
//				//return "index";
			} else {
				return "index";
			}
		}
		
		// http://localhost:8762/deletecustomer/{customerid}
		@DeleteMapping(value = "/deletecustomer/{customerid}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
		public ResponseEntity<String> deletecustomer(@PathVariable("customerid") int customerid){
			Optional<Customer> custidresult = customerService.findCustomer(customerid);
			System.out.println("from Controller ~ Delete method " + customerid); 
			if (custidresult.isPresent()) {
				customerService.deleteCustomer(customerid);
				return ResponseEntity.ok("Customer deleted successfully.");
			} else {
				return ResponseEntity.ok("failed.");
			}
			
		}
		
		
		@RequestMapping(value = "/", method = RequestMethod.GET)
		public String openPage(Model mm, Customer customer) {
			mm.addAttribute("customer", customer);
			return "index";
		}
}