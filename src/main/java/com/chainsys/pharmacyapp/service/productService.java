package com.chainsys.pharmacyapp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.pharmacyapp.dao.ProductDAO;
import com.chainsys.pharmacyapp.dao.impl.ProductImplementation;
import com.chainsys.pharmacyapp.model.Product;

public class productService
{

	ProductDAO pa=new ProductImplementation();
	public int addProductDetails(Product p) throws Exception 
	{
		return pa.addProductDetails(p);
	
		
	}
	public int updateProductType( int productId,String productType) throws Exception
	{
		return pa.updateProductType(productId, productType);
	}
	public int updateCost(int proId, int cost) throws Exception
	{
		return pa.updateCost(proId, cost);}
    public 	ArrayList displayProduct() throws Exception
	{
		return pa.displayProduct();
		}
	public ArrayList selectProductId(int d2) throws Exception
	{
		return pa.selectProductId(d2);
		}

	
}
