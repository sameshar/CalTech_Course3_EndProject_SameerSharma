package com.BookingMyCabBuddy.bean;

import org.springframework.lang.NonNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingid;
	private String source;
	private String destination;
	private double distancetravelled;
	private double ratepermile;
	private double finalamt;
	private String email;
	
	// Setter and Getter

	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getDistancetravelled() {
		return distancetravelled;
	}

	public void setDistancetravelled(double distancetravelled) {
		this.distancetravelled = distancetravelled;
	}

	public double getRatepermile() {
		return ratepermile;
	}

	public void setRatepermile(double ratepermile) {
		this.ratepermile = ratepermile;
	}

	public double getFinalamt() {
		return finalamt;
	}

	public void setFinalamt(double finalamt) {
		this.finalamt = finalamt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/** Constructor with Fields
	 * @param bookingid
	 * @param source
	 * @param destination
	 * @param distancetravelled
	 * @param ratepermile
	 * @param finalamt
	 * @param confirmationid
	 * @param email
	 */
	public Booking(int bookingid, String source, String destination, double distancetravelled, double ratepermile,
			double finalamt, String email) {
		super();
		this.bookingid = bookingid;
		this.source = source;
		this.destination = destination;
		this.distancetravelled = distancetravelled;
		this.ratepermile = ratepermile;
		this.finalamt = finalamt;

		this.email = email;
	}

	/** Constructor without fields
	 * 
	 */
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	// toString
	
	@Override
	public String toString() {
		return "Booking [bookingid=" + bookingid + ", source=" + source + ", destination=" + destination
				+ ", distancetravelled=" + distancetravelled + ", ratepermile=" + ratepermile + ", finalamt=" + finalamt
				+ ", email=" + email + "]";
	}
	

	
	
	
}
