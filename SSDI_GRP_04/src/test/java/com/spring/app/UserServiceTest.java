package com.spring.app;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.app.bean.Loginbean;
import com.spring.app.bean.UserBean;
import com.spring.app.bean.UserDetailsBean;
import com.spring.app.dao.UserDAOImpl;
import com.spring.app.model.User;
import com.spring.app.service.UserServiceImpl;

public class UserServiceTest {
	
	private static UserServiceImpl userServiceMock;
	private static UserDetailsBean u;
	private static Loginbean loginBean1;
	
	@BeforeClass
	 public static void setUp(){
	    //Create mock object of BookDAL
	    userServiceMock = mock(UserServiceImpl.class);
	    
	    
	    loginBean1 = new Loginbean();
	    loginBean1.setUsername("harsh");
	    loginBean1.setPassword("harsh");
	    
	    u = new UserDetailsBean();
	    u.setEmail("harsh");
	    u.setName("Harsh Hundiwala");
	    u.setUnit("9545F");
	    when(userServiceMock.validate(loginBean1)).thenReturn(u);
	  }

	@Test
	public void loginTestPositive() throws Exception {
		UserDetailsBean user = userServiceMock.validate(loginBean1);
		assertEquals("harsh", user.getEmail());
		assertEquals("harsh", user.getEmail());
	}
	
	@Test
	public void loginTestNegative() throws Exception {
		UserDetailsBean user = userServiceMock.validate(loginBean1);
		assertEquals("harshf", user.getEmail());
	}
}
