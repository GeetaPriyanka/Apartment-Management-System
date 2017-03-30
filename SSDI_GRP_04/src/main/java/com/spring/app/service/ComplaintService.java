package com.spring.app.service;

import java.util.List;

import com.spring.app.model.Complaint;

public interface ComplaintService {
	public List<Complaint> listComplaints();
	public void addUser(Complaint c);
}
