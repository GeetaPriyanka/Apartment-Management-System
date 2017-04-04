package com.spring.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.spring.app.model.User;
import com.spring.app.bean.Loginbean;
import com.spring.app.bean.UserDetailsBean;
import com.spring.app.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	
	private UserDAO userDAO;

	public void setUserDAO(UserDAO personDAO) {
		this.userDAO = personDAO;
	}

	@Override
	@Transactional
	public List<User> listUsers() {
		return this.userDAO.listUsers();
	}
	
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		this.userDAO.addUser(user);
	}

	@Override
	@Transactional
	public void deleteUser(String email) {
		// TODO Auto-generated method stub
		this.userDAO.deleteUser(email);
	}

	@Override
	@Transactional
	public UserDetailsBean validate(Loginbean loginBean) {
		List<User> users = this.userDAO.listUsers();
		UserDetailsBean userinfo = new UserDetailsBean();
		for (User u : users) {
			if(loginBean.getUsername().equals(u.getEmail()) && loginBean.getPassword().equals(u.getPassword())){
				System.out.println("User Login Successful");
				userinfo.setEmail(u.getEmail());
				userinfo.setName(u.getFirstname()+" " + u.getLastname());
				userinfo.setUnit(u.getUnit());
				userinfo.setType(u.getType());
				return userinfo;
			}
		}
		return null;
	}
}
