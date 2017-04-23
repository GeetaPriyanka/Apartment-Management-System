package com.spring.app;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.stereotype.Repository;

import com.spring.app.dao.ComplaintDAOImpl;
import com.spring.app.model.Complaint;

@Repository
public class ComplaintDAOImplTest {
	
	private static Complaint complaintMock,complaintMock2;

	
	private static SessionFactory sessionFactory;
	private static Session session1,session2;
	private static ComplaintDAOImpl cdaoMock,cdaoMock2;
	

	public void setSessionFactory(SessionFactory sf){
		ComplaintDAOImplTest.sessionFactory = sf;
	}
	

	@BeforeClass
	public static void setUp()
	{
		complaintMock = mock(Complaint.class);
		complaintMock.setUnit("9527");
		complaintMock.setType("Plumbing");
		complaintMock.setSeverity(2);
		complaintMock.setTime(System.currentTimeMillis());
		complaintMock.setDescription("Desc of plumbing");

	}
	
	public void addComplaint1()
	{
		cdaoMock=mock(ComplaintDAOImpl.class);
		cdaoMock.addComplaint(complaintMock);		

		session1=ComplaintDAOImplTest.sessionFactory.openSession();
		session1.beginTransaction();
		session1.save(cdaoMock);
		session1.getTransaction().commit();
		session1.close();

	}
	
	public void addComplaint2()
	{

		cdaoMock2=mock(ComplaintDAOImpl.class);
		cdaoMock2.addComplaint(complaintMock2);
		session2=ComplaintDAOImplTest.sessionFactory.openSession();
		session2.beginTransaction();
		session2.save(cdaoMock2);
		session2.getTransaction().commit();
		session2.close();

	}

	@Test
	public void testAddComplaintPositive(){
		   
        assertNotNull(complaintMock.getComplaint_number());

        
	}
	@Test
	public void testAddComplaintNegative(){
		

        assertNotNull(complaintMock2.getComplaint_number());

	}
	
}
