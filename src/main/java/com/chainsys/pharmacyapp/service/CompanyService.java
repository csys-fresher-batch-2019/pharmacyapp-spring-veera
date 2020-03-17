package com.chainsys.pharmacyapp.service;

import com.chainsys.pharmacyapp.dao.CompanyDAO;
import com.chainsys.pharmacyapp.dao.impl.CompanyDAOImpl;
import com.chainsys.pharmacyapp.model.Company;

public class CompanyService {

	CompanyDAO companyDAO = new CompanyDAOImpl();

	public int save(Company p) throws Exception {
		return companyDAO.saveCompanyDetails(p);

	}

}
