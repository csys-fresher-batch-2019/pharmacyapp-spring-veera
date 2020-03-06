package com.chainsys.pharmacyapp.dao.impl;
//Test class

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chainsys.pharmacyapp.Exception.DbException;
import com.chainsys.pharmacyapp.Exception.InfoMessages;
import com.chainsys.pharmacyapp.dao.CompanyDAO;
import com.chainsys.pharmacyapp.model.CompanyModel;
import com.chainsys.pharmacyapp.util.TestConnection;

@Repository
public class CompanyImplementation implements CompanyDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(CompanyImplementation.class);

	public int addCompanyDetails(CompanyModel p) throws Exception {
		int n = 0;
		String sql = "Insert into company( company_id, company_name, company_type,company_address) values (?,?,?,?)";
		try (Connection con = TestConnection.getConnection(); PreparedStatement stmp = con.prepareStatement(sql);) {
			stmp.setInt(1, p.getCompanyId());
			stmp.setString(2, p.getCompanyName());
			stmp.setString(3, p.getCompanyType());
			stmp.setString(4, p.getCompanyAddress());
			n = stmp.executeUpdate();
		} catch (SQLException e2) {
			throw new DbException(InfoMessages.COMPANY);
		}
		return n;
	}
}
