package com.spring.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.app.dao.ApartmentDAO;
import com.spring.app.dao.RenewLeaseDAO;
import com.spring.app.model.Renew_lease;
@Service
public class RenewLeaseServiceImpl implements RenewLeaseService {
	
	@Autowired
	 RenewLeaseDAO renewLeaseDAO;
	
	public void setRenewLeaseDAO(RenewLeaseDAO renewLeaseDAO) {
		this.renewLeaseDAO = renewLeaseDAO;
	}

	@Override
	@Transactional
	public List<Renew_lease> listRenewLease() {
		List<Renew_lease> outlist = new ArrayList<Renew_lease>();
		List<Renew_lease> list =  renewLeaseDAO.listRenewLease();
		for (Renew_lease renew_lease : list) {
			if(!renew_lease.isApproval_status()){
				outlist.add(renew_lease);
			}
		}
		return outlist;
	}

	@Override
	@Transactional
	public void addRenewLease(Renew_lease renew) {
	this.renewLeaseDAO.addRenewLease(renew);	
	}

	@Override
	@Transactional
	public void deleteRenewLease(String email) {
		// TODO Auto-generated method stub
		this.renewLeaseDAO.deleteRenewLease(email);
	}

	@Override
	public void updateRenewLease(String email) {
		// TODO Auto-generated method stub
		this.renewLeaseDAO.updateRenewLease(email);
	}

}
