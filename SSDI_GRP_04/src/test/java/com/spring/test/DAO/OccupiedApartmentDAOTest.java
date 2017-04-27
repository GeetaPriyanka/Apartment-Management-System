package com.spring.test.DAO;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.Calendar;
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

import com.spring.app.dao.Occupied_apartmentDAOImpl;
import com.spring.app.model.Available_apartment;
import com.spring.app.model.Occupied_apartment;

@WebAppConfiguration
@ContextConfiguration(locations = "classpath:servlet-apt-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@EnableAutoConfiguration
public class OccupiedApartmentDAOTest {
	
	@Autowired
	private SessionFactory sessionFactory1;
	
	@Autowired 
	private Occupied_apartmentDAOImpl occuAptDAO;
	@Test
	@Rollback(true)
	public void saveApartmentDAO() {
		Occupied_apartment occuaptmnt= new Occupied_apartment();
		Calendar currenttime = Calendar.getInstance();
		Date sqlCurrentdate = new Date((currenttime.getTime()).getTime());
		currenttime.add(Calendar.YEAR, 1);
		Date sqlYeardate = new Date((currenttime.getTime()).getTime());
		occuaptmnt.setUnit("999");
		occuaptmnt.setEmail("aaa");
		occuaptmnt.setLeaseStart(sqlCurrentdate);
		occuaptmnt.setLeaseEnd(sqlYeardate);
		occuaptmnt.setBill(0);
		
		occuAptDAO.addOccupiedApartment(occuaptmnt);
		
		 Session session = sessionFactory1.openSession();
		 Occupied_apartment a1 = (Occupied_apartment) session.get(Occupied_apartment.class,"999");
         assertEquals("pass","999",a1.getUnit());
         assertEquals("pass","aaa",a1.getEmail());
         session.close();
	}

	@Test
	@Rollback(true)
	public void ListApartmentDAO() {
		Occupied_apartment occuaptmnt= new Occupied_apartment();
		Calendar currenttime = Calendar.getInstance();
		Date sqlCurrentdate = new Date((currenttime.getTime()).getTime());
		currenttime.add(Calendar.YEAR, 1);
		Date sqlYeardate = new Date((currenttime.getTime()).getTime());
		occuaptmnt.setUnit("999");
		occuaptmnt.setEmail("a11");
		occuaptmnt.setLeaseStart(sqlCurrentdate);
		occuaptmnt.setLeaseEnd(sqlYeardate);
		occuaptmnt.setBill(0);
		
		occuAptDAO.addOccupiedApartment(occuaptmnt);
		
		List<Occupied_apartment> list = occuAptDAO.occupiedApartmentsList();
		 assertEquals("pass","999",list.get(list.size()-1).getUnit());
		 assertEquals("pass","a11",list.get(list.size()-1).getEmail());
	}
}
