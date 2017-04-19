package com.spring.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.app.dao.OtpDAO;
import com.spring.app.model.Otp;

@Service
public class OtpServiceImpl implements OtpService {

	private OtpDAO otpDAO;
	public void setOtpDAO(OtpDAO otpDAO) {
		this.otpDAO = otpDAO;
	}

	
	@Override
	@Transactional
	public List<Otp> listOtp() {
		// TODO Auto-generated method stub
		return this.otpDAO.listOtp();
	}


	@Override
	@Transactional
	public void addOtp(Otp otp) {
		// TODO Auto-generated method stub
		otpDAO.addOtp(otp);
	}


	@Override
	@Transactional
	public void deleteOtp(int otp) {
		// TODO Auto-generated method stub
		otpDAO.deleteOtp(otp);
	}
	

}
