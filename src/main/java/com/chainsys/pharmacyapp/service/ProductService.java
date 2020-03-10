package com.chainsys.pharmacyapp.service;

import java.util.ArrayList;

import com.chainsys.pharmacyapp.dao.ProductDAO;
import com.chainsys.pharmacyapp.dao.impl.ProductDAOImpl;
import com.chainsys.pharmacyapp.model.Product;

public class ProductService {

	ProductDAO pa = new ProductDAOImpl();

	public int save(Product p) throws Exception {
		return pa.save(p);

	}

	public int updateProductType(int productId, String productType) throws Exception {
		return pa.updateProductType(productId, productType);
	}

	public int updateCost(int proId, int cost) throws Exception {
		return pa.updateCost(proId, cost);
	}

	public ArrayList displayProduct() throws Exception {
		return pa.displayProduct();
	}

	public ArrayList selectProductId(int d2) throws Exception {
		return pa.selectProductId(d2);
	}

}
