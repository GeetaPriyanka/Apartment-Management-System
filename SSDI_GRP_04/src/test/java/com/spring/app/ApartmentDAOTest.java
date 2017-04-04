package com.spring.app;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.spring.app.dao.ApartmentDAOImpl;
import com.spring.app.dao.UserDAOImpl;
import com.spring.app.model.Available_apartment;
import com.spring.app.model.User;

public class ApartmentDAOTest {
	private static ApartmentDAOImpl aptDAOMock;
	private static Available_apartment apt1;
	private static Available_apartment apt2;
	
	@BeforeClass
	 public static void setUp(){
	    //Create mock object of BookDAL
	    aptDAOMock = mock(ApartmentDAOImpl.class);

	    //Create few instances of User class.
	    apt1 = new Available_apartment("9504F",1000,2,1415);
	    apt2 = new Available_apartment("954F",1500,4,2000);
	    when(aptDAOMock.listApartments()).thenReturn(Arrays.asList(apt1,apt2));	    
	  }
	
	  @Test
	  public void testGetAllApartments() throws Exception {

	    List<Available_apartment> allApt = aptDAOMock.listApartments();
	    assertEquals(2, allApt.size());
	    Available_apartment a = allApt.get(0);
	    assertEquals(1000, a.getRent());
	    assertEquals("9504F", a.getUnit());
	    assertEquals(2, a.getBhk());
	    
	  }
}
