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
import com.chainsys.pharmacyapp.dao.PurchaseDAO;
import com.chainsys.pharmacyapp.model.Purchase;
import com.chainsys.pharmacyapp.util.ConnectionUtil;

@Repository
public class PurchaseDAOImpl implements PurchaseDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(PurchaseDAOImpl.class);

	public int save(Purchase p) throws Exception {

		String sql = "insert into purchase(purchase_id,product_id,purchase_date,company_id,purchase_quantity,amount) values(purchase_id.nextval,?,SYSDATE,?,?,?)";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement stmp = con.prepareStatement(sql);) {
			stmp.setInt(1, p.getProductId());
			stmp.setInt(2, p.getCompanyId());
			stmp.setInt(3, p.getPurchaseQuantity());
			stmp.setInt(4, p.getAmount());
			int row = stmp.executeUpdate();

			LOGGER.info("sql");
			return row;
		} catch (SQLException e2) {
			e2.printStackTrace();
			throw new DbException(InfoMessages.INVALID_PURCHASE);
		}
	}

	public int amountCalculation(int productId, int purchaseId) throws Exception {
		String sql = "select purchase_quantity from purchase where purchase_id = ?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, productId);

			int quantity = 0, co = 0;
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				quantity = rs.getInt("purchase_quantity");// coloumn number
				LOGGER.info("quantity");
			}
			String sql1 = "select cost from product where product_id = ?";
			try (Connection con1 = ConnectionUtil.getConnection();
					PreparedStatement stmt1 = con.prepareStatement(sql1);) {
				stmt1.setInt(1, productId);
				ResultSet rs1 = stmt1.executeQuery();
				if (rs1.next()) {
					co = rs1.getInt("cost");
					LOGGER.info("co");
				}
				LOGGER.info("amount");

				int amount = co * quantity;
				String sql2 = "update purchase set amount = ? where purchase_id = ?";
				try (Connection con2 = ConnectionUtil.getConnection();
						PreparedStatement stmt2 = con.prepareStatement(sql2);) {
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
