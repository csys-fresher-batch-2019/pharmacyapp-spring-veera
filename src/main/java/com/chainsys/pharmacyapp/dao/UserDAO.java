package com.chainsys.pharmacyapp.dao;

import com.chainsys.pharmacyapp.model.UserDetails;

public interface UserDAO {
int addUserDetails(UserDetails p) throws Exception;
public boolean user(String name,String password) throws Exception;
}
