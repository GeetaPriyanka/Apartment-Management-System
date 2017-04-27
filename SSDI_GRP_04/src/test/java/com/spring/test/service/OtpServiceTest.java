package com.spring.test.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.spring.app.model.Occupied_apartment;
import com.spring.app.model.Otp;
import com.spring.app.service.OtpServiceImpl;

public class OtpServiceTest {

	private static OtpServiceImpl otpServiceMock;
	private static Otp otp1;
	private static Otp otp2;
	@BeforeClass
	public static void setUp(){
		otpServiceMock=mock(OtpServiceImpl.class);
		Date o=new Date(0);
		otp2=new Otp();
		otp1=new Otp();
		otp1.setOtp(12);
		otp1.setEndDate(o);
		otp1.setStartDate(o);
		otp1.setUnit("9505");
		
		otp2.setEndDate(o);
		otp2.setOtp(1245);
		otp2.setStartDate(o);
		otp2.setUnit("9632");
		
		when(otpServiceMock.listOtp()).thenReturn(Arrays.asList(otp1,otp2));
		
	}
	@Test
	public void testGetAllOtp() {
		List<Otp> allOtp = otpServiceMock.listOtp();
		assertEquals(2, allOtp.size());
		Otp otp  = allOtp.get(0);
		assertEquals(12, otp.getOtp());
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
		List<Otp> otplist = otpServiceMock.listOtp();
		for(Otp o : otplist){
			if("9645".equals(o.getUnit())){
				assertEquals("9645", o.getUnit());
				assertEquals(1245, o.getOtp());
				
			}
		}
	}
}
