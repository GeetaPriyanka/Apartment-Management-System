package com.spring.app;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import com.spring.app.dao.RenewLeaseDAOimpl;
import com.spring.app.model.Renew_lease;
import com.spring.app.service.RenewLeaseServiceImpl;



public class RenewLeaseServiceTest {
	
	private static RenewLeaseServiceImpl RenewLeaseServiceMock;
	private static RenewLeaseDAOimpl renewDao;
	private static Renew_lease renewLease;
	private static Renew_lease renewLease2;
	
	@BeforeClass
	public static void setUp(){
		RenewLeaseServiceMock=mock(RenewLeaseServiceImpl.class);
        renewDao=mock(RenewLeaseDAOimpl.class);
		renewLease=new Renew_lease();
		renewLease2=new Renew_lease();
		renewLease.setApproval_status(true);
		renewLease.setEmail("singh@uncc.edu");
		renewLease.setExtenion_period(3);
		renewLease.setUnit("9327B");
		
		renewLease2.setApproval_status(false);
		renewLease2.setEmail("ssingh@uncc.edu");
		renewLease2.setExtenion_period(6);
		renewLease2.setUnit("9254A");
		
		when(RenewLeaseServiceMock.listRenewLease()).thenReturn(Arrays.asList(renewLease,renewLease2));
	}
	

	@Test
	public void getRenewLeasetest() {
	List<Renew_lease> rl=RenewLeaseServiceMock.listRenewLease();
	assertEquals(2,rl.size());
	Renew_lease r=rl.get(0);
	assertEquals("9327B", r.getUnit());
	}

	@Test
	public void addRenewLease(){
		Renew_lease r=new Renew_lease();
		r.setApproval_status(false);
		r.setEmail("email");
		r.setExtenion_period(9);
		r.setUnit("9878V");
		RenewLeaseServiceMock.addRenewLease(r);
		List<Renew_lease> rl=RenewLeaseServiceMock.listRenewLease();
		for(Renew_lease re:rl){
			if("email".equals(re.getEmail())){
				assertEquals(9, re.getExtension_period());
				assertEquals(false, re.isApproval_status());
			}
		}
	}
	
	@Test
	public void deleteRenewLeaseTest(){
		Renew_lease r=new Renew_lease();
		r.setApproval_status(false);
		r.setEmail("email@uncc.edu");
		r.setExtenion_period(9);
		r.setUnit("9878V");
		RenewLeaseServiceMock.addRenewLease(r);
		List<Renew_lease> rl=RenewLeaseServiceMock.listRenewLease();

		RenewLeaseServiceMock.deleteRenewLease("email@uncc.edu");
		verify(RenewLeaseServiceMock,times(1)).deleteRenewLease("email@uncc.edu");

	
	}

}
