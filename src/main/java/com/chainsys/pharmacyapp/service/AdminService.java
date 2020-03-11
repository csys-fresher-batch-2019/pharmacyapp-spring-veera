package com.chainsys.pharmacyapp.service;

import com.chainsys.pharmacyapp.dao.AdminDAO;
import com.chainsys.pharmacyapp.dao.impl.AdminDAOImpl;

public class AdminService {

	AdminDAO adminDAO = new AdminDAOImpl();

	public boolean AdminLogin(String Adminname, String pass) throws Exception {

		return adminDAO.AdminLogin(Adminname, pass);

	}
}
