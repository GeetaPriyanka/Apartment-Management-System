package com.spring.test.DAO;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.dialect.function.AvgWithArgumentCastFunction;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.spring.app.dao.ApartmentDAOImpl;
import com.spring.app.model.Available_apartment;

@ContextConfiguration(locations = "classpath:servlet-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class ApartmentDAOTest {
	
	@Autowired
	private ApartmentDAOImpl apartmentDAO;
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Test
	@Rollback(true)
	public void saveApartmentDAO() {
		Available_apartment a = new Available_apartment("9306", 111, 1, 1234);
		
		apartmentDAO.addAvailableApartment(a);
		
		 Session session = sessionFactory.openSession();
		 Available_apartment a1 = (Available_apartment) session.get(Available_apartment.class,"9306");
         assertEquals("pass",9306,a1.getUnit());
	}

}
