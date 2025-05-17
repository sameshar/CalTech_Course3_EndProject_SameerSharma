package com.FareCalcuator.bean;

public class fareBean {
	private String source;
	private String  destination;
	private double  distance;
	private double rate;
	private double finalamount;
	
	// Setter & Getter
	
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
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public double getFinalamount() {
		return finalamount;
	}
	public void setFinalamount(double finalamount) {
		this.finalamount = finalamount;
	}
	
	// Constructor with fields
	
	public fareBean(String source, String destination, double distance, double rate, double finalamount) {
		super();
		this.source = source;
		this.destination = destination;
		this.distance = distance;
		this.rate = rate;
		this.finalamount = finalamount;
	}
	
	// Constructor without fields
	
	public fareBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
