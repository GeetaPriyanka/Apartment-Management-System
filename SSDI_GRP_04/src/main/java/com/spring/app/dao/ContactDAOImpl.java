package com.spring.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.spring.app.bean.ContactBean;


public class ContactDAOImpl implements ContactDAO{

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	Session session;
	
	@Override
	@Transactional
	public List<ContactBean> listOtp() {
		// TODO Auto-generated method stub
		session = this.sessionFactory.getCurrentSession();
		List<ContactBean> contactList = session.createQuery("from ContactBean").list();
	
		return contactList;
	}

	@Override
	@Transactional
	public void addOtp(ContactBean c) {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.openSession();
		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();
		session.close();		
	}

}
