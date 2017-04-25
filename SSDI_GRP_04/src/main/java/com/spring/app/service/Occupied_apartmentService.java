package com.spring.app.service;

import java.sql.Date;
import java.util.List;

import com.spring.app.model.Occupied_apartment;

public interface Occupied_apartmentService {
	public List<Occupied_apartment> occupiedApartmentsList();
	public void addOccupiedApartment(String unit, String email);
	public void deleteOccupiedApartment(String unit);
	public Date getLeaseStaetDate(String unit);
	public Date getLeasendDate(String unit);
	public float getBill(String unit);
	public void updateLeaseEndDate(int months, Date leaseEndDate, String unit);
}
