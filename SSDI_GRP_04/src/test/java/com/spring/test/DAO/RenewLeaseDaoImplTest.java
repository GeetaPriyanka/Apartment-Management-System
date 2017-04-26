package com.spring.test.DAO;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.stereotype.Repository;
import com.spring.app.dao.RenewLeaseDAOimpl;
import com.spring.app.model.Renew_lease;


@Repository
public class RenewLeaseDaoImplTest {
private static RenewLeaseDAOimpl renewDaoMock;
	private static Renew_lease renewLeaseMock;
	private static Renew_lease renewLeaseMock2;	
	
	private static SessionFactory sessionFactory;
	private static Session session1,session2;
	public void setSessionFactory(SessionFactory sf){
		RenewLeaseDaoImplTest.sessionFactory = sf;
	}

	@BeforeClass
	public static void setUp(){
		
        renewLeaseMock=mock(Renew_lease.class);
		renewLeaseMock=new Renew_lease();
		renewLeaseMock2=new Renew_lease();
		renewLeaseMock.setApproval_status(true);
		renewLeaseMock.setEmail("singh@uncc.edu");
		renewLeaseMock.setExtenion_period(3);
		renewLeaseMock.setUnit("9327B");
		
		renewLeaseMock2.setApproval_status(false);
		renewLeaseMock2.setEmail("ssingh@uncc.edu");
		renewLeaseMock2.setExtenion_period(6);
		renewLeaseMock2.setUnit("9254A");
		renewDaoMock=mock(RenewLeaseDAOimpl.class);
		when(renewDaoMock.listRenewLease()).thenReturn(Arrays.asList(renewLeaseMock,renewLeaseMock2));
	}
	
	@Test
	public void getRenewLeasetest() {
	List<Renew_lease> rl=renewDaoMock.listRenewLease();
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
		renewDaoMock.addRenewLease(r);
		List<Renew_lease> rl=renewDaoMock.listRenewLease();
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
		renewDaoMock.addRenewLease(r);
		List<Renew_lease> rl=renewDaoMock.listRenewLease();

		renewDaoMock.deleteRenewLease("email@uncc.edu");
		verify(renewDaoMock,times(1)).deleteRenewLease("email@uncc.edu");

	
	}
}
