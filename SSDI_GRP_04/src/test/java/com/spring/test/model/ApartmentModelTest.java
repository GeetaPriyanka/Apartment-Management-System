package com.spring.test.model;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import com.spring.app.model.Available_apartment;

public class ApartmentModelTest {
	
	private static Available_apartment apt1;
	private static Available_apartment apt2;
	@BeforeClass
	public static void setUp(){
		
		apt1 = new Available_apartment("9504F",1000,2,1415);
		apt2 = new Available_apartment("954F",1500,4,2000);

	}

	@Test
	public void getUnittest() {
	assertEquals("9504F",apt1.getUnit());
	assertEquals("954F",apt2.getUnit());

	}
	@Test
	public void getRenttest() {
	assertEquals(1000,apt1.getRent());
	assertEquals(1500,apt2.getRent());

	}

	@Test
	public void getBhktest() {
	assertEquals(2,apt1.getBhk());
	assertEquals(4,apt2.getBhk());

	}

	@Test
	public void getAreatest() {
	assertEquals(1415,apt1.getArea());
	assertEquals(2000,apt2.getArea());
	}


}
