package com.spring.app;


import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.spring.app.model.Complaint;

public class ComplaintServiceImplTest {

	private static Complaint complaintMock;

	private static class SystemMock extends Mockito{
		public static long currentTimeMillis(){
			return 10000000L;
		}
	}
/*	@Test
	public void testAddDate(){
		new SystemMock();
		long currentTime=System.currentTimeMillis();
		assertEquals(10000000L,currentTime);
	}
*/
	@BeforeClass
	public static void setUp(){
	complaintMock = mock(Complaint.class);

	complaintMock=new Complaint();
	complaintMock.setUnit("9523F");
	complaintMock.setType("Plumbing");
	complaintMock.setSeverity(2);
	complaintMock.setTime(SystemMock.currentTimeMillis());
	complaintMock.setDescription("Desc of plumbing");
	
}
@Test
public void testAddComplaintPositive() throws Exception  {
	
	assertEquals("9523F",complaintMock.getUnit());
	assertEquals("Plumbing",complaintMock.getType());
	assertEquals(2,complaintMock.getSeverity());
	assertEquals("Desc of plumbing",complaintMock.getDescription());
	assertEquals(10000000L,complaintMock.getTime());
	

}


@Test
public void testAddComplaintNegative1() throws Exception {
	
	assertEquals("9543F",complaintMock.getUnit());
	assertEquals("Plumbing",complaintMock.getType());
	assertEquals(2, complaintMock.getSeverity());
	assertEquals("Desc of plumbing",complaintMock.getDescription());
	assertEquals(10000000L,complaintMock.getTime());
	

}


@Test
public void testAddComplaintNegative2() throws Exception {
	assertEquals("9543F",complaintMock.getUnit());
	assertEquals("carpentry",complaintMock.getType());
	assertEquals(2, complaintMock.getSeverity());
	assertEquals("Desc of plumbing",complaintMock.getDescription());
	assertEquals(10000000L,complaintMock.getTime());
	
	
}

@Test
public void testAddComplaintNegative3() throws Exception {
	
	assertEquals("9543F",complaintMock.getUnit());
	assertEquals("Plumbing",complaintMock.getType());
	assertEquals(2, complaintMock.getSeverity());
	assertEquals("Desc of Plumbing",complaintMock.getDescription());
	assertEquals(10000000L,complaintMock.getTime());
	

}


@Test
public void testAddComplaintNegative4() throws Exception {
	
	assertEquals("9543F",complaintMock.getUnit());
	assertEquals("Plumbing",complaintMock.getType());
	assertEquals(3, complaintMock.getSeverity());
	assertEquals("Desc of plumbing",complaintMock.getDescription());
	assertEquals(10000000L,complaintMock.getTime());
	

}

@Test
public void testAddComplaintNegative5() throws Exception {
	
	assertEquals("9543F",complaintMock.getUnit());
	assertEquals("Plumbing",complaintMock.getType());
	assertEquals(2, complaintMock.getSeverity());
	assertEquals("Desc of plumbing",complaintMock.getDescription());
	assertEquals(10000001L,complaintMock.getTime());
	
	
	
}


}

