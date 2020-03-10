package com.chainsys.pharmacyapp.service;

import java.util.ArrayList;

import com.chainsys.pharmacyapp.dao.OrderDAO;
import com.chainsys.pharmacyapp.dao.impl.OrderDAOImpl;
import com.chainsys.pharmacyapp.model.Order;

public class OrderService {
	OrderDAO o = new OrderDAOImpl();

	public void save(Order O) throws Exception {
		o.save(O);
	}

	public ArrayList displayOrderDetails() throws Exception {
		return o.displayOrderDetails();

	}
}
