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

import com.spring.app.bean.ContactBean;
import com.spring.app.dao.ContactDAOImpl;
import com.spring.app.model.Complaint;

@WebAppConfiguration
@ContextConfiguration(locations = "classpath:servlet-apt-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@EnableAutoConfiguration
public class ContactDAOTest {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private ContactDAOImpl contactDAO;
	
	@Test
	@Rollback(true)
	public void saveContactDAO() {
	
		ContactBean c = new ContactBean();
		c.setComment("comment");
		c.setEmail("aa");
		c.setName("a");
		contactDAO.addOtp(c);
		
		
		 Session session = sessionFactory.openSession();
		 ContactBean a1 = (ContactBean) session.get(ContactBean.class,"aa");
		 assertEquals("pass","comment",a1.getComment());
	     assertEquals("pass","a",a1.getName());
	     session.close();
         
	}
	
	
	@Test
	@Rollback(true)
	public void listDAO() {
	
		ContactBean c = new ContactBean();
		c.setComment("comment");
		c.setEmail("aaa");
		c.setName("a");
		contactDAO.addOtp(c);
		contactDAO.addOtp(c);
		
		List<ContactBean> comp = contactDAO.listOtp();
		 assertEquals("pass","aaa",comp.get(comp.size()-1).getEmail());
		 assertEquals("pass","comment",comp.get(comp.size()-1).getComment());
 
	}
}
