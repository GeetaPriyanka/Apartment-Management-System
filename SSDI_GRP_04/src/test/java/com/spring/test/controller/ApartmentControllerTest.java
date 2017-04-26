package com.spring.test.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;

import com.spring.app.ApartmentController;
import com.spring.app.model.Available_apartment;
import com.spring.app.service.ApartmentService;


public class ApartmentControllerTest {

	@InjectMocks
	private ApartmentController apartmentController;
	@Mock
	ApartmentService available_apartmentService;
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testGetListApartments() {
		
		Model model;
		model=mock(Model.class);
		String viewName = apartmentController.listApartments(model);
		List<Available_apartment> list = new ArrayList<Available_apartment>();
		when(available_apartmentService.listApartments()).thenReturn(list);
		assertEquals("apartment", viewName);
	}
}
