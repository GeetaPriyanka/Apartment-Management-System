package com.spring.test.DAO;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.spring.app.dao.UserDAOImpl;
import com.spring.app.model.User;

public class UserDAOTest {
	private static UserDAOImpl userDAO;
	private static User user1;
	private static User user2;
	
	@BeforeClass
	 public static void setUp(){
	    //Create mock object of BookDAL
	    userDAO = mock(UserDAOImpl.class);

	    //Create few instances of User class.
	    user1= new User("hhundiwala@gmail.com","harsh","hundiwala","123456","9545F",2);
	    user2= new User("hh","h","hundiwala","123456","9345F",1);
	    
	    when(userDAO.listUsers()).thenReturn(Arrays.asList(user1, user2));
	    
	  }
	
	  @Test
	  public void testGetAllUsers() throws Exception {

	    List<User> allUser = userDAO.listUsers();
	    assertEquals(2, allUser.size());
	    User u = allUser.get(0);
	    assertEquals("hhundiwala@gmail.com", u.getEmail());
	    assertEquals("harsh", u.getFirstname());
	    assertEquals("hundiwala", u.getLastname());
	    assertEquals("123456", u.getPassword());
	    assertEquals("9545F", u.getUnit());
	    assertEquals(2, u.getType());
	  }
	  
}
