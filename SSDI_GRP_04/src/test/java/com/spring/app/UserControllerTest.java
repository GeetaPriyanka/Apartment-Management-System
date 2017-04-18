package com.spring.app;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;



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

import com.spring.app.bean.Loginbean;
import com.spring.app.bean.UserDetailsBean;
import com.spring.app.model.Occupied_apartment;
import com.spring.app.service.ComplaintService;
import com.spring.app.service.UserService;


public class UserControllerTest {

	@InjectMocks
	private UserController userController;
	@Mock
	private UserService userService;
	@Mock
	private Occupied_apartment occapt;
	@Mock
	private ComplaintService complaintService;
	
	UserDetailsBean userInfo;
	Loginbean loginBean1;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		loginBean1 = new Loginbean();
	    loginBean1.setUsername("sneha@g");
	    loginBean1.setPassword("123456");
	    
	   // userInfo.setEmail("sneha@g");
	    //userInfo.setName("sneha");
	   // userInfo.setUnit("9545F");
	    //userInfo.setType(2);
	}
	
	@Test
	public void testExecuteLogin(){
		
	    when(userService.validate(loginBean1)).thenReturn(userInfo);
	    
	    ModelAndView modelAndView 
		= userController.executeLogin(mock(HttpServletRequest.class), mock(HttpServletResponse.class), loginBean1);
	    
		assertTrue(null != modelAndView.getViewName());
		assertTrue("welcome".equals(modelAndView.getViewName()));
	}
}
