package com.spring.app.dao;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.spring.app.model.Complaint;
import com.spring.app.model.User;

@Repository
public class ComplaintDAOImpl implements ComplaintDAO {

	private static final Logger logger = LoggerFactory.getLogger(ComplaintDAO.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Complaint> listComplaint() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Complaint> complainList = session.createQuery("from Complaint").list();
		return complainList;
	}

	@Override
	public void addComplaint(Complaint c) {
		System.out.println("you are in add complain");
		Session session=this.sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(c);
		session.getTransaction().commit();
		session.close();
	}

}
