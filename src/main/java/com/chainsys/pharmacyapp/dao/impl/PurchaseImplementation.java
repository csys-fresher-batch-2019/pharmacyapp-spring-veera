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
import com.chainsys.pharmacyapp.dao.PurchaseDAO;
import com.chainsys.pharmacyapp.model.Purchase;
import com.chainsys.pharmacyapp.util.TestConnection;

@Repository
public class PurchaseImplementation implements PurchaseDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(PurchaseImplementation.class);

	public int addPurchaseDetails(Purchase p) throws Exception {
		String sql = "insert into purchase(purchase_id,product_id,purchase_date,company_id,purchase_quantity,amount) values(purchase_id.nextval,"
				+ p.getProductId() + ",SYSDATE," + p.getCompanyId() + "," + p.getPurchaseQuantity() + ","
				+ p.getAmount() + ")";
		try (Connection con = TestConnection.getConnection(); Statement stmt = con.createStatement();) {
			int row = stmt.executeUpdate(sql);
			LOGGER.info("row");
			return row;
		} catch (SQLException e2) {
			e2.printStackTrace();

			throw new DbException(InfoMessages.PURCHASE);
		}
	}

	public int amountCalculation(int productId, int purchaseId) throws Exception {
		String sql = "select purchase_quantity from purchase where purchase_id = ?";
		try (Connection con = TestConnection.getConnection(); 
				PreparedStatement stmt = con.prepareStatement(sql);) {
			stmt.setInt(1, productId);

			int quantity = 0, co = 0;
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				quantity = rs.getInt("purchase_quantity");// coloumn number
				LOGGER.info("quantity");
			}
			String sql1 = "select cost from product where product_id = ?";
			try (Connection con1 = TestConnection.getConnection(); PreparedStatement stmt1 = con.prepareStatement(sql1);) {
				stmt1.setInt(1, productId);
				ResultSet rs1 = stmt1.executeQuery();
				if (rs1.next()) {
					co = rs1.getInt("cost");
					LOGGER.info("co");
				}
				LOGGER.info("amount");

				int amount = co * quantity;
				String sql2 = "update purchase set amount = ? where purchase_id = ?";
				try (Connection con2 = TestConnection.getConnection();  PreparedStatement stmt2 = con.prepareStatement(sql2);) {
					stmt2.setInt(1, amount);
					stmt2.setInt(2, purchaseId);
					int row = stmt2.executeUpdate();
					LOGGER.info(sql2);
					LOGGER.info("row");
					return row;
				}
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
			throw new DbException(InfoMessages.CONNECTION);
		}
	}
}
