package com.spring.test.bean;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.spring.app.bean.deleteApartmentBean;

public class DeleteApartmentBeanTest {

	public static deleteApartmentBean dab;
	
	@BeforeClass
	public static void setUp(){
		dab=new deleteApartmentBean();
		dab.setVacate("vacate");
	}
	@Test
	public void getVacatetest() {
		assertEquals("vacate",dab.getVacate());
	}

}
