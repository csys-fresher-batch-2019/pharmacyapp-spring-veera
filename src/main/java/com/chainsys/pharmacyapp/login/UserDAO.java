package com.chainsys.pharmacyapp.login;

public interface UserDAO {
int addUserDetails(UserDetails p) throws Exception;
public boolean user(String name,String password) throws Exception;
}
