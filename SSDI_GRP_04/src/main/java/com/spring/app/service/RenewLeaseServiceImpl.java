package com.spring.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.app.dao.ApartmentDAO;
import com.spring.app.dao.RenewLeaseDAO;
import com.spring.app.model.RenewLeaseModel;
@Service
public class RenewLeaseServiceImpl implements RenewLeaseService {
	
	@Autowired
	 RenewLeaseDAO renewLeaseDAO;
	
	public void setRenewLeaseDAO(RenewLeaseDAO renewLeaseDAO) {
		this.renewLeaseDAO = renewLeaseDAO;
	}

	@Override
	@Transactional
	public List<RenewLeaseModel> listRenewLease() {
		
		return renewLeaseDAO.listRenewLease();
	}

	@Override
	@Transactional
	public void addRenewLease(RenewLeaseModel renew) {
	this.renewLeaseDAO.addRenewLease(renew);	
	}

	@Override
	@Transactional
	public void deleteRenewLease(String email) {
		// TODO Auto-generated method stub
		
	}

}
