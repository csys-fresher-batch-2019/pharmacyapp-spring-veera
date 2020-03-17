package com.chainsys.pharmacyapp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.pharmacyapp.dao.AdminDAO;
import com.chainsys.pharmacyapp.dao.impl.AdminDAOImpl;

@RestController
@RequestMapping("api")
public class AdminController {

	AdminDAO obj=new AdminDAOImpl();
	@PostMapping("/AdminLogin")
	public boolean AdminLogin(@RequestParam("admin_name") String Adminname, @RequestParam("pass")String pass) throws Exception
	{
	
		boolean result=obj.AdminLogin(Adminname, pass);
	
		return result;
		
	}

}
