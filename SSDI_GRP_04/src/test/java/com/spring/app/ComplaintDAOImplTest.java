package com.spring.app;

import static org.junit.Assert.*;

import java.io.Serializable;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.stereotype.Repository;

import com.spring.app.dao.ComplaintDAOImpl;
import com.spring.app.model.Complaint;

@Repository
public class ComplaintDAOImplTest {
	
	static Complaint c1=new Complaint();
	static Complaint c2;


	private static SessionFactory sessionFactory;
	private static Session session1,session2;
	private static ComplaintDAOImpl cdao;
	//private static org.hibernate.Transaction tx;

	//Serializable save,save2;


	public void setSessionFactory(SessionFactory sf){
		ComplaintDAOImplTest.sessionFactory = sf;
	}
	

	@BeforeClass
	public static void setUp()
	{
		c1.setUnit("9523F");
		c1.setType("Plumbing");
		c1.setSeverity(2);
		c1.setTime(System.currentTimeMillis());
		c1.setDescription("Desc of plumbing");

	}
	public void addComplaint1()
	{
		cdao.addComplaint(c1);		
		//cdao.addComplaint(c1);
		session1=ComplaintDAOImplTest.sessionFactory.openSession();
		session1.beginTransaction();
		session1.save(c1);
		session1.getTransaction().commit();
		session1.close();

	}
	public void addComplaint2()
	{
		cdao.addComplaint(c2);		
		//cdao.addComplaint(c1);
		session2=ComplaintDAOImplTest.sessionFactory.openSession();
		session2.beginTransaction();
		session2.save(c2);
		session2.getTransaction().commit();
		session2.close();

	}
	/*@Test	
	public void testAddComplaint() {
					assertNotNull(tx!=null);
					assertNotNull(save!=null);
					assertNotNull(session1!=null);
					
		}*/
	@Test
	public void testAddComplaintPositive(){
		
        assertNotNull(c1.getComplaint_number());

	}
	@Test
	public void testAddComplaintNegative(){
        assertNotNull(c2.getComplaint_number());

	}
	
}
