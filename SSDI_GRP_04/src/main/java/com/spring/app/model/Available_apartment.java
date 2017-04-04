package com.spring.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="available_apartment")
public class Available_apartment {
	
	@Id
	@Column(name="unit")
	String unit;
	@Column(name="rent")
	int rent;
	@Column(name="bhk")
	int bhk;
	@Column(name="area")
	int area;
	
	public Available_apartment() {
		super();
	}
	public Available_apartment(String unit, int rent, int bhk, int area) {
		super();
		this.unit = unit;
		this.rent = rent;
		this.bhk = bhk;
		this.area = area;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public int getRent() {
		return rent;
	}
	public void setRent(int rent) {
		this.rent = rent;
	}
	public int getBhk() {
		return bhk;
	}
	public void setBhk(int bhk) {
		this.bhk = bhk;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	
}
