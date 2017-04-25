package com.spring.app.dao;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.app.model.Occupied_apartment;
import com.spring.app.service.UserService;

@Repository
public class Occupied_apartmentDAOImpl implements Occupied_apartmentDAO{

	@Autowired
	private UserService userService;
	
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
	@Transactional
	public void addOccupiedApartment(Occupied_apartment occuaptmnt) {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.openSession();
		session.beginTransaction();
		session.save(occuaptmnt);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	@Transactional
	public void deleteOccupiedApartment(String unit) {
		// TODO Auto-generated method stub
		String email=null;
		List<Occupied_apartment> ocp_apt =  occupiedApartmentsList();
		for (Occupied_apartment occupied_apartment : ocp_apt) {
			if(occupied_apartment.getUnit().equals(unit)){
				email = occupied_apartment.getEmail();
			}
		}
		//System.out.println(email);
		userService.deleteUser(email);
		String hql = "delete from Occupied_apartment where unit = :unit";
		  Session session=this.sessionFactory.getCurrentSession();
	        Query query = session.createQuery(hql);
	        query.setParameter("unit", unit);
	        int rowCount = query.executeUpdate();
	        System.out.println("Rows affected: " + rowCount);
	}


@Override
	@Transactional
	public void updateOccupiedLeaseEndDate(String unit, Date lease_end) {
		// TODO Auto-generated method stub
		String hql="update Occupied_apartment  set lease_end=:lease_end where unit= :unit";
		Session session=this.sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("unit", unit);
        query.setParameter("lease_end", lease_end);
        int result=query.executeUpdate();
        System.out.println("Rows affected: " + result);
	}

}
