package com.chainsys.pharmacyapp.controller;

import java.sql.Date;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.pharmacyapp.dao.SalesDAO;
import com.chainsys.pharmacyapp.dao.impl.SalesDAOImpl;
import com.chainsys.pharmacyapp.model.Sales;

@RestController
@RequestMapping("api")
public class SalesController {

	SalesDAO dao = new SalesDAOImpl();

	@PostMapping("/saveSales")

	public int saveSales(@RequestParam("sales_id") int salesId, @RequestParam("product_id") int productId,
			@RequestParam("sales_date") Date salesDate, @RequestParam("sales_quantity") int salesQuantity,
			@RequestParam("amount") int amount) throws Exception {
		Sales s = new Sales();
		s.setSalesId(salesId);
		s.setProductId(productId);
		s.setSalesDate(salesDate);
		s.setSalesQuantity(salesQuantity);
		s.setAmount(amount);

		return dao.saveSales(s);

	}

	@PostMapping("/amountCalAfterSales")

	public int amountCalAfterSales(@RequestParam("product_id") int productId, @RequestParam("sales_id") int salesId)
			throws Exception {
		Sales s = new Sales();
		s.setProductId(productId);
		s.setSalesId(salesId);
		return dao.amountCalAfterSales(productId, salesId);

	}
}
