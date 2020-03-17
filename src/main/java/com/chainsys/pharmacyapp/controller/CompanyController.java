package com.chainsys.pharmacyapp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.pharmacyapp.dao.CompanyDAO;
import com.chainsys.pharmacyapp.dao.impl.CompanyDAOImpl;
import com.chainsys.pharmacyapp.model.Company;

@RestController
@RequestMapping("api")
public class CompanyController {
	CompanyDAO com = new CompanyDAOImpl();

	@PostMapping("/saveCompanyDetails")
	public int saveCompanyDetails(@RequestParam("company_id") int companyId,
			@RequestParam("company_name") String companyName, @RequestParam("company_type") String companyType,
			@RequestParam("company_address") String companyAddress) throws Exception {
		Company co = new Company();
		co.setCompanyId(companyId);
		co.setCompanyName(companyName);
		co.setCompanyType(companyType);
		co.setCompanyAddress(companyAddress);
		return com.saveCompanyDetails(co);

	}

}
