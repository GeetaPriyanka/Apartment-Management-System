package com.spring.app.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.app.model.Otp;

@Repository
public class OtpDAOImpl implements OtpDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	Session session;
	@SuppressWarnings("unchecked")
	@Override
	public List<Otp> listOtp() {
		// TODO Auto-generated method stub
		session = this.sessionFactory.getCurrentSession();
		System.out.println("in OTP DAO listing");
		List<Otp> OtpList = session.createQuery("from Otp").list();
		for(Otp p : OtpList){
			logger.info("Otp List: "+p);
		}
		return OtpList;
	}

	@Override
	@Transactional
	public void addOtp(Otp otp) {
		// TODO Auto-generated method stub
		System.out.println("in OTP DAO addition");
		Session session=this.sessionFactory.openSession();
		session.beginTransaction();
		session.save(otp);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deleteOtp(int otp_no) {
		// TODO Auto-generated method stub
		String hql = "delete from Otp where otp = :otp_no";
		 session=this.sessionFactory.getCurrentSession();
	        Query query = session.createQuery(hql);
	        query.setParameter("otp_no", otp_no);
	        int rowCount = query.executeUpdate();
	        System.out.println("Rows affected: " + rowCount);
	}
}
