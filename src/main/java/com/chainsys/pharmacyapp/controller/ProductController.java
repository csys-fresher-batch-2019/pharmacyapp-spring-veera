package com.chainsys.pharmacyapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.pharmacyapp.dao.ProductDAO;
import com.chainsys.pharmacyapp.dao.impl.ProductImplementation;
import com.chainsys.pharmacyapp.model.Product;

@RestController
@RequestMapping("api")
public class ProductController {

	@GetMapping("/displayProduct")
	public List<Product> displayProduct() throws Exception {
		ProductDAO obj = new ProductImplementation();
		return obj.displayProduct();
	}
	
	@PostMapping("/addProdutcDetails")
	public int addProductDetails(@RequestParam("product_id") int productId,@RequestParam("product_name") String productName,@RequestParam("product_type") String productType,@RequestParam("cost") int cost) throws Exception
	{
		ProductDAO obj = new ProductImplementation();
          Product p =new Product();
          p.setProductId(productId);
          p.setProductName(productName);
          p.setProductType(productType);
          p.setCost(cost);
		return  obj.addProductDetails(p);
		}
//	@PostMapping("/AdminLogin")
//	public boolean AdminLogin(@RequestParam("adminname") String Adminname,@RequestParam("Pass") String pass) throws Exception
//	{  
//		AdminDAO ob=new AdminDAOImplementation();
//		
//		return ob.AdminLogin(Adminname, pass);
//		}
	}
			



