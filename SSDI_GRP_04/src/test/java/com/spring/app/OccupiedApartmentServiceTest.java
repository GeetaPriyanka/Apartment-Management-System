package com.spring.app;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.spring.app.dao.Occupied_apartmentDAO;
import com.spring.app.model.Occupied_apartment;
import com.spring.app.service.Occupied_apartmentServiceImpl;

public class OccupiedApartmentServiceTest {

	private static Occupied_apartmentServiceImpl occaptServiceMock;
	private static Occupied_apartmentDAO occaptDAO;
	private static Occupied_apartment occapt1;
	private static Occupied_apartment occapt2;
	
	@BeforeClass
	 public static void setUp(){
		occaptServiceMock=mock(Occupied_apartmentServiceImpl.class);
		
		Date d=new Date(0);
		
		occapt1=new Occupied_apartment();
		occapt2=new Occupied_apartment();
		occapt1.setBill(45);
		occapt1.setEmail("sneha@g");
		occapt1.setLeaseEnd(d);
		occapt1.setLeaseStart(d);
		occapt1.setUnit("9505J");

		occapt2.setBill(35);
		occapt2.setEmail("snehaV@g");
		occapt2.setLeaseEnd(d);
		occapt2.setLeaseStart(d);
		occapt2.setUnit("9450");

		when(occaptServiceMock.occupiedApartmentsList()).thenReturn(Arrays.asList(occapt1,occapt2));
	}

	@Test
	public void testGetAllOccApt() {
		List<Occupied_apartment> occlist=occaptServiceMock.occupiedApartmentsList();
		assertEquals(2, occlist.size());
		Occupied_apartment o=occlist.get(0);
		assertEquals("9505J",o.getUnit());
	}

	@Test
	public void testAddOccApt() {
		Occupied_apartment occuaptmnt = new Occupied_apartment();
		occuaptmnt.setEmail("ex@ex.ex");
		occuaptmnt.setBill(1);
		occuaptmnt.setUnit("Example unit");
		occaptServiceMock.addOccupiedApartment(occuaptmnt.getUnit(),occuaptmnt.getEmail());
		List<Occupied_apartment> occlist = occaptServiceMock.occupiedApartmentsList();
		for(Occupied_apartment o : occlist){
			if("Example unit".equals(o.getUnit())){
				assertEquals("Example unit", o.getUnit());
				assertEquals("ex@ex.ex", o.getEmail());
				
			}
		}
	}

	@Test 
	public void testGetLeaseStartDate(){
		when(occaptServiceMock.getLeaseStaetDate(occapt1.getUnit())).thenReturn(occapt1.getLeaseStart());
		Date f=occaptServiceMock.getLeaseStaetDate(occapt1.getUnit());
		assertEquals(f,occapt1.getLeaseStart());
	}
	
	@Test 
	public void testGetLeaseEndDate(){
		when(occaptServiceMock.getLeasendDate(occapt1.getUnit())).thenReturn(occapt1.getLeaseEnd());
		Date f=occaptServiceMock.getLeasendDate(occapt1.getUnit());
		assertEquals(f,occapt1.getLeaseEnd());
	}
}
