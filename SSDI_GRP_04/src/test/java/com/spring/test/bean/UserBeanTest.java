package com.spring.test.bean;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.spring.app.bean.UserBean;

public class UserBeanTest {
	public static UserBean ub;

	@BeforeClass
	public static void setUp(){
		ub=new UserBean();
		ub.setEmail("a@abc.co");
		ub.setFirstname("first");
		ub.setLastname("last");
		ub.setOtp(123);
		ub.setPassword("123");
	}

	@Test
	public void getEmailtest() {
		assertEquals("a@abc.co",ub.getEmail());
	}
	@Test
	public void getFirsttest() {
		assertEquals("first",ub.getFirstname());
	}

	@Test
	public void getLasttest() {
		assertEquals("last",ub.getLastname());
	}

	@Test
	public void getOtptest() {
		assertEquals(123,ub.getOtp());
	}
	@Test
	public void getPasswordtest() {
		assertEquals("123",ub.getPassword());
	}



}
