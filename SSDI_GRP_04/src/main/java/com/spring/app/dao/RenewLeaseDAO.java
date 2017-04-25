package com.spring.app.dao;

import java.util.List;

import com.spring.app.model.Renew_lease;



public interface RenewLeaseDAO {
	public List<Renew_lease> listRenewLease();
	public void addRenewLease(Renew_lease renew);
	public void deleteRenewLease(String email);
	public void updateRenewLease(String email);
}
