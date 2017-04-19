package com.spring.app.model;

import javax.persistence.*;

@Entity
@Table(name="renew_lease")

public class Renew_lease {

	
	@Id
	@Column(name="email")
	String email;
	@Column(name="unit")
	String unit;
	@Column(name="extension_period")
	int extension_period;
	@Column(name="approval_status")
	boolean approval_status;
	
	public Renew_lease(){
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getExtension_period() {
		return extension_period;
	}

	public void setExtenion_period(int extension_period) {
		this.extension_period = extension_period;
	}

	public boolean isApproval_status() {
		return approval_status;
	}

	public void setApproval_status(boolean approval_status) {
		this.approval_status = approval_status;
	}
}
