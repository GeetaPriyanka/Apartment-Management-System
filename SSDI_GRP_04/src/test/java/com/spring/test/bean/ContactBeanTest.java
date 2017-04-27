package com.spring.test.bean;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.spring.app.bean.ContactBean;

public class ContactBeanTest {
	public static ContactBean cb;
	
@BeforeClass
public static void setUp(){
	cb=new ContactBean();
	cb.setComment("interest");
	cb.setEmail("a@abc.co");
	cb.setName("ab");
	
}
	@Test
	public void getCommenttest() {
assertEquals("interest",cb.getComment());
	}
	@Test
	public void getEmailtest() {
		assertEquals("a@abc.co",cb.getEmail());
	}
	@Test
	public void getNametest() {
		assertEquals("ab",cb.getName());
	}
}
