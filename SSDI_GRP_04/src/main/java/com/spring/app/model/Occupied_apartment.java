package com.spring.app.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="occupied_apartment")
public class Occupied_apartment {
	@Id
	@Column(name="unit")
	private String unit;
	@Column(name="email")
	private String email;
	@Column(name="lease_start")
	private Date leaseStart;
	@Column(name="lease_end")
	private Date leaseEnd;
	@Column(name="bill")
	private float bill;
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
	public Date getLeaseStart() {
		return leaseStart;
	}
	public void setLeaseStart(Date leaseStart) {
		this.leaseStart = leaseStart;
	}
	public Date getLeaseEnd() {
		return leaseEnd;
	}
	public void setLeaseEnd(Date leaseEnd) {
		this.leaseEnd = leaseEnd;
	}
	public float getBill() {
		return bill;
	}
	public void setBill(float bill) {
		this.bill = bill;
	}
	
}
