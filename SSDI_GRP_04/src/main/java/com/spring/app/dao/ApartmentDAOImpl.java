package com.spring.app.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.app.model.Available_apartment;

@Repository
public class ApartmentDAOImpl implements ApartmentDAO {
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	@Transactional
	public void addAvailableApartment(Available_apartment availableApartment){
		Session session=this.sessionFactory.openSession();
		availableApartment.setRent(1500);
		availableApartment.setArea(1400);
		availableApartment.setBhk(3);
		session.beginTransaction();
		session.save(availableApartment);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Available_apartment> listApartments() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Available_apartment> apartmentList = session.createQuery("from Available_apartment").list();
		for(Available_apartment a : apartmentList){
			logger.info("Apartment List: "+a.getUnit());
		}
		return apartmentList;
	}
	
	@Override
	@Transactional
	public void deleteAvailableApartment(String unit) {
		// TODO Auto-generated method stub
		 String hql = "delete from Available_apartment where unit = :unit";
		 Session session=this.sessionFactory.getCurrentSession();
	        Query query = session.createQuery(hql);
	        query.setParameter("unit", unit);
	        int rowCount = query.executeUpdate();
	        System.out.println("Rows affected: " + rowCount);
	        System.out.println("deleted unit from available apt : "+unit);
	        }

}
