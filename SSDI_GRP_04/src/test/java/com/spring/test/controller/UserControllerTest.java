package com.spring.test.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.spring.app.UserController;
import com.spring.app.bean.ComplaintBean;
import com.spring.app.bean.Loginbean;
import com.spring.app.bean.RenewLeaseBean;
import com.spring.app.bean.UserDetailsBean;
import com.spring.app.bean.deleteApartmentBean;
import com.spring.app.model.Available_apartment;
import com.spring.app.model.Complaint;
import com.spring.app.model.Occupied_apartment;
import com.spring.app.model.Otp;
import com.spring.app.model.Renew_lease;
import com.spring.app.service.ApartmentService;
import com.spring.app.service.ApartmentServiceImpl;
import com.spring.app.service.ComplaintService;
import com.spring.app.service.Occupied_apartmentService;
import com.spring.app.service.Occupied_apartmentServiceImpl;
import com.spring.app.service.OtpService;
import com.spring.app.service.RenewLeaseService;
import com.spring.app.service.RenewLeaseServiceImpl;
import com.spring.app.service.UserService;



@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

	@InjectMocks
	private UserController userController;
	@Mock
	private UserService userService;
	@Mock
	private Occupied_apartment occapt;
	@Mock
	Occupied_apartmentService occService;
	@Mock
	private ComplaintService complaintService;
	@Mock
	OtpService otpService;
	@Mock
	ApartmentService apartmentService;
	@Mock
	RenewLeaseService renewlease;
	@Mock
	UserDetailsBean userInfo;
	ComplaintBean complaint;
	Loginbean loginBean1;
	Complaint complain;
	RenewLeaseBean renew;
	deleteApartmentBean deleteapt;
	Otp otp;
	

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		occService = mock(Occupied_apartmentService.class);
		userService = mock(UserService.class);
		otpService = mock(OtpService.class);
		apartmentService = mock(ApartmentService.class);
		renewlease = mock(RenewLeaseService.class);
	}

	

	

	
	@Test
	public void testResolveRequest(){
		complain=new Complaint();
		complain.setComplaint_number(10);
		complain.setDescription("prowith sink");
		complain.setResolved(1);
		complain.setResolved_by("staff");
		complain.setSeverity(2);
		complain.setTime(0);
		complain.setType("plumbing");
		complain.setUnit("9545F");
		
		when(userController.getComplaintById(anyInt())).thenReturn(complain);
		ModelAndView modelAndView 
		= userController.resolveRequest(5, "staff", mock(HttpServletRequest.class));
		assertTrue(null != modelAndView.getViewName());
		assertTrue("s_welcome".equals(modelAndView.getViewName()));

	}

	@Test
	public void testAllocateApartment() throws Exception{
		java.util.Calendar cal = java.util.Calendar.getInstance();
		java.util.Date utilDate = cal.getTime();
		java.sql.Date sqlDate = new Date(utilDate.getTime());
		ModelAndView modelAndView 
		= userController.allocateapt(sqlDate, sqlDate, "955F", mock(HttpServletRequest.class));
		assertTrue(null != modelAndView.getViewName());
		assertTrue("otp".equals(modelAndView.getViewName()));
	}
	
	@Test
	public void testCheckOTP() throws Exception{
		java.util.Calendar cal = java.util.Calendar.getInstance();
		java.util.Date utilDate = cal.getTime();
		java.sql.Date sqlDate = new Date(utilDate.getTime());
		List<Otp> list=new ArrayList<Otp>();
		otp=new Otp();
		otp.setEndDate(sqlDate);
		otp.setOtp(123);
		otp.setStartDate(sqlDate);
		otp.setUnit("9545F");
		list.add(otp);
		userController.otpService=otpService;
		when(otpService.listOtp()).thenReturn(list);
		int i=userController.checkOtp("9545F");
				assertEquals(123,i);
	}
	
	@Test
	public void testCheckOTPNew() throws Exception{
		java.util.Calendar cal = java.util.Calendar.getInstance();
		java.util.Date utilDate = cal.getTime();
		java.sql.Date sqlDate = new Date(utilDate.getTime());
		List<Otp> list=new ArrayList<Otp>();
		otp=new Otp();
		otp.setEndDate(sqlDate);
		otp.setOtp(123);
		otp.setStartDate(sqlDate);
		otp.setUnit("9545F");
		list.add(otp);
		userController.otpService=otpService;
		when(otpService.listOtp()).thenReturn(list);
		int i=userController.checkOtp("9548F");
				assertEquals(-1,i);
	}
	
	
	
	@Test
	public void testgetUnAllocatedApartments(){
		java.util.Calendar cal = java.util.Calendar.getInstance();
		java.util.Date utilDate = cal.getTime();
		java.sql.Date sqlDate = new Date(utilDate.getTime());
		List<Otp> otpList=new ArrayList<Otp>();
		otp=new Otp();
		otp.setEndDate(sqlDate);
		otp.setOtp(123);
		otp.setStartDate(sqlDate);
		otp.setUnit("9525F");
		otpList.add(otp);
		userController.otpService=otpService;
		when(otpService.listOtp()).thenReturn(otpList);
		
		List<Available_apartment> apt_list = new ArrayList<Available_apartment>();
		Available_apartment a=new Available_apartment();
		a.setUnit("9545F");
		a.setRent(900);
		a.setBhk(1200);
		a.setArea(1500);
		apt_list.add(a);
		userController.apartmentService=apartmentService;

		when(apartmentService.listApartments()).thenReturn(apt_list);

		List<Available_apartment> Sendlist = userController.getUnAllocatedApartments();
		assertEquals(1,Sendlist.size());
	}
	

	
	@Test
	public void testleaseApproval()
	{
		java.util.Calendar cal = java.util.Calendar.getInstance();
		java.util.Date utilDate = cal.getTime();
		java.sql.Date sqlDate = new Date(utilDate.getTime());
		Occupied_apartment o=new Occupied_apartment();
		o.setEmail("geeta@gmail.com");
		o.setUnit("9523F");
		o.setLeaseEnd(sqlDate);
		
	   Renew_lease rlease1=new Renew_lease();

		rlease1.setUnit("9523F");
		rlease1.setExtenion_period(9);
		rlease1.setEmail("geeta@gmail.com");
		rlease1.setApproval_status(true);
	
	   assertTrue(rlease1.isApproval_status());
	   assertEquals(o.getLeaseEnd(),sqlDate);
	   
	}
	
	@Test
	public void testexecutevacate()
	{
		List<Available_apartment> apt_list = new ArrayList<Available_apartment>();
		Available_apartment a=new Available_apartment();
		a.setUnit("9523F");
		a.setRent(900);
		a.setBhk(1200);
		a.setArea(1500);
		apt_list.add(a);
		String d=a.getUnit();
		occService=mock( Occupied_apartmentService.class);
		apartmentService=mock( ApartmentService.class);
		deleteapt=new deleteApartmentBean();
		deleteapt.setVacate("9523F");
		ModelAndView modelAndView 
		= userController.executevacate(mock(HttpServletRequest.class), mock(HttpServletResponse.class) , deleteapt);
		
		assertEquals(d,deleteapt.getVacate());
		occService.deleteOccupiedApartment(d);
		apartmentService.addAvailableApartment(d);
		
		verify(occService,times(1)).deleteOccupiedApartment(a.getUnit());
		verify(apartmentService,times(1)).addAvailableApartment(a.getUnit());

		assertTrue(null != modelAndView.getViewName());
		assertTrue("m_welcome".equals(modelAndView.getViewName()));
	}
	
	@Test
	public void testgotopastComplaint()
	{
		ModelAndView modelAndView 
		= userController.gotopastComplaint(mock(Model.class));
		assertTrue(null != modelAndView.getViewName());
		assertTrue("pastReq".equals(modelAndView.getViewName()));
	}
	@Test
	public void testgetLeaseRequest()
	{
		Renew_lease rlease1=new Renew_lease();
		Renew_lease rlease2=new Renew_lease();

		rlease1.setUnit("9527");
		rlease1.setExtenion_period(9);
		rlease1.setEmail("abc@gmail.com");
		rlease1.setApproval_status(true);
		
		rlease2.setUnit("9530");
		rlease2.setExtenion_period(9);
		rlease2.setEmail("def@gmail.com");
		rlease2.setApproval_status(true);
		
		List<Renew_lease> listRenew = new ArrayList<Renew_lease>();
		listRenew.add(rlease1);
		listRenew.add(rlease2);
		
		when(userController.getLeaseRequest()).thenReturn(listRenew);
	
		List<Renew_lease> Renewlist=userController.getLeaseRequest();
		assertEquals(2,Renewlist.size());
	}
	
	@Test
	public void testupdateLeaseStatus()
	{
		userController.updateLeaseStatus("geeta@gmail.com");
		
		Renew_lease rlease1=new Renew_lease();
		rlease1.setApproval_status(true);
		
		assertTrue(rlease1.isApproval_status());

	}
	@Test
	public void testdeleteLeaseReq()
	{
		Renew_lease rlease1=new Renew_lease();

		rlease1.setUnit("9527");
		rlease1.setExtenion_period(9);
		rlease1.setEmail("abc@gmail.com");
		rlease1.setApproval_status(true);
		
		renewlease=mock(RenewLeaseServiceImpl.class);
		renewlease.deleteRenewLease("abc@gmail.com");
		verify(renewlease,times(1)).deleteRenewLease("abc@gmail.com");

		//assertEquals(null,rlease1.getEmail());

	}
	
