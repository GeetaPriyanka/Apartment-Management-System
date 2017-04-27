package com.spring.test.bean;

import static org.junit.Assert.*;
import java.sql.Date;
import org.junit.BeforeClass;
import org.junit.Test;
import com.spring.app.bean.AllocateBean;

public class AllocateBeanTest {
	public static AllocateBean  aBean;
	public static Date d;
	@BeforeClass
	public static void setUp(){
		aBean=new AllocateBean();
		d=new Date(1123);
		aBean.setUnit("9545A");
		aBean.setStart(d);
		aBean.setEnd(d);

	}

	@Test
	public void getUnittest() {
		assertEquals("9545A",aBean.getUnit());
	}

	@Test
	public void getStartDatetest() {
		assertEquals(d,aBean.getStart());
	}
	@Test
	public void getEndDatetest() {
		assertEquals(d,aBean.getEnd());
	}
}
