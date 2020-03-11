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
import com.chainsys.pharmacyapp.dao.OrderDAO;
import com.chainsys.pharmacyapp.model.Order;
import com.chainsys.pharmacyapp.util.ConnectionUtil;

@Repository

public class OrderDAOImpl implements OrderDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderDAOImpl.class);

	public void save(Order O) throws Exception {

		String sql = "insert into orderdetail(order_id,user_name,product_name,product_id,quantity,Email_id,contact)  values(order_id.nextval,?,?,?,?,?,?)";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement stmp = con.prepareStatement(sql);) {
			stmp.setString(1, O.getUserName());
			stmp.setString(2, O.getProductName());
			stmp.setInt(3, O.getProductId());
			stmp.setInt(4, O.getQuantity());
			stmp.setString(5, O.getEmailId());
			stmp.setLong(6, O.getContact());
			stmp.executeUpdate();
		} catch (SQLException e2) {
			throw new DbException(InfoMessages.INVALID_ORDER);
		}
	}

	public ArrayList<Order> displayOrderDetails() throws Exception {
		String sql = "select * from orderdetail";
		try (Connection con = ConnectionUtil.getConnection(); Statement pst = con.createStatement();) {
			try (ResultSet rs = pst.executeQuery(sql);) {
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
				for (Order O : out) {
					LOGGER.info("OrderId: " + O.getOrderId() + ",UserName: " + O.getUserName() + ",ProductName: "
							+ O.getProductName() + ",Quantity: " + O.getQuantity() + ",EmailId:" + O.getEmailId()
							+ ",Contact:" + O.getContact() + "\n");
				}
				return out;
			} catch (Exception e3) {
				throw new DbException(InfoMessages.INVALID_ORDERDISPLAY);
			}
		} catch (SQLException e2) {
			throw new DbException(InfoMessages.CONNECTION);

		}
	}
}
