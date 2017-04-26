package com.spring.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.app.bean.ContactBean;
import com.spring.app.dao.ComplaintDAO;
import com.spring.app.dao.ContactDAO;

public class ContactServiceImpl implements ContactService {

	@Autowired
	ContactDAO contacttDAO;
	
	public void setContacttDAO(ContactDAO contacttDAO) {
		this.contacttDAO = contacttDAO;
	}

	@Override
	public List<ContactBean> listOtp() {
		// TODO Auto-generated method stub
		return contacttDAO.listOtp();
	}

	@Override
	public void addOtp(ContactBean c) {
		contacttDAO.addOtp(c);		
	}

}
