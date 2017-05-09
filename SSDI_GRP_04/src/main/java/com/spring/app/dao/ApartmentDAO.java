package com.spring.app.dao;

import java.util.List;

import com.spring.app.model.Available_apartment;

public interface ApartmentDAO {
	public List<Available_apartment> listApartments();
	public void deleteAvailableApartment(String unit);
	public void addAvailableApartment(Available_apartment availableApartment);
}
