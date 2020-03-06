package com.chainsys.pharmacyapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chainsys.pharmacyapp.Exception.DbException;
import com.chainsys.pharmacyapp.Exception.InfoMessages;
import com.chainsys.pharmacyapp.dao.ProductDAO;
import com.chainsys.pharmacyapp.model.Product;
import com.chainsys.pharmacyapp.util.TestConnection;

@Repository
public class ProductImplementation implements ProductDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductImplementation.class);

	public int addProductDetails(Product p) throws Exception {
		// Date date = Date.valueOf(p.getExpiryDate());
		java.sql.Date date = java.sql.Date.valueOf(p.getExpiryDate());
		String sql = "insert into product(product_id,product_name,product_type,cost,quantity,expiry_date) " + "values("
				+ p.getProductId() + ",'" + p.getProductName() + "','" + p.getProductType() + "','" + p.getCost()
				+ "','" + p.getQuantity() + "',to_date('" + date + "','yyyy-MM-DD'))";
		try(Connection c1 = TestConnection.getConnection();
		Statement stmt = c1.createStatement();)
		{
		int row = stmt.executeUpdate(sql);
		LOGGER.info("row");
		return row;
		}catch (SQLException e2) {
			throw new DbException(InfoMessages.ADDPRODUCT);
		}

		

	}

	public int updateProductType(int pId, String pT) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update product set product_type=? where product_id=?";
		try (Connection con = TestConnection.getConnection(); PreparedStatement stmp = con.prepareStatement(sql);) {
			stmp.setString(1, pT);
			stmp.setInt(2, pId);
			int row = stmp.executeUpdate();
			LOGGER.info("row");
			return row;
		} catch (SQLException e2) {
			throw new DbException(InfoMessages.PRODUCTUPDATETYPE);
		}

	}

	public int updateCost(int proId, int cost) throws Exception {
		String sql = "update product set cost=? where product_id=?";
		try (Connection con = TestConnection.getConnection(); PreparedStatement stmp = con.prepareStatement(sql);) {
			stmp.setInt(1, cost);
			stmp.setInt(2, proId);
			int pr = stmp.executeUpdate();
			LOGGER.info("pr");
			return pr;
		} catch (SQLException e2) {
			throw new DbException(InfoMessages.UPDATECOST);
		}

	}

	public ArrayList<Product> displayProduct() throws Exception {
		String sql = "select * from product";
		try (Connection con = TestConnection.getConnection(); Statement stmt = con.createStatement();) {
			try (ResultSet rs = stmt.executeQuery(sql);) {
				rs.next();

				ArrayList<Product> out = new ArrayList<>();
				while (rs.next()) {
					Product obj = new Product();

					obj.setProductId(rs.getInt("product_id"));
					obj.setProductName(rs.getString("product_name"));
					obj.setProductType(rs.getString("product_type"));
					obj.setCost(rs.getInt("cost"));
					obj.setQuantity(rs.getInt("quantity"));
					obj.setExpiryDate(rs.getDate("expiry_date").toLocalDate());

					out.add(obj);
					return out;
				}
			}
		} catch (SQLException e2) {
			throw new DbException(InfoMessages.DISPLAYPRODUCT);
		}
		return null;

	}

	public ArrayList<Product> selectProductId(int numb) throws Exception {

		String sql = "select product_id, product_name,product_type,cost,quantity,expiry_date from product where product_id=?";

		try (Connection con = TestConnection.getConnection();) {
			Product obj = new Product();
			PreparedStatement stmp = con.prepareStatement(sql);
			stmp.setInt(1, numb);
			ResultSet rs = stmp.executeQuery();
			ArrayList<Product> out = new ArrayList<Product>();
			while (rs.next()) {

				obj.setProductId(rs.getInt("product_id"));
				obj.setProductName(rs.getString("product_name"));
				obj.setProductType(rs.getString("product_type"));
				obj.setCost(rs.getInt("cost"));
				obj.setQuantity(rs.getInt("quantity"));
				obj.setExpiryDate(rs.getDate("expiry_date").toLocalDate());

				out.add(obj);
			}
			for (Product P1 : out) {
				System.out.print("ProductId: " + P1.getProductId() + ", ProductName: " + P1.getProductName()
						+ ", ProductType: " + P1.getProductType() + ",Cost: " + P1.getCost() + ",ExpiryDate "
						+ P1.getExpiryDate() + "\n");

			}
			return out;
		} catch (SQLException e2) {
			throw new DbException(InfoMessages.SELECTPRODUCT);
		}
	}
}

		
		
