package com.chainsys.pharmacyapp.service;

import com.chainsys.pharmacyapp.dao.UserDAO;
import com.chainsys.pharmacyapp.dao.impl.UserDAOImplementation;
import com.chainsys.pharmacyapp.model.UserDetails;

public class UserService {

UserDAO u=new  UserDAOImplementation();
	
	public int addUserDetails(UserDetails p) throws Exception
	{
		return u.addUserDetails(p);
		
	}
	public boolean user(String name,String password) throws Exception
	{
		return u.user(name, password);
		
	}
}
