package com.chainsys.pharmacyapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chainsys.pharmacyapp.Exception.DbException;
import com.chainsys.pharmacyapp.Exception.InfoMessages;
import com.chainsys.pharmacyapp.dao.SalesDAO;
import com.chainsys.pharmacyapp.model.Sales;
import com.chainsys.pharmacyapp.util.TestConnection;

@Repository

public class SalesImplementation implements SalesDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(SalesImplementation.class);

	public int addSalesDetails(Sales se) throws Exception {
//
//		String sql = "insert into sales(sales_id,product_id,sales_date,sales_quantity,amount) values ("
//				+ se.getSalesId() + "," + se.getProductId() + ",SYSDATE," + se.getSalesQuantity() + "," + se.getAmount()
//				+ ")";

		String sql = "insert into sales(sales_id,product_id,sales_date,sales_quantity,amount) values (?,?,SYSDATE,?,?)";
		try (Connection con = TestConnection.getConnection(); PreparedStatement stmp = con.prepareStatement(sql);) {
			stmp.setInt(1, se.getSalesId());
			stmp.setInt(2, se.getProductId());
			stmp.setInt(3, se.getSalesQuantity());
			stmp.setInt(4, se.getAmount());
			int row = stmp.executeUpdate();
			return row;
		} catch (SQLException e2) {
			e2.printStackTrace();
			throw new DbException(InfoMessages.CONNECTION);
		}

	}

	public int amountCalAfterSales(int productId, int salesId) throws Exception {
		String sql = "Select cost from product where product_id=" + productId + "";
		try (Connection con = TestConnection.getConnection(); Statement stmt = con.createStatement();) {
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();

			int p1 = rs.getInt(1);
			System.out.println(p1);
			String sql1 = "select sales_quantity from sales where sales_id=" + salesId + "";
			LOGGER.info(sql1);
			// ResultSet rs1;
			int co = 0;
			try (Connection con1 = TestConnection.getConnection(); Statement stmt1 = con1.createStatement();) {
				ResultSet rs1 = stmt1.executeQuery(sql1);
				if (rs1.next()) {
					co = rs1.getInt(1);
				}
				LOGGER.info("co");
				int amount = p1 * co;
				LOGGER.info("amount");
				String sql2 = "update sales set amount=" + amount + " where sales_id= " + salesId + "";
				try (Connection con2 = TestConnection.getConnection(); Statement stmt2 = con2.createStatement();) {
					int row = stmt2.executeUpdate(sql2);
					return row;
				}
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
			throw new DbException(InfoMessages.CONNECTION);

		}
	}
}
