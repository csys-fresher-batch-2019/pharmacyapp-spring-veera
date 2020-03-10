package com.chainsys.pharmacyapp.dao;

import com.chainsys.pharmacyapp.model.Sales;

public interface SalesDAO {
	public int addSalesDetails(Sales se) throws Exception;

	public int amountCalAfterSales(int productId, int salesId) throws Exception;
}
