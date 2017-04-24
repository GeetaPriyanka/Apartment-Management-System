package com.spring.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
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

import com.spring.app.bean.ComplaintBean;
import com.spring.app.bean.Loginbean;
import com.spring.app.bean.RenewLeaseBean;
import com.spring.app.bean.UserDetailsBean;
import com.spring.app.model.Available_apartment;
import com.spring.app.model.Complaint;
import com.spring.app.model.Occupied_apartment;
import com.spring.app.model.Otp;
import com.spring.app.service.ApartmentService;
import com.spring.app.service.ComplaintService;
import com.spring.app.service.Occupied_apartmentService;
import com.spring.app.service.OtpService;
import com.spring.app.service.RenewLeaseService;
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
		ModelAndView modelAndView 
		= userController.executeLogin(mock(HttpServletRequest.class), mock(HttpServletResponse.class), loginBean1);

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
	}
	
	@Test
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
		assertTrue("m_welcome".equals(modelAndView.getViewName()));
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
	public void testRenewLeaseRequest(){
	
		userInfo=mock(UserDetailsBean.class);
		
		ModelAndView modelAndView 
		= userController.renewLeasereq(mock(RenewLeaseBean.class), mock(Model.class));
		assertTrue(null != modelAndView.getViewName());
		assertTrue("welcome".equals(modelAndView.getViewName()));
	}
	
}

