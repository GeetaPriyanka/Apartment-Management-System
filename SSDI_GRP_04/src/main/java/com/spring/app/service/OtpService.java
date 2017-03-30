package com.spring.app.service;

import java.util.List;

import com.spring.app.model.Otp;

public interface OtpService {
	public List<Otp> listOtp();
	public void addOtp(Otp otp);
	public void deleteOtp(int otp);
}
