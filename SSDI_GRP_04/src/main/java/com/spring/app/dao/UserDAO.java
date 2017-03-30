package com.spring.app.dao;

import java.util.List;

import com.spring.app.model.*;

public interface UserDAO {
	public List<User> listUsers();
	public void addUser(User user);
	public void deleteUser(String email);
}
