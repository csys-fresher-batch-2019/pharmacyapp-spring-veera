package com.chainsys.pharmacyapp.service;

import com.chainsys.pharmacyapp.dao.SalesDAO;
import com.chainsys.pharmacyapp.dao.impl.SalesImplementation;
import com.chainsys.pharmacyapp.model.Sales;

public class SalesService {

SalesDAO sa=new SalesImplementation();	
	public int addSalesDetails(Sales se)throws Exception
	{
		
		return sa.addSalesDetails(se);
		
	}
	public int amountCalAfterSales(int productId,int salesId) throws Exception
	{
	return sa.amountCalAfterSales(productId, salesId);
		
	}
	
}
