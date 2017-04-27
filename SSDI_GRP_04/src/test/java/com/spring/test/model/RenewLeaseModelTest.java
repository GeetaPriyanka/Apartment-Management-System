package com.spring.test.model;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import com.spring.app.model.Renew_lease;

public class RenewLeaseModelTest {

	private static Renew_lease renewLease;
	

	@BeforeClass
	public static void setUp(){
		
		renewLease=new Renew_lease();
		renewLease.setApproval_status(true);
		renewLease.setEmail("singh@uncc.edu");
		renewLease.setExtenion_period(3);
		renewLease.setUnit("9327B");

	}
	@Test
	public void getApprovalStatustest() {
assertEquals(true,renewLease.isApproval_status());
	}
	@Test
	public void getEmailtest() {
assertEquals("singh@uncc.edu",renewLease.getEmail());
	}

	@Test
	public void getExtensionPeriodtest() {
		assertEquals(3,renewLease.getExtension_period());
	}

	@Test
	public void getUnittest() {
		assertEquals("9327B",renewLease.getUnit());
	}

}
