package com.chainsys.pharmacyapp.dao;

import com.chainsys.pharmacyapp.model.UserDetails;

public interface UserDAO {
	public boolean user(String name, String password) throws Exception;

	public int save(UserDetails p) throws Exception;

}
