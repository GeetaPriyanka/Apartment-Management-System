package com.spring.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.app.bean.Loginbean;
import com.spring.app.bean.UserBean;
import com.spring.app.bean.UserDetailsBean;
import com.spring.app.dao.UserDAO;
import com.spring.app.dao.UserDAOImpl;
import com.spring.app.model.Renew_lease;
import com.spring.app.model.User;
import com.spring.app.service.UserServiceImpl;

public class UserServiceTest {
	
	private static UserServiceImpl userServiceMock;
	private static UserDetailsBean u;
	private static Loginbean loginBean1;
	private static UserDAO user;
	private static User usr;
	@BeforeClass
	 public static void setUp(){
	    //Create mock object of BookDAL
		userServiceMock=new UserServiceImpl();
	    user = mock(UserDAO.class);
	    usr=mock(User.class);
	    userServiceMock.setUserDAO(user);
	    usr=new User();
	    usr.setEmail("harsh");
	    usr.setFirstname("Harsh");
	    usr.setLastname("h");
	    usr.setPassword("123456");
	    usr.setType(1);
	    usr.setUnit("9545F");
	    
	    
	    loginBean1 = new Loginbean();
	    loginBean1.setUsername(usr.getEmail());
	    loginBean1.setPassword(usr.getPassword());
	    
	    u= new UserDetailsBean();
	    u.setEmail("harsh");
	    u.setName("Harsh Hundiwala");
	    u.setUnit("9545F");
	
	  
	}
	@Test
	public void getUserList(){
	    User usr1=new User();
	    usr1.setEmail("harsh");
	    usr1.setFirstname("Harsh");
	    usr1.setLastname("h");
	    usr1.setPassword("123456");
	    usr1.setType(1);
	    usr1.setUnit("9545F");
	    
		List<User> ul=new ArrayList<User>();
		ul.add(usr1);
		when(user.listUsers()).thenReturn(ul);
		userServiceMock.listUsers();
		assertNotNull(userServiceMock.listUsers());
		assertEquals("harsh",usr1.getEmail());
	}
	
	@Test
	public void addUserTest(){
	    User usr1=new User();
	    usr1.setEmail("harsh");
	    usr1.setFirstname("Harsh");
	    usr1.setLastname("h");
	    usr1.setPassword("123456");
	    usr1.setType(1);
	    usr1.setUnit("9545F");
	    userServiceMock.addUser(usr1);
	    verify(user).addUser(usr1);
	}
	
	@Test
	public void deleteUserTest(){
	    User usr1=new User();
	    usr1.setEmail("harsh");
	    usr1.setFirstname("Harsh");
	    usr1.setLastname("h");
	    usr1.setPassword("123456");
	    usr1.setType(1);
	    usr1.setUnit("9545F");
	    userServiceMock.deleteUser("email@uncc.edu");
		verify(user,times(1)).deleteUser("email@uncc.edu");
		
	}
	@Test
	public void loginTestPositive() throws Exception {
		UserDetailsBean user = userServiceMock.validate(loginBean1);
		assertEquals("harsh", user.getEmail());
	}
	
	@Test
	public void loginTestNegative() throws Exception {
		UserDetailsBean user = userServiceMock.validate(loginBean1);
	   assertEquals("harsh", user.getEmail());
	}
}
