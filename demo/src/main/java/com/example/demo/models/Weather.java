package com.example.demo.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Weather{
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	int location_id;
	String loc;
	double temp;
	LocalDateTime date;
	
	public Weather() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Weather(int location_id, String loc, double temp, LocalDateTime date) {
		super();
		this.location_id = location_id;
		this.loc = loc;
		this.temp = temp;
		this.date = date;
	}

	public int getLocation_id() {
		return location_id;
	}

	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	
}
