package com.spring.test.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.spring.app.HomeController;
import com.spring.app.bean.UserBean;
import com.spring.app.model.Otp;
import com.spring.app.model.User;
import com.spring.app.service.ApartmentService;
import com.spring.app.service.ComplaintService;
import com.spring.app.service.Occupied_apartmentService;
import com.spring.app.service.OtpService;
import com.spring.app.service.UserService;


public class HomeControllerTest {

	@InjectMocks
	private HomeController homeController;
	@Mock
	private ApartmentService available_apartmentService;
	@Mock
	private OtpService otpService;
	@Mock
	private ApartmentService apartmentService;
	@Mock
	private UserService userService;
	@Mock
	private ComplaintService complainService;
	@Mock
	private Occupied_apartmentService occService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testHome() {
		String result = homeController.home(Locale.US, mock(Model.class));
		assertEquals("home", result);
	}

	@Test
	public void testSignUp() {
		String result = homeController.signupPage(mock(Model.class));
		assertEquals("signup", result);
	}
	@Test
	public void testExecuteSignup() {
		//HttpServletRequest request, HttpServletResponse response, @ModelAttribute("signupBean")UserBean signupBean

		Otp o=new Otp();
		o.setOtp(121212);
		o.setUnit("9505");

		List<Otp> otpList = new ArrayList<Otp>();
		otpList.add(o);
		when(otpService.listOtp()).thenReturn(otpList);

		UserBean signupBean = new UserBean();
		signupBean.setEmail("sneha@g");
		signupBean.setFirstname("sneha");
		signupBean.setLastname("gan");
		signupBean.setOtp(o.getOtp());
		signupBean.setPassword("123456");

		ModelAndView modelAndView = homeController.executeSignup(mock(HttpServletRequest.class), mock(HttpServletResponse.class), signupBean);

		User user=new User();
		user.setFirstname(signupBean.getFirstname());
		user.setLastname(signupBean.getLastname());
		user.setEmail(signupBean.getEmail());
		user.setPassword(signupBean.getPassword());
		user.setType(2);
		user.setUnit(o.getUnit());
		userService.addUser(user);

		List<User> userList = userService.listUsers();
		List<String> emailList = new ArrayList<String>();

		for(User u: userList){
			emailList.add(u.getEmail());
		}
		assertTrue(null != modelAndView.getModel().get("loginBean"));
	}

	@Test
	public void testExecuteSignupWithError() {

		UserBean signupBean = new UserBean();
		signupBean.setEmail("sneha@g");
		signupBean.setFirstname("sneha");
		signupBean.setLastname("gan");
		signupBean.setPassword("123456");

		ModelAndView modelAndView 
		= homeController.executeSignup(mock(HttpServletRequest.class), mock(HttpServletResponse.class), signupBean);

		assertTrue(null != modelAndView.getViewName());
		assertTrue("signup".equals(modelAndView.getViewName()));
	}
}