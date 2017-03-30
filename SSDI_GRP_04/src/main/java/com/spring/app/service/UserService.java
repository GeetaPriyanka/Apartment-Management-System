package com.spring.app.service;

import java.util.List;

import com.spring.app.bean.Loginbean;
import com.spring.app.bean.UserDetailsBean;
import com.spring.app.model.User;

public interface UserService {
	public List<User> listUsers();
	public void addUser(User user);
	public void deleteUser(String email);
	public UserDetailsBean validate(Loginbean b);
}
