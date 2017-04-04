package com.spring.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.spring.app.bean.ComplaintBean;
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
	public void addComplaint(ComplaintBean c) {
		
		Complaint complaint=new Complaint();
		complaint.setType(c.getType());
		complaint.setSeverity(c.getSeverity());
		complaint.setDescription(c.getDescription());
		complaint.setTime(System.currentTimeMillis());
		complaint.setUnit(c.getUnit());
		complaint.setResolved(0);
		
		this.complaintDAO.addComplaint(complaint);;
	}

}
