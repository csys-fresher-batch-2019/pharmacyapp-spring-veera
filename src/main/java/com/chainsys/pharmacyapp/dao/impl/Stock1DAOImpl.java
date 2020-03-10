package com.chainsys.pharmacyapp.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chainsys.pharmacyapp.Exception.DbException;
import com.chainsys.pharmacyapp.Exception.InfoMessages;
import com.chainsys.pharmacyapp.dao.Stock1DAO;
import com.chainsys.pharmacyapp.model.Stock1;
import com.chainsys.pharmacyapp.util.TestConnection;

@Repository
public class Stock1Implementation implements Stock1DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(Stock1Implementation.class);

	public int addStockDetails(Stock1 s) throws Exception {

		String sql = "insert into stock1(stock_id,stock_date,product_id,opening_stock,purchase_quantity,sales_quantity,closing_stock)  values (stock_id.nextval,SYSDATE,?,?,?,?)";
		try (Connection c1 = TestConnection.getConnection(); PreparedStatement stmp = c1.prepareStatement(sql);) {
			int row = stmp.executeUpdate();
			stmp.setInt(1, s.getProductId());
			stmp.setInt(2, s.getOpeningStock());
			stmp.setInt(3, s.getPurchaseQuantity());
			stmp.setInt(4, s.getSalesQuantity());
			LOGGER.info("row");
			return row;
		} catch (SQLException e2) {
			e2.printStackTrace();
			throw new DbException(InfoMessages.lOGIN);
		}
	}

	public int updateClosingStock(Stock1 s) throws Exception {
		try (Connection con = TestConnection.getConnection();
				CallableStatement stmt = con.prepareCall("{call CLOSINGSTOCK (?)}");) {
			stmt.setInt(1, s.getStockId());
			stmt.execute();
			return 0;
		} catch (SQLException e2) {
			e2.printStackTrace();
			throw new DbException(InfoMessages.UPDATECLOSINGSTOCK);
		}

	}

	@Override
	public int updateOpeningStock(int stockId) throws Exception {
		String sql = "update stock1 set opening_stock=closing_stock where stock_id=?";
		try (Connection con = TestConnection.getConnection(); PreparedStatement stmp = con.prepareStatement(sql);) {
			Stock1 o = new Stock1();
			stmp.setInt(1, o.getStockId());
			int row = stmp.executeUpdate();
			LOGGER.info("row");
			return row;
		} catch (SQLException e2) {
			e2.printStackTrace();
			throw new DbException(InfoMessages.UPDATEOPENINGSTOCK);
		}

	}
}
