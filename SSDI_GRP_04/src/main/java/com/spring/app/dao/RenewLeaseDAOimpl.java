package com.spring.app.dao;
import com.spring.app.model.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Repository
public class RenewLeaseDAOimpl implements RenewLeaseDAO {
	private static final Logger logger = LoggerFactory.getLogger(RenewLeaseDAOimpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	@Transactional
	public List<Renew_lease> listRenewLease() {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Renew_lease> RenewLease = session.createQuery("from Renew_lease").list();
		for (Renew_lease renewLeaseModel : RenewLease) {
			logger.info("Renew List: "+renewLeaseModel);
		}
		return RenewLease;
	}

	@Override
	@Transactional
	public void addRenewLease(Renew_lease renew) {
		Session session=this.sessionFactory.openSession();
		session.beginTransaction();
		session.save(renew);
		session.getTransaction().commit();
		
	}
	@Override
	@Transactional
	public void deleteRenewLease(String email) {
		// TODO Auto-generated method stub
		String hql = "delete from Renew_lease where email = :email";
		  Session session=this.sessionFactory.getCurrentSession();
	        Query query = session.createQuery(hql);
	        query.setParameter("email", email);
	        int rowCount = query.executeUpdate();
	        System.out.println("Rows affected: " + rowCount);
	}

	@Override
	@Transactional
	public void updateRenewLease(String email) {
		// TODO Auto-generated method stub
		String hql="update Renew_lease  set approval_status = true where email= :email";
		Session session=this.sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("email", email);
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        
		
	}
	}

