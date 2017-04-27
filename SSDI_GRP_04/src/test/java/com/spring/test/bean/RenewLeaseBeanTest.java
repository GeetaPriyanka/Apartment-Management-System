package com.spring.test.bean;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.spring.app.bean.RenewLeaseBean;

public class RenewLeaseBeanTest {
	public static RenewLeaseBean rlb;
	
	@BeforeClass
	public static void setUp(){
		rlb=new RenewLeaseBean();
		rlb.setApproval_status(false);
		rlb.setEmail("a@abc.co");
		rlb.setExtension_period(3);
		rlb.setUnit("12f");
	}

	@Test
	public void getApprovlStatustest() {
		assertEquals(false,rlb.isApproval_status());
	}
	@Test
	public void getEmailtest() {
		assertEquals("a@abc.co",rlb.getEmail());
	}
	@Test
	public void getExtensiontest() {
		assertEquals(3,rlb.getExtension_period());
	}
	@Test
	public void getUnittest() {
		assertEquals("12f",rlb.getUnit());
	}

}
