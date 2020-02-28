package com.chainsys.pharmacyapp.dao;

import com.chainsys.pharmacyapp.model.Sales;

public interface SalesDAO {
int addSalesDetails(Sales se)throws Exception;
int amountCalAfterSales(int productId,int salesId) throws Exception;
}
