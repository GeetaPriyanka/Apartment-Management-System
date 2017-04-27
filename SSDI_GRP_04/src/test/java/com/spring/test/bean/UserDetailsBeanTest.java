package com.spring.test.bean;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.spring.app.bean.UserDetailsBean;

public class UserDetailsBeanTest {
	public static UserDetailsBean udb;
	public static Date d;
	@BeforeClass
	public static void setUp(){
		udb=new UserDetailsBean();
		d=new Date(0);
		udb.setEmail("a@abc.co");
		udb.setLease_end(d);
		udb.setLease_start(d);
		udb.setName("name");
		udb.setType(0);
		udb.setUnit("1243");
	}

	@Test
	public void getEmailtest() {
assertEquals("a@abc.co",udb.getEmail());
	}
	@Test
	public void getLeaseEndtest() {
		assertEquals(d,udb.getLease_end());
	}
	@Test
	public void getLeaseStarttest() {
		assertEquals(d,udb.getLease_start());
	}
	@Test
	public void getNametest() {
		assertEquals("name",udb.getName());
	}
	@Test
	public void getTypetest() {
		assertEquals(0,udb.getType());
	}
	@Test
	public void getUnittest() {
		assertEquals("1243",udb.getUnit());
	}

}
