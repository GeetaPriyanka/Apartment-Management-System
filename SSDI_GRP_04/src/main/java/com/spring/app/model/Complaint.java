package com.spring.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.spring.app.bean.ComplaintBean;

@Entity
@Table(name="complaint")
public class Complaint{
	
	@Id
	@Column(name="complaint_number")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int complaint_number;
	@Column(name="unit")
	private String unit;
	@Column(name="type")
	private String type;
	@Column(name="severity")
	private int severity;
	@Column(name="description")
	private String description;
	@Column(name="time")
	private long time;
	@Column(name="resolved")
	private int resolved;
	
	
	public int getResolved() {
		return resolved;
	}
	public void setResolved(int resolved) {
		this.resolved = resolved;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSeverity() {
		return severity;
	}
	public void setSeverity(int severity) {
		this.severity = severity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public int getComplaint_number() {
		return complaint_number;
	}
	public void setComplaint_number(int complaint_number) {
		this.complaint_number = complaint_number;
	}
	
	
}