package com.spring.app;


import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.spring.app.bean.ComplaintBean;
import com.spring.app.model.Complaint;

public class ComplaintServiceImplTest {

	private static Complaint c;
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
	c=new Complaint();
	c.setUnit("9523F");
	c.setType("Plumbing");
	c.setSeverity(2);
	c.setTime(SystemMock.currentTimeMillis());
	c.setDescription("Desc of plumbing");

}
@Test
public void testAddComplaintPositive() throws Exception  {
	assertEquals("9523F",c.getUnit());
	assertEquals("Plumbing",c.getType());
	assertEquals(2,c.getSeverity());
	assertEquals("Desc of plumbing",c.getDescription());
	assertEquals(10000000L,c.getTime());
}


@Test
public void testAddComplaintNegative1() throws Exception {
	assertEquals("9543F",c.getUnit());
	assertEquals("Plumbing",c.getType());
	assertEquals(2, c.getSeverity());
	assertEquals("Desc of plumbing",c.getDescription());
	assertEquals(10000000L,c.getTime());

}


@Test
public void testAddComplaintNegative2() throws Exception {
	assertEquals("9543F",c.getUnit());
	assertEquals("carpentry",c.getType());
	assertEquals(2, c.getSeverity());
	assertEquals("Desc of plumbing",c.getDescription());
	assertEquals(10000000L,c.getTime());


}

@Test
public void testAddComplaintNegative3() throws Exception {
	assertEquals("9543F",c.getUnit());
	assertEquals("Plumbing",c.getType());
	assertEquals(2, c.getSeverity());
	assertEquals("Desc of Plumbing",c.getDescription());
	assertEquals(10000000L,c.getTime());

}


@Test
public void testAddComplaintNegative4() throws Exception {
	assertEquals("9543F",c.getUnit());
	assertEquals("Plumbing",c.getType());
	assertEquals(3, c.getSeverity());
	assertEquals("Desc of plumbing",c.getDescription());
	assertEquals(10000000L,c.getTime());

}

@Test
public void testAddComplaintNegative5() throws Exception {
	assertEquals("9543F",c.getUnit());
	assertEquals("Plumbing",c.getType());
	assertEquals(2, c.getSeverity());
	assertEquals("Desc of plumbing",c.getDescription());
	assertEquals(10000001L,c.getTime());


}


}
