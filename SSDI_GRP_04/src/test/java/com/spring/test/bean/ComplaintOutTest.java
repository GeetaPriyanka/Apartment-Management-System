package com.spring.test.bean;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.spring.app.bean.ComplaintOut;

public class ComplaintOutTest {
public static ComplaintOut cout;

@BeforeClass
public static void setUp(){
	cout=new ComplaintOut();
	cout.setComplaint_number(12);
	cout.setDescription("issue");
	cout.setResolved("no");
	cout.setSeverity("high");
	cout.setType("electric");
	cout.setUnit("12f");
	
}
	@Test
	public void getComplainttest() {
      assertEquals(12,cout.getComplaint_number());
	}
	@Test
	public void getDescriptiontest() {
		assertEquals("issue",cout.getDescription());
	}
	@Test
	public void getResolvedtest() {
		assertEquals("no",cout.getResolved());
	}
	
	@Test
	public void getSeverityttest() {
		assertEquals("high",cout.getSeverity());
	}
	@Test
	public void getTypetest() {
		assertEquals("electric",cout.getType());
	}
	@Test
	public void getUnittest() {
		assertEquals("12f",cout.getUnit());
	}
	

}
