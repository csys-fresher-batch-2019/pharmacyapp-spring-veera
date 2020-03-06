package com.chainsys.pharmacyapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.springframework.stereotype.Repository;

import com.chainsys.pharmacyapp.Exception.DbException;
import com.chainsys.pharmacyapp.Exception.InfoMessages;
import com.chainsys.pharmacyapp.dao.UserDAO;
import com.chainsys.pharmacyapp.model.UserDetails;
import com.chainsys.pharmacyapp.util.TestConnection;

@Repository
public class UserDAOImplementation implements UserDAO {
	static Scanner sc = new Scanner(System.in);

	public int addUserDetails(UserDetails p) throws Exception
	{
		String sql = "insert into UserRegister(name,Email_id,password,contact) values (?,?,?,?)";
		try (Connection con = TestConnection.getConnection(); PreparedStatement stmp = con.prepareStatement(sql);) {
			stmp.setString(1, p.getName());
			stmp.setString(2, p.getEmailId());
			stmp.setString(3, p.getPassword());
			stmp.setLong(4, p.getContact());
			int row = stmp.executeUpdate();
			return row;
		} catch (SQLException e2) {
			e2.printStackTrace();
			throw new DbException(InfoMessages.lOGIN);
		}
	}

	public boolean user(String name, String password) throws Exception {

		String sql = "select password from UserRegister where name=(select name from UserRegister where name='" + name
				+ "')";
		try (Connection con = TestConnection.getConnection(); Statement stmt = con.createStatement();) {
			ResultSet rs1 = stmt.executeQuery(sql);
			if (rs1.next()) {
				String pass = rs1.getString("password");
				// System.out.println(pass);
				if (password.equals(pass)) {
					return true;
				}
			}
			return false;
		} catch (SQLException e2) {
			e2.printStackTrace();
			throw new DbException(InfoMessages.lOGIN);
		}

	}
}
