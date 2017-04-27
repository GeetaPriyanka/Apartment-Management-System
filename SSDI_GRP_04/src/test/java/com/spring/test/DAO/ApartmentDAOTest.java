package com.spring.test.DAO;

import static org.junit.Assert.assertEquals;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.spring.app.dao.ApartmentDAOImpl;
import com.spring.app.model.Available_apartment;

@WebAppConfiguration
@ContextConfiguration(locations = "classpath:servlet-apt-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@EnableAutoConfiguration
public class ApartmentDAOTest {
	
	@Autowired
	private ApartmentDAOImpl apartmentDAO;
	
	@Autowired
	private SessionFactory sessionFactory1;
	
	@Test
	@Rollback(true)
	public void saveApartmentDAO() {
		Available_apartment a = new Available_apartment("990", 1500, 3, 1400);
		
		apartmentDAO.addAvailableApartment(a);
		
		 Session session = sessionFactory1.openSession();
		 Available_apartment a1 = (Available_apartment) session.get(Available_apartment.class,"990");
         assertEquals("pass","990",a1.getUnit());
        assertEquals("pass",1500,a1.getRent());
         assertEquals("pass",3,a1.getBhk());
         assertEquals("pass",1400,a1.getArea());
         session.close();
	}

	@Test
	@Rollback(true)
	public void ListApartmentDAO() {
		Available_apartment a = new Available_apartment("150", 1500, 3, 1400);

		Session session=this.sessionFactory1.openSession();
		session.beginTransaction();
		session.save(a);
		session.getTransaction().commit();
		session.close();
		
		List<Available_apartment> list = apartmentDAO.listApartments();
		 assertEquals("pass","150",list.get(list.size()-1).getUnit());
		 assertEquals("pass",1500,list.get(list.size()-1).getRent());
		 assertEquals("pass",3,list.get(list.size()-1).getBhk());
		 assertEquals("pass",1400,list.get(list.size()-1).getArea());
	}
	
	@Test
	@Rollback(true)
	public void DeleteApartmentDAO() {
		Available_apartment a = new Available_apartment("1110", 1500, 3, 1400);

		Session session=this.sessionFactory1.openSession();
		session.beginTransaction();
		session.save(a);
		session.getTransaction().commit();
		session.close();
//		
		List<Available_apartment> list = apartmentDAO.listApartments();
		 assertEquals("pass","1110",list.get(list.size()-1).getUnit());
		 assertEquals("pass",1500,list.get(list.size()-1).getRent());
		 assertEquals("pass",3,list.get(list.size()-1).getBhk());
		 assertEquals("pass",1400,list.get(list.size()-1).getArea());
	}

}
