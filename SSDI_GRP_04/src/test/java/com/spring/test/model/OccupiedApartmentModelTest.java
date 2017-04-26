package com.spring.test.model;

import static org.junit.Assert.*;
import java.sql.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import com.spring.app.model.Occupied_apartment;


public class OccupiedApartmentModelTest {
	
	public static Occupied_apartment occapt1;
	public static Date d=new Date(1969,1,31);
	@BeforeClass
	public static void setup(){
		
		occapt1=new Occupied_apartment();
		occapt1.setBill(45);
		occapt1.setEmail("snehav@g");
		occapt1.setLeaseEnd(d);
		occapt1.setLeaseStart(d);
		occapt1.setUnit("9505J");
	}
	@Test
	public void getBilltest() {
assertEquals(45,occapt1.getBill(),0);
	}
	@Test
	public void getEmailtest() {
		assertEquals("snehav@g", occapt1.getEmail());
	}
	@Test
	public void getLeaseEndtest() {
		assertEquals(d, occapt1.getLeaseEnd());
	}
	@Test
	public void getLeaseStarttest() {
	
		assertEquals(d, occapt1.getLeaseStart());
	}

	@Test
	public void getUnittest() {
		assertEquals("9505J", occapt1.getUnit());
	}
	
	

}
