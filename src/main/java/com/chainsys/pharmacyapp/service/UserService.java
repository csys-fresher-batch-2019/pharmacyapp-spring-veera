package com.chainsys.pharmacyapp.service;

import com.chainsys.pharmacyapp.dao.UserDAO;
import com.chainsys.pharmacyapp.dao.impl.UserDAOImpl;
import com.chainsys.pharmacyapp.model.UserDetails;

public class UserService {

	UserDAO u = new UserDAOImpl();

	public int save(UserDetails p) throws Exception {
		return u.save(p);

	}

	public boolean user(String name, String password) throws Exception {
		return u.user(name, password);

	}
}
