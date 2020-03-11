package com.chainsys.pharmacyapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chainsys.pharmacyapp.Exception.DbException;
import com.chainsys.pharmacyapp.Exception.InfoMessages;
import com.chainsys.pharmacyapp.dao.AdminDAO;
import com.chainsys.pharmacyapp.util.ConnectionUtil;

@Repository

public class AdminDAOImpl implements AdminDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(PurchaseDAOImpl.class);

	public boolean AdminLogin(String adminname, String pass) throws Exception {
		String sql = "select pass_word from AdminRegister where Admin_name=(select Admin_name from AdminRegister where Admin_name=?)";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, adminname);
			ResultSet rs1 = pst.executeQuery();
			if (rs1.next()) {
				String password = rs1.getString("pass_word");
				if (pass.equals(password)) {
					return true;
				}

			}
		} catch (SQLException e2) {
			LOGGER.error("Ops!", e2);
			throw new DbException(InfoMessages.INVALID_lOGIN);
		}
		return false;
	}
}