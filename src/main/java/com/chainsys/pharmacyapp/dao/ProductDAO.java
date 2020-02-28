package com.chainsys.pharmacyapp.dao;

import java.util.ArrayList;

import com.chainsys.pharmacyapp.model.Product;

//write methods using table name
public interface ProductDAO {
	
	int addProductDetails(Product p) throws Exception;
	int updateProductType( int productId,String productType) throws Exception;
	int updateCost(int proId, int cost) throws Exception;
	ArrayList displayProduct() throws Exception;
	ArrayList selectProductId(int d2) throws Exception;

}
