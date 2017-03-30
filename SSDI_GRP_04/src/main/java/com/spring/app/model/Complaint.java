package com.spring.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="complaint")
public class Complaint {
	
	@Id
	@Column(name="complaint_number")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int complaint_number;
	@Column(name="unit")
	private String unit;
	@Column(name="type")
	private int type;
	@Column(name="severity")
	private int severity;
	@Column(name="description")
	private String description;
	@Column(name="time")
	private long time;
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
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