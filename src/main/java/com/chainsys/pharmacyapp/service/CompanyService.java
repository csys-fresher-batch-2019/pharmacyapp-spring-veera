package com.chainsys.pharmacyapp.service;


import com.chainsys.pharmacyapp.dao.CompanyDAO;
import com.chainsys.pharmacyapp.dao.impl.CompanyDAOImpl;
import com.chainsys.pharmacyapp.model.CompanyModel;

public class CompanyService {

	CompanyDAO co = new CompanyDAOImpl();

	public int save(CompanyModel p) throws Exception {
		return co.saveCompanyDetails(p);

	}

}
