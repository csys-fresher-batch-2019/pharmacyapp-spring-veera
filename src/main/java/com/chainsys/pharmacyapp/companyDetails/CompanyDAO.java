package com.chainsys.pharmacyapp.companyDetails;

import org.jdbi.v3.sqlobject.statement.SqlUpdate;

//interface
public interface CompanyDAO
{	//public boolean AdminLogin(String Adminname, String pass) throws Exception;
	//@SqlUpdate("Insert into company( company_id, company_name, company_type,company_address) values (?,?,?,?)")
	int addCompanyDetails(CompanyModel p)throws Exception;
	
   }