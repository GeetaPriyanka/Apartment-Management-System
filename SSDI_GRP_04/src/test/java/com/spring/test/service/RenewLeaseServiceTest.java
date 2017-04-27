package com.spring.test.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import com.spring.app.dao.RenewLeaseDAO;
import com.spring.app.dao.RenewLeaseDAOimpl;
import com.spring.app.model.Renew_lease;
import com.spring.app.service.RenewLeaseServiceImpl;



public class RenewLeaseServiceTest {

	private static RenewLeaseServiceImpl rls;
	private static Renew_lease renewLease;
	private static RenewLeaseDAO renewDao;

	@BeforeClass
	public static void setUp(){
		rls=new RenewLeaseServiceImpl();
		renewDao=mock(RenewLeaseDAO.class);
		renewLease=mock(Renew_lease.class);
		renewLease=new Renew_lease();
		rls.setRenewLeaseDAO(renewDao);
		renewLease.setApproval_status(true);
		renewLease.setEmail("singh@uncc.edu");
		renewLease.setExtenion_period(3);
		renewLease.setUnit("9327B");

	}


	@Test
	public void getRenewLeasetest() {
		List<Renew_lease> rl=new ArrayList<Renew_lease>();
		rl.add(renewLease);
		when(renewDao.listRenewLease()).thenReturn(rl);
		rls.listRenewLease();
		assertNotNull(rls.listRenewLease());
		assertEquals(3, renewLease.getExtension_period());
		assertEquals(1, (rls.listRenewLease().size()));
		}

	@Test
	public void addRenewLease(){
		Renew_lease r=new Renew_lease();
		r.setApproval_status(false);
		r.setEmail("email");
		r.setExtenion_period(9);
		r.setUnit("9878V");
		rls.addRenewLease(r);		
		verify(renewDao).addRenewLease(r);
		
		assertEquals(9,r.getExtension_period());
		
	}

	@Test
	public void deleteRenewLeaseTest(){
		Renew_lease r=new Renew_lease();
		r.setApproval_status(false);
		r.setEmail("email@uncc.edu");
		r.setExtenion_period(9);
		r.setUnit("9878V");
	    rls.deleteRenewLease("email@uncc.edu");
		verify(renewDao,times(1)).deleteRenewLease("email@uncc.edu");


	}

}
