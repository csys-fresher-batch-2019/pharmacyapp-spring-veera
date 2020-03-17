package com.chainsys.pharmacyapp.service;

import com.chainsys.pharmacyapp.dao.SalesDAO;
import com.chainsys.pharmacyapp.dao.impl.SalesDAOImpl;
import com.chainsys.pharmacyapp.model.Sales;

public class SalesService {

	SalesDAO salesDAO = new SalesDAOImpl();

	public int saveSales(Sales se) throws Exception {

		return salesDAO.saveSales(se);

	}

	public int amountCalAfterSales(int productId, int salesId) throws Exception {
		return salesDAO.amountCalAfterSales(productId, salesId);

	}

}
