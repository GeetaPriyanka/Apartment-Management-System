package com.spring.app.bean;

public class RenewLeaseBean {
public String email;
public String unit;
public int extension_period;
public boolean approval_status;
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
public void setExtension_period(int extension_period) {
	this.extension_period = extension_period;
}
public boolean isApproval_status() {
	return approval_status;
}
public void setApproval_status(boolean approval_status) {
	this.approval_status = approval_status;
}

}
