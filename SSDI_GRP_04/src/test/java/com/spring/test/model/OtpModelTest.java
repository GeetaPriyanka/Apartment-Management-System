package com.spring.test.model;

import static org.junit.Assert.*;
import java.sql.Date;
import org.junit.BeforeClass;
import org.junit.Test;
import com.spring.app.model.Otp;


public class OtpModelTest {

	private static Otp otp;
	
	private static	Date o=new Date(0);
	@BeforeClass
	public static void setUp(){		
		otp=new Otp();
		otp.setOtp(12);
		otp.setEndDate(o);
		otp.setStartDate(o);
		otp.setUnit("9505");
	
	}
	
	@Test
	public void getOtptest() {
assertEquals(12,otp.getOtp());
	}
	@Test
	public void getEndDatetest() {
assertEquals(o,otp.getEndDate());
	}

	@Test
	public void getStartDatetest() {
assertEquals(o,otp.getStartDate());
	}

	@Test
	public void geEndDatetest() {
assertEquals("9505",otp.getUnit());
	}


}
