package com.spring.test.DAO;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Repository;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.spring.app.dao.ApartmentDAOImpl;
import com.spring.app.dao.ComplaintDAO;
import com.spring.app.dao.ComplaintDAOImpl;
import com.spring.app.model.Available_apartment;
import com.spring.app.model.Complaint;


@WebAppConfiguration
@ContextConfiguration(locations = "classpath:servlet-apt-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@EnableAutoConfiguration
public class ComplaintDAOImplTest {
	
	@Autowired
	private ComplaintDAOImpl complaintDAO;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Test
	@Rollback(true)
	public void saveApartmentDAO() {
	
		Complaint complaint=new Complaint();
		complaint.setType("test");
		complaint.setSeverity(1);
		complaint.setDescription("test");
		complaint.setTime(System.currentTimeMillis());
		complaint.setUnit("111");
		complaint.setResolved(0);
		complaint.setResolved_by(null);
		complaint.setResolved_time(0);
		complaintDAO.addComplaint(complaint);
		
		
		 Session session = sessionFactory.openSession();
		 Complaint a1 = (Complaint) session.get(Complaint.class,10);
		 assertEquals("pass",10,a1.getComplaint_number());
	     assertEquals("pass","test",a1.getDescription());
	     assertEquals("pass","test",a1.getType());
	     session.close();
         
	}

	@Test
	@Rollback(true)
	public void listDAO() {
	
		Complaint complaint=new Complaint();
		complaint.setType("test");
		complaint.setSeverity(1);
		complaint.setDescription("test");
		complaint.setTime(System.currentTimeMillis());
		complaint.setUnit("111");
		complaint.setResolved(0);
		complaint.setResolved_by(null);
		complaint.setResolved_time(0);
		complaintDAO.addComplaint(complaint);
		
		List<Complaint> comp = complaintDAO.listComplaint();
		 assertEquals("pass",111,comp.get(comp.size()-1).getUnit());
	     assertEquals("pass","test",comp.get(comp.size()-1).getDescription());
 
	}

}
