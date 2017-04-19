package com.spring.app.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.app.model.*;

@Repository
public class UserDAOImpl implements UserDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> personsList = session.createQuery("from User").list();
		for(User p : personsList){
			logger.info("Person List: "+p);
		}
		return personsList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void addUser(User user) {
		// TODO Auto-generated method stub
		System.out.println("you are in add user");
		Session session=this.sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void deleteUser(String email) {
		// TODO Auto-generated method stub
		 String hql = "delete from User where email = :email";
		 Session session=this.sessionFactory.getCurrentSession();
	        Query query = session.createQuery(hql);
	        query.setParameter("email", email);
	        int rowCount = query.executeUpdate();
	        System.out.println("Rows affected: " + rowCount);
	}
}
