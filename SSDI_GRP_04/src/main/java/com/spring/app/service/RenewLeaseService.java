package com.spring.app.service;

import java.util.List;

import com.spring.app.model.RenewLeaseModel;

public interface RenewLeaseService {
	public List<RenewLeaseModel> listRenewLease();
	public void addRenewLease(RenewLeaseModel renew);
	public void deleteRenewLease(String email);
}
