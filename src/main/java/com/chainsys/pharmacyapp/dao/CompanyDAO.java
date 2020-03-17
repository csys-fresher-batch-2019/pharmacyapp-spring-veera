package com.chainsys.pharmacyapp.dao;

import com.chainsys.pharmacyapp.model.Company;

//interface
public interface CompanyDAO {
	// @SqlUpdate("Insert into company( company_id, company_name,
	// company_type,company_address) values (?,?,?,?)")
	public int saveCompanyDetails(Company p) throws Exception;

}
