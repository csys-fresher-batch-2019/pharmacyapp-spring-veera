package com.chainsys.pharmacyapp.dao;

import java.util.ArrayList;

import com.chainsys.pharmacyapp.model.Order;

public interface orderDAO {
void addorderdetails(Order O)throws Exception;
ArrayList displayOrderDetails() throws Exception;
}
