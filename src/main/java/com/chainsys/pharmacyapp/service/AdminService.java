package com.chainsys.pharmacyapp.service;

import com.chainsys.pharmacyapp.dao.AdminDAO;
import com.chainsys.pharmacyapp.dao.impl.AdminDAOImpl;

public class AdminService {

	AdminDAO ad = new AdminDAOImpl();

	public boolean AdminLogin(String Adminname, String pass) throws Exception {

		return ad.AdminLogin(Adminname, pass);

	}
}
