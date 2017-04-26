package com.spring.test.model;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import com.spring.app.model.Complaint;

public class ComplaintModelTest {
	private static Complaint complaint ;
	
	@BeforeClass
	public static void setUp()
	{
		complaint=new Complaint();
		complaint.setUnit("9527A");
		complaint.setType("plumbing");
		complaint.setSeverity(2);
		complaint.setTime(10000000);
		complaint.setDescription("Desc of plumbing");
		complaint.setResolved(0);
		complaint.setResolved_by("staff");
	}
	
	@Test
	public void getUnittest() {
		assertEquals("9527A", complaint.getUnit());
	}
	@Test
	public void getTypetest() {
		assertEquals("plumbing", complaint.getType());
	}
	@Test
	public void getSeveritytest() {
		assertEquals(2, complaint.getSeverity());
	}
	@Test
	public void getDescriptionttest() {
		assertEquals("Desc of plumbing", complaint.getDescription());
	}
	@Test
	public void getResolvedtest() {
		assertEquals(0, complaint.getResolved());
	}
	@Test
	public void getResolvedBytest() {
		assertEquals("staff", complaint.getResolved_by());
	}
	@Test
	public void getTimetest() {
		assertEquals(10000000, complaint.getTime());
	}
	
}
