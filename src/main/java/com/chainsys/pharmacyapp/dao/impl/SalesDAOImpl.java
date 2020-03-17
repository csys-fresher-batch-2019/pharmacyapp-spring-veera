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
import com.chainsys.pharmacyapp.util.ConnectionUtil;

@Repository

public class SalesDAOImpl implements SalesDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(SalesDAOImpl.class);

	@Override
	public int saveSales(Sales se) throws Exception {
		//
		// String sql = "insert into
		// sales(sales_id,product_id,sales_date,sales_quantity,amount) values ("
		// + se.getSalesId() + "," + se.getProductId() + ",SYSDATE," +
		// se.getSalesQuantity() + "," + se.getAmount()
		// + ")";

		String sql = "insert into sales(sales_id,product_id,sales_date,sales_quantity,amount) values (?,?,SYSDATE,?,?)";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement stmp = con.prepareStatement(sql);) {
			stmp.setInt(1, se.getSalesId());
			stmp.setInt(2, se.getProductId());
			stmp.setInt(3, se.getSalesQuantity());
			stmp.setInt(4, se.getAmount());
			int row = stmp.executeUpdate();
			return row;
		} catch (SQLException e2) {
			LOGGER.debug(e2.getMessage());
			e2.printStackTrace();
			throw new DbException(InfoMessages.CONNECTION);
		}

	}

	@Override
	public int amountCalAfterSales(int productId, int salesId) throws Exception {
		String sql = "Select cost from product where product_id=" + productId + "";
		try (Connection con = ConnectionUtil.getConnection(); Statement stmt = con.createStatement();) {
			try (ResultSet rs = stmt.executeQuery(sql);) {
				rs.next();

				int p1 = rs.getInt(1);
				System.out.println(p1);
				String sql1 = "select sales_quantity from sales where sales_id=" + salesId + "";
				LOGGER.info(sql1);
				// ResultSet rs1;
				int co = 0;
				try (Connection con1 = ConnectionUtil.getConnection(); Statement pst1 = con1.createStatement();) {
					try (ResultSet rs1 = pst1.executeQuery(sql1);) {
						if (rs1.next()) {
							co = rs1.getInt(1);
						}
						LOGGER.info("co");
						int amount = p1 * co;
						LOGGER.info("amount");
						String sql2 = "update sales set amount=" + amount + " where sales_id= " + salesId + "";
						try (Connection con2 = ConnectionUtil.getConnection();
								Statement pst2 = con2.createStatement();) {
							int row = pst2.executeUpdate(sql2);
							return row;
						}
					} catch (Exception e3) {
						LOGGER.debug(e3.getMessage());
						throw new DbException(InfoMessages.INVALID_AMOUNTCALAFTERSALES);
					}

				} catch (SQLException e2) {
					LOGGER.debug(e2.getMessage());
					e2.printStackTrace();
					throw new DbException(InfoMessages.CONNECTION);

				}
			} catch (Exception e3) {
				LOGGER.debug(e3.getMessage());
				throw new DbException(InfoMessages.INVALID_AMOUNTCALAFTERSALES);
			}
		} catch (SQLException e2) {
			LOGGER.debug(e2.getMessage());
			e2.printStackTrace();
			throw new DbException(InfoMessages.CONNECTION);

		}
	}
}
