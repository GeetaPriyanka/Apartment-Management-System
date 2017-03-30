package com.spring.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.spring.app.dao.ComplaintDAO;
import com.spring.app.model.Complaint;

public class ComplaintServiceImpl implements ComplaintService {

	@Autowired
	ComplaintDAO complaintDAO;
	
	
	public void setComplaintDAO(ComplaintDAO complaintDAO) {
		this.complaintDAO = complaintDAO;
	}

	@Override
	@Transactional
	public List<Complaint> listComplaints() {
		return this.complaintDAO.listComplaint();
	}

	@Override
	@Transactional
	public void addUser(Complaint c) {
		this.complaintDAO.addComplaint(c);
	}

}
