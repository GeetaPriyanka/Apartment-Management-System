package com.spring.app.dao;

import java.util.List;

import com.spring.app.model.Complaint;

public interface ComplaintDAO {
	public List<Complaint> listComplaint();
	public void addComplaint(Complaint c);
}
