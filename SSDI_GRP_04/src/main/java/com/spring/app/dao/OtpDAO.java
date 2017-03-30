package com.spring.app.dao;

import java.util.List;

import com.spring.app.model.Otp;

public interface OtpDAO {
	public List<Otp> listOtp();
	public void addOtp(Otp otp);
	public void deleteOtp(int otp);
}
