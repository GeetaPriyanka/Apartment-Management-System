package com.spring.app.dao;

import java.sql.Date;
import java.util.List;


import com.spring.app.model.Occupied_apartment;

public interface Occupied_apartmentDAO {
	public List<Occupied_apartment> occupiedApartmentsList();
	public void addOccupiedApartment(Occupied_apartment occuaptmnt);
	public void deleteOccupiedApartment(String unit);
	public void updateOccupiedLeaseEndDate(String unit, Date lease_end); 
}
