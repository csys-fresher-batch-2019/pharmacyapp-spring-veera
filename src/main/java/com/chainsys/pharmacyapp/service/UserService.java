package com.chainsys.pharmacyapp.service;

import com.chainsys.pharmacyapp.dao.UserDAO;
import com.chainsys.pharmacyapp.dao.impl.UserDAOImpl;
import com.chainsys.pharmacyapp.model.UserDetails;

public class UserService {

	UserDAO userDAO = new UserDAOImpl();

	public int save(UserDetails p) throws Exception {
		return userDAO.save(p);

	}

	public boolean user(String name, String password) throws Exception {
		return userDAO.user(name, password);

	}
}
