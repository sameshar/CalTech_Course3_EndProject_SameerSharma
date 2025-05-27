package com.BookingMyCabBuddy.bean;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerid;
	private String customername;
	private String email;
	private String phonenumber;
	private String paymentmethod;
	
	//Setter & Getter Methods
	/**
	 * @return the customerid
	 */
	public int getCustomerid() {
		return customerid;
	}
	/**
	 * @param customerid the customerid to set
	 */
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	/**
	 * @return the customername
	 */
	public String getCustomername() {
		return customername;
	}
	/**
	 * @param customername the customername to set
	 */
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the phonenumber
	 */
	public String getPhonenumber() {
		return phonenumber;
	}
	/**
	 * @param phonenumber the phonenumber to set
	 */
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	/**
	 * @return the paymentmethod
	 */
	public String getPaymentmethod() {
		return paymentmethod;
	}
	/**
	 * @param paymentmethod the paymentmethod to set
	 */
	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}
	/**
	 * @param customerid
	 * @param customername
	 * @param email
	 * @param phonenumber
	 * @param paymentmethod
	 */
	public Customer(int customerid, String customername, String email, String phonenumber, String paymentmethod) {
		super();
		this.customerid = customerid;
		this.customername = customername;
		this.email = email;
		this.phonenumber = phonenumber;
		this.paymentmethod = paymentmethod;
	}
	/**
	 * 
	 */
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", customername=" + customername + ", email=" + email
				+ ", phonenumber=" + phonenumber + ", paymentmethod=" + paymentmethod + "]";
	}	
}
