package com.BookingMyCabBuddy.bean;

import java.util.List;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;


@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerID;
	private String customerName;
	
	private String email;
	private String phoneNumber;
	private String paymentMethod;

	//Setter & Getter Methods
	
	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	//Constructors

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int customerID, String customerName, String email, String phoneNumber, String paymentMethod) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.paymentMethod = paymentMethod;
	}

	//toString
	
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", paymentMethod=" + paymentMethod + "]";
	}
}
