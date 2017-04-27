package com.spring.test.bean;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.spring.app.bean.ComplaintBean;

public class ComplaintBeanTest {
public static ComplaintBean cBean;
	
	@BeforeClass
	public static void setUp(){
		cBean=new ComplaintBean();
		cBean.setUnit("9545A");
		cBean.setDescription("not");
		cBean.setSeverity(1);
		cBean.setType("plumbing");
		cBean.setTime(1000);
		
	}
	@Test
	public void getUnittest() {
assertEquals("9545A",cBean.getUnit());
	}
	@Test
	public void getDescriptiontest() {
		assertEquals("not",cBean.getDescription());
	}
	@Test
	public void getSeveritytest() {
		assertEquals(1,cBean.getSeverity());
	}
	@Test
	public void getTypetest() {
		assertEquals("plumbing",cBean.getType());
	}
	@Test
	public void getTimetest() {
		assertEquals(1000,cBean.getTime());
	}
	

}
