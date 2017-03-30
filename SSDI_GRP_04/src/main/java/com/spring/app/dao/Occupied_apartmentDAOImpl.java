package com.spring.app.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.spring.app.model.Occupied_apartment;

@Repository
public class Occupied_apartmentDAOImpl implements Occupied_apartmentDAO{


	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Occupied_apartment> occupiedApartmentsList() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<Occupied_apartment> occuaptList = session.createQuery("from Occupied_apartment").list();
		for(Occupied_apartment p : occuaptList){
			logger.info("OccuApt List: "+p);
		}
		return occuaptList;
	}

	@Override
	public void addOccupiedApartment(Occupied_apartment occuaptmnt) {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.openSession();
		session.beginTransaction();
		session.save(occuaptmnt);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deleteOccupiedApartment(String unit) {
		// TODO Auto-generated method stub
		String hql = "delete from Occupied_apartment where unit = :unit";
		  Session session=this.sessionFactory.getCurrentSession();
	        Query query = session.createQuery(hql);
	        query.setParameter("unit", unit);
	        int rowCount = query.executeUpdate();
	        System.out.println("Rows affected: " + rowCount);
	}

}
