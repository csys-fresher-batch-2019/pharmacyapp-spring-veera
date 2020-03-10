package com.chainsys.pharmacyapp.dao;

import java.util.ArrayList;

import com.chainsys.pharmacyapp.model.Order;

public interface OrderDAO {
	public void save(Order O) throws Exception;

	public ArrayList displayOrderDetails() throws Exception;
}
