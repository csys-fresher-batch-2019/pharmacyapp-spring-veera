package com.chainsys.pharmacyapp.dao;

import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import com.chainsys.pharmacyapp.model.CompanyModel;

//interface
public interface CompanyDAO { // public boolean AdminLogin(String Adminname, String pass) throws Exception;
								// @SqlUpdate("Insert into company( company_id, company_name,
								// company_type,company_address) values (?,?,?,?)")
	public int addCompanyDetails(CompanyModel p) throws Exception;

}
