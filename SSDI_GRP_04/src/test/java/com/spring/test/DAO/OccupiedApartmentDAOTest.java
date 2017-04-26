package com.spring.test.DAO;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import com.spring.app.dao.Occupied_apartmentDAOImpl;
import com.spring.app.model.Occupied_apartment;
import com.spring.app.model.User;
import com.spring.app.service.UserService;
import com.spring.app.service.UserServiceImpl;

public class OccupiedApartmentDAOTest {

	private static Occupied_apartmentDAOImpl occaptDaoImplMock;
	private static Occupied_apartment occapt1;
	private static Occupied_apartment occapt2;
	
	private static Occupied_apartment occaptmock;

	private static UserServiceImpl userservicemockimpl;
	private static com.spring.app.model.User User, User2;


	
	@BeforeClass
	public static void setup(){
		userservicemockimpl=mock(UserServiceImpl.class);
		User=mock(User.class);
		User2=mock(User.class);
		User=new User(); User2=new User();
		occaptDaoImplMock=mock(Occupied_apartmentDAOImpl.class);
		Date d=new Date(0);
		occapt1=new Occupied_apartment();
		occapt2=new Occupied_apartment();
		occapt1.setBill(45);
		occapt1.setEmail("sneha@g");
		occapt1.setLeaseEnd(d);
		occapt1.setLeaseStart(d);
		occapt1.setUnit("9505J");

		occapt2.setBill(35);
		occapt2.setEmail("snehaV@g");
		occapt2.setLeaseEnd(d);
		occapt2.setLeaseStart(d);
		occapt2.setUnit("9450");

		User.setEmail("snehaV@g");
		User.setUnit("9450");
		
		User2.setEmail("sneha@g");
		User2.setUnit("9505J");
		
		when(occaptDaoImplMock.occupiedApartmentsList()).thenReturn(Arrays.asList(occapt1,occapt2));
		when(userservicemockimpl.listUsers()).thenReturn(Arrays.asList(User, User2));

	}

	@Test
	public void testGetAllOccApt() {
		List<Occupied_apartment> occlist=occaptDaoImplMock.occupiedApartmentsList();
		assertEquals(2, occlist.size());
		Occupied_apartment o=occlist.get(0);
		assertEquals("9505J",o.getUnit());
	}

	@Test
	public void testAddOccApt() {
		Occupied_apartment occuaptmnt = mock(Occupied_apartment.class);
		occuaptmnt.setEmail("ex@ex.ex");
		occuaptmnt.setBill(1);
		occuaptmnt.setUnit("Example unit");
		occaptDaoImplMock.addOccupiedApartment(occuaptmnt);
		List<Occupied_apartment> occlist = occaptDaoImplMock.occupiedApartmentsList();
		for(Occupied_apartment o : occlist){
			if("Example unit".equals(o.getUnit())){
				assertEquals("Example unit", o.getUnit());
				assertEquals("ex@ex.ex", o.getEmail());
				
			}
		}
	}

	@Test
	public void testDeleteOccApt() {
		String unit="9523";
		String email=null;
		
		Occupied_apartment occuaptmnt = new Occupied_apartment();
		occuaptmnt.setEmail("ex@ex.ex");
		occuaptmnt.setBill(1);
		occuaptmnt.setUnit("Example unit");
		occuaptmnt.setUnit("9523");
		
		occaptDaoImplMock.addOccupiedApartment(occuaptmnt);
		
		List<Occupied_apartment> occlist = occaptDaoImplMock.occupiedApartmentsList();
		occaptmock=mock(Occupied_apartment.class);
	
		for (Occupied_apartment occaptmock: occlist) {
		if(occaptmock.getUnit().equals(unit)){
			email = occaptmock.getEmail();
		}
		}
		
		userservicemockimpl.deleteUser(email);
		List <User> userlist=userservicemockimpl.listUsers();
		assertEquals(2, userlist.size());

		occaptDaoImplMock.deleteOccupiedApartment("Example unit");

		occlist = occaptDaoImplMock.occupiedApartmentsList();

		assertEquals(2, occlist.size());
	}
}
