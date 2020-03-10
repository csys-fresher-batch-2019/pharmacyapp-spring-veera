package com.chainsys.pharmacyapp.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chainsys.pharmacyapp.Exception.DbException;
import com.chainsys.pharmacyapp.Exception.InfoMessages;
import com.chainsys.pharmacyapp.dao.Stock1DAO;
import com.chainsys.pharmacyapp.model.Stock1;
import com.chainsys.pharmacyapp.util.ConnectionUtil;

@Repository
public class Stock1DAOImpl implements Stock1DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(Stock1DAOImpl.class);

	public int save(Stock1 s) throws Exception {

		String sql = "insert into stock1(stock_id,stock_date,product_id,opening_stock,purchase_quantity,sales_quantity,closing_stock)  values (stock_id.nextval,SYSDATE,?,?,?,?)";
		try (Connection c1 = ConnectionUtil.getConnection(); PreparedStatement stmp = c1.prepareStatement(sql);) {
			int row = stmp.executeUpdate();
			stmp.setInt(1, s.getProductId());
			stmp.setInt(2, s.getOpeningStock());
			stmp.setInt(3, s.getPurchaseQuantity());
			stmp.setInt(4, s.getSalesQuantity());
			LOGGER.info("row");
			return row;
		} catch (SQLException e2) {
			e2.printStackTrace();
			throw new DbException(InfoMessages.INVALID_lOGIN);
		}
	}

	public int updateClosingStock(Stock1 s) throws Exception {
		try (Connection con = ConnectionUtil.getConnection();
				CallableStatement pst = con.prepareCall("{call CLOSINGSTOCK (?)}");) {
			pst.setInt(1, s.getStockId());
			pst.execute();
			return 0;
		} catch (SQLException e2) {
			e2.printStackTrace();
			throw new DbException(InfoMessages.INVALID_UPDATECLOSINGSTOCK);
		}

	}

	@Override
	public int updateOpeningStock(int stockId) throws Exception {
		String sql = "update stock1 set opening_stock=closing_stock where stock_id=?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst1 = con.prepareStatement(sql);) {
			Stock1 o = new Stock1();
			pst1.setInt(1, o.getStockId());
			int row = pst1.executeUpdate();
			LOGGER.info("row");
			return row;
		} catch (SQLException e2) {
			e2.printStackTrace();
			throw new DbException(InfoMessages.INVALID_UPDATEOPENINGSTOCK);
		}

	}
}
