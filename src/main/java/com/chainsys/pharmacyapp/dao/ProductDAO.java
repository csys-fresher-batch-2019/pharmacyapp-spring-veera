package com.chainsys.pharmacyapp.dao;

import java.util.ArrayList;

import com.chainsys.pharmacyapp.model.Product;

//write methods using table name
public interface ProductDAO {

	public int save(Product p) throws Exception;

	public int updateProductType(int productId, String productType) throws Exception;

	public int updateCost(int proId, int cost) throws Exception;

	public ArrayList displayProduct() throws Exception;

	public ArrayList selectProductId(int d2) throws Exception;

}
