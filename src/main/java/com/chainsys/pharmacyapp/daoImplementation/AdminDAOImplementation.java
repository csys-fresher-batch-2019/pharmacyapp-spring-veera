package com.chainsys.pharmacyapp.daoImplementation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.chainsys.pharmacyapp.companyDetails.TestConnection;
import com.chainsys.pharmacyapp.dao.AdminDAO;




public class AdminDAOImplementation implements AdminDAO{
	

	public boolean AdminLogin(String Adminname, String pass) throws Exception {
		Connection con = TestConnection.getConnection();
		Statement stmt = con.createStatement();
		String sql="select pass_word from AdminRegister where Admin_name=(select Admin_name from AdminRegister where Admin_name='"+Adminname+"')";
		ResultSet rs1 = stmt.executeQuery(sql);
        if(rs1.next())
        {
        	String password=rs1.getString("pass_word");
        
        if (pass.equals(password))
        {
				return true;
			}
        }
		
		return false;
}

}
