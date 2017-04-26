package com.spring.app.bean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ComplaintOut implements Comparable{
	private int complaint_number;
	private String unit;
	private String type;
	private String severity;
	private String description;
	private String time;
	private long comparable_time;
	private String resolved;
	
	
	
	public ComplaintOut() {
		super();
	}
	
	public ComplaintOut(int complaint_number, String unit, String type, String severity, String description,
			String time, long comparable_time, String resolved) {
		super();
		this.complaint_number = complaint_number;
		this.unit = unit;
		this.type = type;
		this.severity = severity;
		this.description = description;
		this.time = time;
		this.comparable_time = comparable_time;
		this.resolved = resolved;
	}

	public long getComparable_time() {
		return comparable_time;
	}

	public void setComparable_time(long comparable_time) {
		this.comparable_time = comparable_time;
	}

	public int getComplaint_number() {
		return complaint_number;
	}
	public void setComplaint_number(int complaint_number) {
		this.complaint_number = complaint_number;
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
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getResolved() {
		return resolved;
	}
	public void setResolved(String resolved) {
		this.resolved = resolved;
	}
	@Override
	public int compareTo(Object o) {
		long comparetime= ((ComplaintOut)o).getComparable_time();
        /* For Ascending order*/
        return (int) (comparetime-this.getComparable_time());
		
	}

	@Override
	public String toString() {
		return "ComplaintOut [complaint_number=" + complaint_number + ", unit=" + unit + ", type=" + type
				+ ", severity=" + severity + ", description=" + description + ", time=" + time + ", comparable_time="
				+ comparable_time + ", resolved=" + resolved + "]";
	}

	
}
