package com.chainsys.pharmacyapp.stock1Details;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.chainsys.pharmacyapp.companyDetails.TestConnection;

import java.sql.SQLException;

public class Stock1Implementation implements Stock1DAO {

	public int addStockDetails(Stock1 s) throws Exception {
		String sql = "insert into stock1(stock_id,stock_date,product_id,opening_stock,purchase_quantity,sales_quantity,closing_stock)  values (stock_id.nextval,SYSDATE,"
				+ s.getProductId() + "," + s.getOpeningStock() + "," + s.getPurchaseQuantity() + ","
				+ s.getSalesQuantity() + "," + s.getClosingStock() + ")";
		Connection c1 = TestConnection.getConnection();
		Statement stmt = c1.createStatement();
		int row = stmt.executeUpdate(sql);
		System.out.println(row);
		return row;
	}

	public int updateClosingStock(Stock1 s) throws Exception {
		//Stock1 s = new Stock1();
		Connection con = TestConnection.getConnection();
		CallableStatement stmt = con.prepareCall("{call CLOSINGSTOCK (?)}");
		// PreparedStatement stmp = con.prepareStatement(sql);
		stmt.setInt(1, s.getStockId());
		 stmt.execute();
		return 0;
		
	}

	@Override
	public int  updateOpeningStock(int stockId) throws Exception {
		Stock1 o = new Stock1();
		String sql = "update stock1 set opening_stock=closing_stock where stock_id=?";
		Connection con = TestConnection.getConnection();
		PreparedStatement stmp = con.prepareStatement(sql);
		stmp.setInt(1, o.getStockId());
		int row = stmp.executeUpdate();
		System.out.println(row);
		return row;

	}

}
