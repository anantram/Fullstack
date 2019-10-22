package com.restapi.com.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Location {
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public Location() {
		
	}
	public Location(String address, String city, String state, String country) {
		super();
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	private String address;
	private String city;
	private String state;
	private String country;
}
