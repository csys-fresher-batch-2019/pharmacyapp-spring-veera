package com.chainsys.pharmacyapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.pharmacyapp.dao.ProductDAO;
import com.chainsys.pharmacyapp.dao.impl.ProductDAOImpl;
import com.chainsys.pharmacyapp.model.Product;



@RestController
@RequestMapping("api")
public class ProductController {

	@GetMapping("/displayProduct")
	public List<Product> displayProduct() throws Exception {
		ProductDAO obj = new ProductDAOImpl();
		return obj.displayProduct();
	}

	@PostMapping("/addProductDetails")
	public int addProductDetails(@RequestParam("product_id") int productId,
			@RequestParam("product_name") String productName, @RequestParam("product_type") String productType,
			@RequestParam("cost") int cost) throws Exception {
		ProductDAO obj = new ProductDAOImpl();
		Product p = new Product();
		p.setProductId(productId);
		p.setProductName(productName);
		p.setProductType(productType);
		p.setCost(cost);
		return obj.save(p);
	}
	@PutMapping("/updateProductType")
	public int updateProductType(@RequestParam("product_type") String productType,@RequestParam("product_id") int productId)throws Exception
	{
		ProductDAO obj = new ProductDAOImpl();
		Product po = new Product();
		po.setProductType(productType);
		po.setProductId(productId);
		return obj.updateProductType(productId, productType) ;
	}
	@PutMapping("/updateCost")
	public int updateCost(@RequestParam("Cost")  int cost,@RequestParam("product_id")  int proId) throws Exception
	{
		ProductDAO obj = new ProductDAOImpl();
		Product p = new Product();
		p.setCost(cost);
		p.setProductId(proId);
		return  obj.updateCost(proId, cost);
		
	}

	@GetMapping("/selectProduct")
	public ArrayList<Product> selectProductId(@RequestParam("product_id")  int productId) throws Exception {
		ProductDAO obj = new ProductDAOImpl();
		Product p=new Product();
		p.setProductId(productId);
		return obj.selectProductId(productId);
	}
	
}
