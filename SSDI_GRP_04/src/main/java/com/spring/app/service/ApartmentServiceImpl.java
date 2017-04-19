package com.spring.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.app.dao.ApartmentDAO;
import com.spring.app.model.Available_apartment;

@Service
public class ApartmentServiceImpl implements ApartmentService {


	private ApartmentDAO apartmentDAO;

	public void setApartmentDAO(ApartmentDAO apartmentDAO) {
		this.apartmentDAO = apartmentDAO;
	}
	
	@Override
	public void addAvailableApartment(String unit){
		Available_apartment availableApartment= new Available_apartment();
		availableApartment.setUnit(unit);
		this.apartmentDAO.addAvailableApartment(availableApartment);

	}
	@Override
	@Transactional
	public List<Available_apartment> listApartments() {
		return this.apartmentDAO.listApartments();
	}
	
	@Override
	public void deleteAvailableApartment(String unit) {
		// TODO Auto-generated method stub
		this.apartmentDAO.deleteAvailableApartment(unit);
	}

}
