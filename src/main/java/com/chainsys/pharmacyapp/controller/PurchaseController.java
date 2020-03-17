package com.chainsys.pharmacyapp.controller;

import java.sql.Date;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.pharmacyapp.dao.PurchaseDAO;
import com.chainsys.pharmacyapp.dao.impl.PurchaseDAOImpl;
import com.chainsys.pharmacyapp.model.Purchase;

@RestController
@RequestMapping("api")
public class PurchaseController {

	PurchaseDAO dao = new PurchaseDAOImpl();

	@PostMapping("/save")
	public int save(@RequestParam("purchase_id") int purchaseId, @RequestParam("product_id") int productId,
			@RequestParam("purchase_date") Date purchaseDate, @RequestParam("company_id") int companyId,
			@RequestParam("purchase_quantity") int purchaseQuantity, @RequestParam("amount") int amount)
			throws Exception {
		Purchase pu = new Purchase();
		pu.setPurchaseId(purchaseId);
		pu.setProductId(productId);
		pu.setPurchaseDate(purchaseDate);
		pu.setCompanyId(companyId);
		pu.setPurchaseQuantity(purchaseQuantity);
		pu.setAmount(amount);
		return dao.amountCalculation(productId, purchaseId);

	}

	@PostMapping("/amountCalculation")

	public int amountCalculation(int productId, int purchaseId) throws Exception {
		Purchase pu = new Purchase();
		pu.setPurchaseId(purchaseId);
		pu.setProductId(productId);
		return dao.amountCalculation(productId, purchaseId);
	}
}
