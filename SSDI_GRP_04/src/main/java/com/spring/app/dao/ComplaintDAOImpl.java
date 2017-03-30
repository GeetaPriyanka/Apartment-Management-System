package com.spring.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.spring.app.model.Complaint;

@Repository
public class ComplaintDAOImpl implements ComplaintDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public List<Complaint> listComplaint() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addComplaint(Complaint c) {
		System.out.println("you are in add complain");
		Session session=this.sessionFactory.openSession();
		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();
		session.close();
	}

}
