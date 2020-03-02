package com.chainsys.pharmacyapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.chainsys.pharmacyapp.dao.orderDAO;
import com.chainsys.pharmacyapp.model.Order;
import com.chainsys.pharmacyapp.util.TestConnection;


@Repository


public class orderDAOImplementation implements orderDAO{

	public void addorderdetails(Order O) throws Exception 
	{
		// TODO Auto-generated method stub
		
		String sql = "insert into orderdetail(order_id,user_name,product_name,product_id,quantity,Email_id,contact)  values(order_id.nextval,?,?,?,?,?,?)";
		Connection con = TestConnection.getConnection();

		
		System.out.println(con);
		
		
        //orderDAOImplementation o=new orderDAOImplementation();
		//o.addorderdetails(d);
		PreparedStatement stmp = con.prepareStatement(sql);
		//stmp.setInt(1, O.getOrderId());
		stmp.setString(1, O.getUserName());
		stmp.setString(2, O.getProductName());
		stmp.setInt(3, O.getProductId());
		stmp.setInt(4, O.getQuantity());
		stmp.setString(5, O.getEmailId());
		stmp.setLong(6, O.getContact());
//		stmp.setString(7, O.getOrderStatus());
		stmp.executeUpdate();
	
	}
	public ArrayList<Order> displayOrderDetails() throws Exception {
		String sql = "select * from orderdetail";
		ResultSet rs;
		Connection con = TestConnection.getConnection();
		Statement stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		rs.next();

		ArrayList<Order> out = new ArrayList<Order>();
		while (rs.next()) {
			Order obj = new Order();
			obj.setOrderId(rs.getInt("order_id"));
			obj.setUserName(rs.getString("user_name"));
			obj.setProductName(rs.getString("product_name"));
			obj.setQuantity(rs.getInt("quantity"));
			obj.setEmailId(rs.getString("Email_id"));
			obj.setContact(rs.getLong("contact"));
			out.add(obj);
		}
		for (Order O: out)
		{
			System.out.println("OrderId: " + O.getOrderId() + ",UserName: " + O.getUserName()+ ",ProductName: "+ O.getProductName() + ",Quantity: "+ O.getQuantity() + ",EmailId:"+ O.getEmailId()+ ",Contact:"+ O.getContact() + "\n");
		}
		return out;
	}



}
