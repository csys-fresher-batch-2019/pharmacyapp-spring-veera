package com.chainsys.pharmacyapp.service;

import com.chainsys.pharmacyapp.dao.AdminDAO;
import com.chainsys.pharmacyapp.dao.impl.AdminDAOImplementation;

public class adminService {

	AdminDAO ad = new AdminDAOImplementation();

	public boolean AdminLogin(String Adminname, String pass) throws Exception {

		return ad.AdminLogin(Adminname, pass);

	}
}
