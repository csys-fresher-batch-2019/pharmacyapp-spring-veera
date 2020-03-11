package com.chainsys.pharmacyapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.chainsys.pharmacyapp.Exception.DbException;
import com.chainsys.pharmacyapp.Exception.InfoMessages;

public class ConnectionUtil {

	public static Connection getConnection() throws Exception {
		// TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
		// Connection con =
		// DriverManager.getConnection("jdbc:oracle:thin:@13.235.147.120:1521:XE",
		// "veera", "veera");
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.CONNECTION);
		}
		return con;
	}

}

// ctrl + shift + O to import all
