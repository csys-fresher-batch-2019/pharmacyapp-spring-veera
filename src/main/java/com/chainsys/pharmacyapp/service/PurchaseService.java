package com.chainsys.pharmacyapp.service;

import com.chainsys.pharmacyapp.dao.PurchaseDAO;
import com.chainsys.pharmacyapp.dao.impl.PurchaseDAOImpl;
import com.chainsys.pharmacyapp.model.Purchase;

public class PurchaseService {
	PurchaseDAO pu = new PurchaseDAOImpl();

	public int save(Purchase p) throws Exception {

		return pu.save(p);
	}

	public int amountCalculation(int productId, int purchaseId) throws Exception {
		return pu.amountCalculation(productId, purchaseId);
	}

}
