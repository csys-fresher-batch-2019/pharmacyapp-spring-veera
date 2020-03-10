package com.chainsys.pharmacyapp.dao;

import com.chainsys.pharmacyapp.model.Purchase;

public interface PurchaseDAO {
	public int addPurchaseDetails(Purchase p) throws Exception;

	public int amountCalculation(int productId, int purchaseId) throws Exception;
}
