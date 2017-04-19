package com.spring.app.service;

import java.util.List;

import com.spring.app.model.Available_apartment;

public interface ApartmentService {
	public List<Available_apartment> listApartments();
	public void deleteAvailableApartment(String unit);
	public void addAvailableApartment(String unit);

}
