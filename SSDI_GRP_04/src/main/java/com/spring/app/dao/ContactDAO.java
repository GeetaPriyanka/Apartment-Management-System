package com.spring.app.dao;

import java.util.List;

import com.spring.app.bean.ContactBean;

public interface ContactDAO {
	public List<ContactBean> listOtp();
	public void addOtp(ContactBean c);
}
