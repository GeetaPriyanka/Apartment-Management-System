package com.spring.test.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.spring.app.dao.ApartmentDAO;
import com.spring.app.dao.ApartmentDAOImpl;
import com.spring.app.model.Available_apartment;
import com.spring.app.service.ApartmentServiceImpl;

public class ApartmentServiceTest {

	private static ApartmentServiceImpl aptServiceMock;
	private static Available_apartment apt1;
	private static Available_apartment apt2,apt3;
	private static ApartmentDAO aptdao;

	@BeforeClass
	public static void setUp(){
		//Create mock object of BookDAL
		aptServiceMock = mock(ApartmentServiceImpl.class);
		aptdao=mock(ApartmentDAOImpl.class);
		//Create few instances of Apartment class.
		apt1 = new Available_apartment("9504F",1000,2,1415);
		apt2 = new Available_apartment("954F",1500,4,2000);
		when(aptServiceMock.listApartments()).thenReturn(Arrays.asList(apt1,apt2));	
		// when(aptDAOMock.deleteAvailableApartment("9504F"));
	}

	@Test
	public void testGetAllApartments() throws Exception {

		List<Available_apartment> allApt = aptServiceMock.listApartments();
		assertEquals(2, allApt.size());
		Available_apartment a = allApt.get(0);
		assertEquals(1000, a.getRent());
		assertEquals("9504F", a.getUnit());
		assertEquals(2, a.getBhk());
	}
	@Test
	public void testaddavailableapartment()
{
		apt3=new Available_apartment("9504F",1000,2,1415);
		aptdao.addAvailableApartment(apt3);
		assertEquals("9504F", apt3.getUnit());

}
	
	@Test
	public void deleteavailableapartment()
	{
		aptServiceMock.deleteAvailableApartment("9504F");
		verify(aptServiceMock,times(1)).deleteAvailableApartment("9504F");

	}
	
}
