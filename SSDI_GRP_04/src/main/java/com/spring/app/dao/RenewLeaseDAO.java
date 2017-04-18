package com.spring.app.dao;

import java.util.List;

import com.spring.app.model.RenewLeaseModel;



public interface RenewLeaseDAO {
	public List<RenewLeaseModel> listRenewLease();
	public void addRenewLease(RenewLeaseModel renew);
	public void deleteRenewLease(String email);
}
