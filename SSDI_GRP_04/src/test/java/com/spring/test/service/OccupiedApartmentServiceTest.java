package com.spring.test.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.spring.app.dao.Occupied_apartmentDAO;
import com.spring.app.model.Available_apartment;
import com.spring.app.model.Occupied_apartment;
import com.spring.app.service.Occupied_apartmentServiceImpl;

public class OccupiedApartmentServiceTest {

	private static Occupied_apartmentServiceImpl oaImpl;
	private static Occupied_apartmentDAO occaptDAO;
	private static Occupied_apartment occapt;
	


	@BeforeClass
	public static void setUp(){
		oaImpl=mock( Occupied_apartmentServiceImpl.class);
		occaptDAO=mock(Occupied_apartmentDAO.class);
		occapt=mock(Occupied_apartment.class);
		oaImpl.setOccupied_apartmentDAO(occaptDAO);
		Date d=new Date(0);		
		occapt=new Occupied_apartment();
		occapt.setBill(45);
		occapt.setEmail("sneha@g");
		occapt.setLeaseEnd(d);
		occapt.setLeaseStart(d);
		occapt.setUnit("9505J");

	}

	@Test
	public void testGetAllOccApt() {
		List<Occupied_apartment> occlist=new ArrayList<Occupied_apartment>();
		occlist.add(occapt);
		when(occaptDAO.occupiedApartmentsList()).thenReturn(occlist);
		assertEquals(1, occlist.size());
		assertEquals("9505J",occapt.getUnit());
	}

	@Test
	public void testAddOccApt() {
		Date d=new Date(0);
		Occupied_apartment occuaptmnt = new Occupied_apartment();
		occuaptmnt.setEmail("ex@ex.ex");
		occuaptmnt.setBill(1);
		occuaptmnt.setUnit("Example unit");
		occuaptmnt.setLeaseEnd(d);
		occuaptmnt.setLeaseStart(d);
		oaImpl.addOccupiedApartment("ex@ex.ex", "Example unit");
		assertEquals(occuaptmnt.getBill(),1,0);
	}
	
	@Test 
	public void testGetLeaseStartDate(){
		when(oaImpl.getLeaseStaetDate(occapt.getUnit())).thenReturn(occapt.getLeaseStart());
		Date f=oaImpl.getLeaseStaetDate(occapt.getUnit());
		assertEquals(f,occapt.getLeaseStart());
	}

	@Test 
	public void testGetLeaseEndDate(){
		when(oaImpl.getLeasendDate(occapt.getUnit())).thenReturn(occapt.getLeaseEnd());
		Date f=oaImpl.getLeasendDate(occapt.getUnit());
		assertEquals(f,occapt.getLeaseEnd());
	}
	
	@Test
	public void testdeleteOccupiedApartment()
	{
		oaImpl.deleteOccupiedApartment("Example unit");
		verify(oaImpl,times(1)).deleteOccupiedApartment("Example unit");

	}
	
	@Test
	public void testupdateLeaseEndDate()
	{
		java.util.Calendar cal = java.util.Calendar.getInstance();
		java.util.Date utilDate = cal.getTime();
		java.sql.Date sqlDate = new Date(utilDate.getTime());
		occaptDAO.updateOccupiedLeaseEndDate("Example unit",sqlDate);
		verify(occaptDAO,times(1)).updateOccupiedLeaseEndDate("Example unit",sqlDate);

	}
	
	@Test
	public void testgetBill()
	{
		oaImpl.getBill(occapt.getUnit());
		verify(oaImpl,times(1)).getBill(occapt.getUnit());

	}
}
