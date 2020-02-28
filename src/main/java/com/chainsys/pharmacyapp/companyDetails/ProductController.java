package com.chainsys.pharmacyapp.companyDetails;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.pharmacyapp.dao.AdminDAO;
import com.chainsys.pharmacyapp.dao.ProductDAO;
import com.chainsys.pharmacyapp.daoImplementation.AdminDAOImplementation;
import com.chainsys.pharmacyapp.daoImplementation.ProductImplementation;
import com.chainsys.pharmacyapp.model.Product;

@RestController
@RequestMapping("api")
public class ProductController {

	@GetMapping("/displayProduct")
	public List<Product> displayProduct() throws Exception {
		ProductDAO obj = new ProductImplementation();
		return obj.displayProduct();
	}

	@PostMapping("/AdminLogin")
	public boolean AdminLogin(@RequestParam("adminname") String Adminname,@RequestParam("Pass") String pass) throws Exception
	{  
		AdminDAO ob=new AdminDAOImplementation();
		
		return ob.AdminLogin(Adminname, pass);
		}
	}
			



