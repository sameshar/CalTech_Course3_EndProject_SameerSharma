package com.BookingMyCabBuddy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.BookingMyCabBuddy.bean.Customer;
import com.BookingMyCabBuddy.dao.CustomerDAO;

@Service
public class CustomerService {

	@Autowired
	CustomerDAO customerDAO;
	
//Method to CREATE a customer account after ID and Email address uniqueness validation
	
	public String createCustomer(Customer customer) {
		System.out.println("SC ~ CreateCustomer Method ~ " + customer.toString());
		Optional<Customer> result = customerDAO.findById(customer.getCustomerid());
		String resultEmail = customer.getEmail();
		if (result.isPresent()) {
			Customer cc = result.get();
			if (cc.getEmail().equals(resultEmail)) {
				return "email exists";
			}
		} else {
			customerDAO.save(customer);
			
		}
		return "customer detail stored";
	}
	
	//Method to FIND a customer account after ID and Email address uniqueness validation
	
	public Optional<Customer> findCustomer(int customerid) {
		Optional<Customer> searchCustomerResult = customerDAO.findById(customerid);
		System.out.println("Service Class ~ findCustomer Method " + searchCustomerResult);
		return searchCustomerResult;
	}
	
	//Method to UPDATE customer account
	
	public String updateCustomer(int customerid, Customer customer) {
		System.out.println("Service class ~ updateCustomer method ~ Email received is " + customer.getEmail());
		System.out.println("Service class ~ updateCustomer method ~ Name received is " + customer.getCustomername());
		customerDAO.save(customer);
		return "record updated";
	}
	
	//Method to DELETE customer account
	
	public String deleteCustomer(int customerid) {
		System.out.println("Service delete method called." + customerid);
		customerDAO.deleteById(customerid);
		return "record deleted";
	}
}
