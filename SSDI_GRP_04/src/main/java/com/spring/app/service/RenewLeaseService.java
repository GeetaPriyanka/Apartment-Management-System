package com.spring.app.service;

import java.util.List;

import com.spring.app.model.Renew_lease;

public interface RenewLeaseService {
	public List<Renew_lease> listRenewLease();
	public void addRenewLease(Renew_lease renew);
	public void deleteRenewLease(String email);
	public void updateRenewLease(String email);
}
