package com.chainsys.pharmacyapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.TimeZone;



public class ConnectionUtil {

	public static Connection getConnection() throws Exception {
		//TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
		Class.forName("oracle.jdbc.driver.OracleDriver");
	//	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@13.235.147.120:1521:XE", "veera", "veera");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
		return con;
	}

	// ctrl + shift + O to import all
//	public static Jdbi getJdbi() {
//		Connection connection = null;
//		try {
//			connection = TestConnection.getConnection();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Jdbi jdbi = Jdbi.create(connection);
//		jdbi.installPlugin(new SqlObjectPlugin());
//		return jdbi;
//	}
}
