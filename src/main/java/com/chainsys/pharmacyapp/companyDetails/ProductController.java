package com.chainsys.pharmacyapp.companyDetails;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.pharmacyapp.productDetails.Product;
import com.chainsys.pharmacyapp.productDetails.ProductDAO;
import com.chainsys.pharmacyapp.productDetails.ProductImplementation;

@RestController
@RequestMapping("api")
public class ProductController {

	@GetMapping("/displayProduct")
	public List<Product> displayProduct() throws Exception {
		ProductDAO obj = new ProductImplementation();
		return obj.displayProduct();
	}

}
