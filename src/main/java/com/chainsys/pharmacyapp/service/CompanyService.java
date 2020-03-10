package com.chainsys.pharmacyapp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.pharmacyapp.dao.CompanyDAO;
import com.chainsys.pharmacyapp.dao.impl.CompanyImplementation;
import com.chainsys.pharmacyapp.model.CompanyModel;

public class companyService {

	CompanyDAO co = new CompanyImplementation();

	public int addCompanyDetails(CompanyModel p) throws Exception {
		return co.addCompanyDetails(p);

	}

}
