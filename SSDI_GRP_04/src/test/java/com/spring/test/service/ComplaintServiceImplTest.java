package com.spring.test.service;


import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.ocpsoft.prettytime.PrettyTime;

import com.spring.app.bean.ComplaintOut;
import com.spring.app.dao.ComplaintDAO;
import com.spring.app.dao.ComplaintDAOImpl;
import com.spring.app.model.Complaint;
import com.spring.app.service.ComplaintService;

public class ComplaintServiceImplTest {

	//private static ComplaintBean complaintMock;
	private static ComplaintOut complaintoutmock;
	private static Complaint complaintMock,complaintMock2;
	private static ComplaintDAO complaintdaoMock;
	
	private static class SystemMock extends Mockito{
		public static long currentTimeMillis(){
			return 10000000L;
		}
	}

	@BeforeClass
	public static void setUp(){
	complaintMock = mock(Complaint.class);
	complaintMock=new Complaint();
	complaintMock.setComplaint_number(1);
	complaintMock.setUnit("9523F");
	complaintMock.setType("Plumbing");
	complaintMock.setSeverity(2);
	complaintMock.setDescription("Desc of plumbing");
	complaintMock.setTime(10000000L);
	
	complaintMock2 = mock(Complaint.class);
	complaintMock2=new Complaint();
	complaintMock2.setComplaint_number(2);
	complaintMock2.setUnit("9527F");
	complaintMock2.setType("Carpentry");
	complaintMock2.setSeverity(2);
	complaintMock2.setResolved(1);
	complaintMock2.setTime(SystemMock.currentTimeMillis());
	complaintMock2.setDescription("Description of carpentry");
	

	complaintdaoMock=mock(ComplaintDAO.class);

	when(complaintdaoMock.listComplaint()).thenReturn(Arrays.asList(complaintMock,complaintMock2));

	
}
@Test
public void addComplaintTest() throws Exception  {
	
	assertEquals("9523F",complaintMock.getUnit());
	assertEquals("Plumbing",complaintMock.getType());
	assertEquals(2,complaintMock.getSeverity());
	assertEquals("Desc of plumbing",complaintMock.getDescription());
	assertEquals(10000000L,complaintMock.getTime());
	
}

@Test
public void getComplaintTest()
{
	int id=1;
	Complaint c = new Complaint();
	List<Complaint> complaintIn = new ArrayList<Complaint>();
	complaintIn = ComplaintServiceImplTest.complaintdaoMock.listComplaint();
	for (Complaint comp : complaintIn) {
		if (comp.getComplaint_number() == id) {
			c=comp;
		}
	}
	assertNotNull(c.getComplaint_number());
}
	


@Test
public void SLAbreachedComplaintsTest()
{
	List<Complaint> complaintIn = new ArrayList<Complaint>();
	List<ComplaintOut> complaintOut = new ArrayList<ComplaintOut>();

	complaintIn = ComplaintServiceImplTest.complaintdaoMock.listComplaint();
	for (Complaint comp : complaintIn) {
		if (comp.getResolved() == 0) {
			if((System.currentTimeMillis()-comp.getTime())>(24*60*60*1000)){
				complaintoutmock=mock( ComplaintOut.class);
				complaintoutmock=new ComplaintOut();
				complaintoutmock.setComplaint_number(comp.getComplaint_number());
				complaintoutmock.setDescription(comp.getDescription());
				complaintoutmock.setResolved("Pending");
				complaintoutmock.setSeverity("High");
				PrettyTime time = new PrettyTime();
				String formattedTime = time.format(new Date(comp.getTime()));
				complaintoutmock.setTime(formattedTime);
				complaintoutmock.setType(comp.getType());
				complaintoutmock.setComparable_time(comp.getTime());
				complaintoutmock.setUnit(comp.getUnit());
				complaintOut.add(complaintoutmock);
			}
			}
		}
	assertEquals(1,complaintOut.size());

	}
}
/*
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

*/


