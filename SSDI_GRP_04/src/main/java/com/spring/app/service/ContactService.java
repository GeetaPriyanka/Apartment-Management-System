package com.spring.app.service;

import java.util.List;

import com.spring.app.bean.ContactBean;

public interface ContactService {
	public List<ContactBean> listOtp();
	public void addOtp(ContactBean c);
}
