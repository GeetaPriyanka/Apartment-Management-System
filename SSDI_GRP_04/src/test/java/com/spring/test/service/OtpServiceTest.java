package com.spring.test.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.spring.app.dao.OtpDAO;
import com.spring.app.model.Occupied_apartment;
import com.spring.app.model.Otp;
import com.spring.app.service.OtpServiceImpl;

public class OtpServiceTest {

	private static OtpServiceImpl otpServiceMock;
	private static Otp otp1;
	private static OtpDAO otp;

	@BeforeClass
	public static void setUp(){
		otpServiceMock=new OtpServiceImpl();
		otp=mock(OtpDAO.class);
		otp1=mock(Otp.class);
		Date o=new Date(0);
		otpServiceMock.setOtpDAO(otp);
		otp1=new Otp();
		otp1.setOtp(12);
		otp1.setEndDate(o);
		otp1.setStartDate(o);
		otp1.setUnit("9505");

	}
	@Test
	public void testGetAllOtp() {
		List<Otp> allOtp =new ArrayList<Otp>();
		allOtp.add(otp1);
		when(otp.listOtp()).thenReturn(allOtp);
		otpServiceMock.listOtp();
		assertNotNull( otpServiceMock.listOtp());
		assertEquals(1, ( otpServiceMock.listOtp().size()));
	}

	@Test
	public void testAddOtp() {
		Otp otps = new Otp();
		Date nd=new Date(0);
		otps.setEndDate(nd);
		otps.setOtp(1245);
		otps.setStartDate(nd);
		otps.setUnit("9645");
		otpServiceMock.addOtp(otps);
		verify(otp).addOtp(otps);
		assertEquals(12,otp1.getOtp());

	}

	@Test
	public void testDeleteOtp(){
		Otp otps = new Otp();
		Date nd=new Date(0);
		otps.setEndDate(nd);
		otps.setOtp(1245);
		otps.setStartDate(nd);
		otps.setUnit("9645");
		otpServiceMock.deleteOtp(1245);
		verify(otp).deleteOtp(1245);

	}

}