/*	@Test
	public void testExecuteComplaint(){
		complaint=new ComplaintBean();
		complaint.setDescription("plumbing");
		complaint.setSeverity(2);
		complaint.setTime(System.currentTimeMillis());
		complaint.setType("plumbing");
		complaint.setUnit("9545F");
		
		userInfo = new UserDetailsBean();
		userInfo.setEmail("sneha@g");
		userInfo.setName("sneha");
		userInfo.setUnit("9545F");
		userInfo.setType(2);
		
		ModelAndView modelAndView 
		= userController.executeComplaint(mock(HttpServletRequest.class), mock(HttpServletResponse.class), complaint);

		assertTrue(null != modelAndView.getViewName());
		assertTrue("welcome".equals(modelAndView.getViewName()));
	
	}
	
	@Test
	public void testRenewLeaseRequest(){
	
		userInfo=mock(UserDetailsBean.class);
		
		ModelAndView modelAndView 
		= userController.renewLeasereq(mock(RenewLeaseBean.class), mock(Model.class));
		assertTrue(null != modelAndView.getViewName());
		assertTrue("welcome".equals(modelAndView.getViewName()));
	}
	
	@Test
	public void testExecuteLogin() throws Exception{
		loginBean1 = new Loginbean();
		loginBean1.setUsername("sneha@g");
		loginBean1.setPassword("123456");

		userInfo = new UserDetailsBean();
		userInfo.setEmail("sneha@g");
		userInfo.setName("sneha");
		userInfo.setUnit("9545F");
		userInfo.setType(2);

		
		userController.setUserService(userService);
		when(userService.validate(loginBean1)).thenReturn(userInfo);

		List<Available_apartment> aList = new ArrayList<Available_apartment>(); 
		when(apartmentService.listApartments()).thenReturn(aList);
		ModelAndView modelAndView = userController.executeLogin(mock(HttpServletRequest.class), mock(HttpServletResponse.class), loginBean1);

		assertTrue(null != modelAndView.getViewName());
		assertTrue("welcome".equals(modelAndView.getViewName()));

		userInfo.setType(0);
		modelAndView 
		= userController.executeLogin(mock(HttpServletRequest.class), mock(HttpServletResponse.class), loginBean1);


		assertTrue(null != modelAndView.getViewName());
		assertTrue("m_welcome".equals(modelAndView.getViewName()));

		userInfo.setType(1);
		modelAndView 
		= userController.executeLogin(mock(HttpServletRequest.class), mock(HttpServletResponse.class), loginBean1);


		assertTrue(null != modelAndView.getViewName());
		assertTrue("s_welcome".equals(modelAndView.getViewName()));
	}
	
	@Test
	public void testExecuteLoginValidateFail() throws Exception{
		loginBean1 = new Loginbean();
		loginBean1.setUsername("sneha@g");
		loginBean1.setPassword("123456");

		userInfo = new UserDetailsBean();
		userInfo.setEmail("sneha@g");
		userInfo.setName("sneha");
		userInfo.setUnit("9545F");
		userInfo.setType(2);

		occService = mock(Occupied_apartmentService.class);
		userService = mock(UserService.class);
		userController.setUserService(userService);
		when(userService.validate(loginBean1)).thenReturn(null);

		ModelAndView modelAndView 
		= userController.executeLogin(mock(HttpServletRequest.class), mock(HttpServletResponse.class), loginBean1);

		assertTrue(null != modelAndView.getViewName());
		assertTrue("login".equals(modelAndView.getViewName()));
	}*/

	
}

