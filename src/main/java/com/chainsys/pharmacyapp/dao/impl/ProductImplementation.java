package com.chainsys.pharmacyapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.chainsys.pharmacyapp.dao.ProductDAO;
import com.chainsys.pharmacyapp.model.Product;
import com.chainsys.pharmacyapp.util.TestConnection;
@Repository
public class ProductImplementation implements ProductDAO {

	public int addProductDetails(Product p) throws Exception {
		//Date date = Date.valueOf(p.getExpiryDate());
		java.sql.Date date=java.sql.Date.valueOf(p.getExpiryDate());
		String sql = "insert into product(product_id,product_name,product_type,cost,quantity,expiry_date) " + "values("
				+ p.getProductId() + ",'" + p.getProductName() + "','" + p.getProductType() + "','" + p.getCost() + "','"+p.getQuantity()+"',to_date('"+date+"','yyyy-MM-DD'))";
	System.out.println(sql);
		Connection c1 = TestConnection.getConnection();
		Statement stmt = c1.createStatement();
		int row = stmt.executeUpdate(sql);
		System.out.println(row);
		return row;
		 

	}

	public int updateProductType(int pId, String pT) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update product set product_type=? where product_id=?";
		Connection con = TestConnection.getConnection();
		PreparedStatement stmp = con.prepareStatement(sql);
		stmp.setString(1, pT);
		stmp.setInt(2, pId);
		System.out.println(sql);
		int row = stmp.executeUpdate();
		System.out.println(row);
		return row;

	}

	public int updateCost(int proId, int cost) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update product set cost=? where product_id=?";
		Connection con = TestConnection.getConnection();
		PreparedStatement stmp = con.prepareStatement(sql);
		stmp.setInt(1, cost);
		stmp.setInt(2, proId);
		System.out.println(sql);
		int pr = stmp.executeUpdate();
		System.out.println(pr);
		return pr;

	}

	public ArrayList<Product> displayProduct() throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from product";
		ResultSet rs;
		Connection con = TestConnection.getConnection();
		Statement stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		rs.next();

		ArrayList<Product> out = new ArrayList<Product>();
		while (rs.next()) {
			Product obj = new Product();
			obj.setProductId(rs.getInt("product_id"));
			obj.setProductName(rs.getString("product_name"));
			obj.setProductType(rs.getString("product_type"));
			obj.setCost(rs.getInt("cost"));
			obj.setQuantity(rs.getInt("quantity"));
			obj.setExpiryDate(rs.getDate("expiry_date").toLocalDate());
			out.add(obj);
			
			
		}
		for (Product P1 : out) {
			System.out.print("ProductId: " + P1.getProductId() + ", ProductName: " + P1.getProductName() + ", ProductType: "
						+ P1.getProductType() + ",Cost: " + P1.getCost() + ",ExpiryDate " + P1.getExpiryDate() + "\n");

				}
		return out;
	}

	public ArrayList<Product> selectProductId(int numb) throws Exception {
		
		String sql = "select product_id, product_name,product_type,cost,quantity,expiry_date from product where product_id=?";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		// Connection con =
		// DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system",
		// "oracle");
		Connection con = TestConnection.getConnection();
		//System.out.println(con);
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
		System.out.print("ProductId: " + P1.getProductId() + ", ProductName: " + P1.getProductName() + ", ProductType: "
					+ P1.getProductType() + ",Cost: " + P1.getCost() + ",ExpiryDate " + P1.getExpiryDate() + "\n");

			}
		return out;
	}

	
}
