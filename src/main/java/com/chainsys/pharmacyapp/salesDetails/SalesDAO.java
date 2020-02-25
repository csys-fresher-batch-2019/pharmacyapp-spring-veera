package com.chainsys.pharmacyapp.salesDetails;

public interface SalesDAO {
int addSalesDetails(Sales se)throws Exception;
int amountCalAfterSales(int productId,int salesId) throws Exception;
}
