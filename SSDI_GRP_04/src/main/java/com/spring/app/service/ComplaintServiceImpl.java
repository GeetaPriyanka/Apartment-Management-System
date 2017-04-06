package com.spring.app.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.ocpsoft.prettytime.PrettyTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.spring.app.bean.ComplaintBean;
import com.spring.app.bean.ComplaintOut;
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
	public List<ComplaintOut> listComplaints() {
		
		List<ComplaintOut> complaintOut = new ArrayList<ComplaintOut>();
		List<Complaint> complaintIn = new ArrayList<Complaint>();
		complaintIn = this.complaintDAO.listComplaint();
		for (Complaint comp : complaintIn) {
			if (comp.getResolved() == 0) {
				ComplaintOut c = new ComplaintOut();
				c.setComplaint_number(comp.getComplaint_number());
				c.setDescription(comp.getDescription());
				c.setResolved("Pending");
				switch (comp.getSeverity()) {
				case 0:
					c.setSeverity("Low");
					break;
				case 1:
					c.setSeverity("Medium");
					break;
				case 2:
					c.setSeverity("High");
					break;
				}
				PrettyTime time = new PrettyTime();
				String formattedTime = time.format(new Date(comp.getTime()));
				c.setTime(formattedTime);
				c.setType(comp.getType());
				c.setComparable_time(comp.getTime());
				c.setUnit(comp.getUnit());
				complaintOut.add(c);
			}
		}
		Collections.sort(complaintOut);
		return complaintOut;
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
