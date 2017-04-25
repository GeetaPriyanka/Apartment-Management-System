package com.spring.app.service;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.app.dao.Occupied_apartmentDAO;
import com.spring.app.model.Occupied_apartment;
@Service
public class Occupied_apartmentServiceImpl implements Occupied_apartmentService {

	@Autowired
	Occupied_apartmentDAO occupied_apartmentDAO;
	
	
	public void setOccupied_apartmentDAO(Occupied_apartmentDAO occupied_apartmentDAO) {
		this.occupied_apartmentDAO = occupied_apartmentDAO;
	}

	@Override
	@Transactional
	public List<Occupied_apartment> occupiedApartmentsList() {
		// TODO Auto-generated method stub
		return occupied_apartmentDAO.occupiedApartmentsList();
	}

	@Override
	@Transactional
	public void addOccupiedApartment(String unit, String email) {
		// TODO Auto-generated method stub
		Occupied_apartment occuaptmnt= new Occupied_apartment();
		 Calendar currenttime = Calendar.getInstance();
		 Date sqlCurrentdate = new Date((currenttime.getTime()).getTime());
		 currenttime.add(Calendar.YEAR, 1);
		 Date sqlYeardate = new Date((currenttime.getTime()).getTime());
		occuaptmnt.setUnit(unit);
		occuaptmnt.setEmail(email);
		occuaptmnt.setLeaseStart(sqlCurrentdate);
		occuaptmnt.setLeaseEnd(sqlYeardate);
		occuaptmnt.setBill(0);
		occupied_apartmentDAO.addOccupiedApartment(occuaptmnt);
	}

	@Override
	@Transactional
	public void deleteOccupiedApartment(String unit) {
		// TODO Auto-generated method stub
		occupied_apartmentDAO.deleteOccupiedApartment(unit);
	}

	@Override
	@Transactional
	public Date getLeaseStaetDate(String unit) {
		// TODO Auto-generated method stub
		Date lease_start=null;
		List<Occupied_apartment> ocp_apt =  occupied_apartmentDAO.occupiedApartmentsList();
		for (Occupied_apartment occupied_apartment : ocp_apt) {
			if(occupied_apartment.getUnit().equals(unit)){
				lease_start = occupied_apartment.getLeaseStart();
			}
		}
		return lease_start;
	}

	@Override
	@Transactional
	public Date getLeasendDate(String unit) {
		Date lease_end=null;
		List<Occupied_apartment> ocp_apt =  occupied_apartmentDAO.occupiedApartmentsList();
		for (Occupied_apartment occupied_apartment : ocp_apt) {
			if(occupied_apartment.getUnit().equals(unit)){
				lease_end = occupied_apartment.getLeaseEnd();
			}
		}
		return lease_end;
	}

	@Override
	@Transactional
	public float getBill(String unit) {
		float bill=0;
		List<Occupied_apartment> ocp_apt =  occupied_apartmentDAO.occupiedApartmentsList();
		for (Occupied_apartment occupied_apartment : ocp_apt) {
			if(occupied_apartment.getUnit().equals(unit)){
				bill = occupied_apartment.getBill();
			}
		}
		return bill;
	}

@Override
	@Transactional
	public void updateLeaseEndDate(int months, Date leaseEndDate, String unit) {
		// TODO Auto-generated method stub
		
		System.out.println("leaseEndDate: "+leaseEndDate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(leaseEndDate);
		cal.add(Calendar.MONTH, months);
		 java.sql.Date sqlDate = new java.sql.Date(cal.getTime().getTime());
		
		occupied_apartmentDAO.updateOccupiedLeaseEndDate(unit, sqlDate);
	}

}
