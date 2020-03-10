package com.chainsys.pharmacyapp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.pharmacyapp.dao.orderDAO;
import com.chainsys.pharmacyapp.dao.impl.orderDAOImplementation;
import com.chainsys.pharmacyapp.model.Order;

public class orderService {
	orderDAO o = new orderDAOImplementation();

	public void addorderdetails(Order O) throws Exception {
		o.addorderdetails(O);
	}

	public ArrayList displayOrderDetails() throws Exception {
		return o.displayOrderDetails();

	}
}
