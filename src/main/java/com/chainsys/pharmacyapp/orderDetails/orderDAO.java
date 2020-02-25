package com.chainsys.pharmacyapp.orderDetails;

import java.util.ArrayList;

public interface orderDAO {
void addorderdetails(Order O)throws Exception;
ArrayList displayOrderDetails() throws Exception;
}
