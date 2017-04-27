package com.spring.test.model;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import com.spring.app.model.User;

public class UserModelTest {

	private static User user;

	@BeforeClass
	 public static void setUp(){

	    user= new User("hhundiwala@gmail.com","harsh","hundiwala","123456","9545F",2);
	  
	    
	  }
	
	@Test
	public void getEmailtest() {
	assertEquals("hhundiwala@gmail.com",user.getEmail());
	}
	
	@Test
	public void getFirstNametest() {
	assertEquals("harsh",user.getFirstname());
	}
	@Test
	public void getLastNametest() {
	assertEquals("hundiwala",user.getLastname());
	}
	@Test
	public void getPasswordtest() {
	assertEquals("123456",user.getPassword());
	}
	
	@Test
	public void getUnittest() {
	assertEquals("9545F",user.getUnit());
	}
	@Test
	public void getTypetest() {
	assertEquals(2,user.getType());
	}

}
