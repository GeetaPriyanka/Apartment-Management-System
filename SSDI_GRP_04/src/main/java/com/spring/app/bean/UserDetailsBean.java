package com.spring.app.bean;

import java.sql.Date;

public class UserDetailsBean {
	private String name;
	private String unit;
	private String email;
	private Date lease_start;
	private Date lease_end;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getLease_start() {
		return lease_start;
	}
	public void setLease_start(Date lease_start) {
		this.lease_start = lease_start;
	}
	public Date getLease_end() {
		return lease_end;
	}
	public void setLease_end(Date lease_end) {
		this.lease_end = lease_end;
	}
	
	
}
