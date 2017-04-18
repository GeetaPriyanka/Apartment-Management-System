package com.spring.app.dao;
import com.spring.app.model.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.app.model.Complaint;
import com.spring.app.model.RenewLeaseModel;

import java.util.*;

@Repository
public class RenewLeaseDAOimpl implements RenewLeaseDAO {
	private static final Logger logger = LoggerFactory.getLogger(RenewLeaseDAOimpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public List<RenewLeaseModel> listRenewLease() {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<RenewLeaseModel> RenewLease = session.createQuery("from renew_lease").list();
		
		return RenewLease;
	}

	@Override
	
	public void addRenewLease(RenewLeaseModel renew) {
		Session session=this.sessionFactory.openSession();
		session.beginTransaction();
		session.save(renew);
		session.getTransaction().commit();
		
	}
	@Override
	
	public void deleteRenewLease(String email) {
		// TODO Auto-generated method stub
		String hql = "delete from renew_lease where email = :email";
		  Session session=this.sessionFactory.getCurrentSession();
	        Query query = session.createQuery(hql);
	        query.setParameter("email", email);
	        int rowCount = query.executeUpdate();
	        System.out.println("Rows affected: " + rowCount);
	}
	}

