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
import com.chainsys.pharmacyapp.model.Company;
import com.chainsys.pharmacyapp.util.ConnectionUtil;

@Repository
public class CompanyDAOImpl implements CompanyDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(CompanyDAOImpl.class);

	public int saveCompanyDetails(Company p) throws Exception {
		int n = 0;
		String sql = "Insert into company( company_id, company_name, company_type,company_address) values (?,?,?,?)";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, p.getCompanyId());
			pst.setString(2, p.getCompanyName());
			pst.setString(3, p.getCompanyType());
			pst.setString(4, p.getCompanyAddress());
			n = pst.executeUpdate();
		} catch (SQLException e2) {
			LOGGER.debug(e2.getMessage());
			throw new DbException(InfoMessages.INVALID_COMPANY);
		}
		return n;
	}
}
