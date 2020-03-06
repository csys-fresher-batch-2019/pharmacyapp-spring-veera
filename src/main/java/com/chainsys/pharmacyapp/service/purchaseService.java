package com.chainsys.pharmacyapp.service;


import com.chainsys.pharmacyapp.dao.PurchaseDAO;
import com.chainsys.pharmacyapp.dao.impl.PurchaseImplementation;
import com.chainsys.pharmacyapp.model.Purchase;

public class purchaseService {
PurchaseDAO pu=new PurchaseImplementation();
public int addPurchaseDetails(Purchase p) throws Exception
{
	
	return pu.addPurchaseDetails(p);
	}
public int amountCalculation(int productId,int purchaseId) throws Exception
{
	return pu.amountCalculation(productId, purchaseId);
	}

}
