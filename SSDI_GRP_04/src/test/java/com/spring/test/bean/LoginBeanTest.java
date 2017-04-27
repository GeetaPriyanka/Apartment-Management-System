package com.spring.test.bean;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.spring.app.bean.Loginbean;

public class LoginBeanTest {
	public static Loginbean lb;
	
	@BeforeClass
	public static void setUp(){
		lb=new Loginbean();
		lb.setPassword("123456");
		lb.setUsername("sb");
		
	}

	@Test
	public void getUserNametest() {
		assertEquals("sb",lb.getUsername());
	
	}
	@Test
	public void getPaswordtest() {
		assertEquals("123456",lb.getPassword());
	
	}

}
