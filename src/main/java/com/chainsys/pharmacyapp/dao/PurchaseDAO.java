package com.chainsys.pharmacyapp.purchaseDetails;

public interface PurchaseDAO {
void addPurchaseDetails(PurchaseDAO p) throws Exception;
int amountCalculation(int productId,int purchaseId);
}
