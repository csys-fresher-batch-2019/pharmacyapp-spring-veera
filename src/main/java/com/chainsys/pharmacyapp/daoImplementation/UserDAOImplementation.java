 package com.chainsys.pharmacyapp.daoImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.chainsys.pharmacyapp.companyDetails.TestConnection;
import com.chainsys.pharmacyapp.dao.UserDAO;
import com.chainsys.pharmacyapp.model.UserDetails;



public class UserDAOImplementation implements UserDAO {
	static 	Scanner sc = new Scanner(System.in);

	public int addUserDetails(UserDetails p) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into UserRegister(name,Email_id,password,contact) values (?,?,?,?)";
		Connection con = TestConnection.getConnection();

		System.out.println(sql);
		System.out.println(con);
		PreparedStatement stmp = con.prepareStatement(sql);
		stmp.setString(1, p.getName());
		stmp.setString(2, p.getEmailId());
		stmp.setString(3, p.getPassword());
		stmp.setLong(4, p.getContact());
		int row=stmp.executeUpdate();
		System.out.println("Done");
		return row;
	}
	
	public boolean user(String name,String password) throws Exception 
	{
		System.out.println(password);
		// TODO Auto-generated method stub

		Connection con = TestConnection.getConnection();
		String sql="select password from UserRegister where name=(select name from UserRegister where name='"+name+"')";
		Statement stmt = con.createStatement();
		ResultSet rs1 = stmt.executeQuery(sql);
		if(rs1.next()) {
			String pass=rs1.getString("password");
			//System.out.println(pass);
			if (password.equals(pass)) 
			{
				return true;
			}
		}
		return false;

	}

//	@Override
//	public int user() throws Exception {
//		return 0;
//		
//		
//	}

//	public void user() throws Exception {
//		// TODO Auto-generated method stub
//		System.out.println("Enter UserName:");
//		Scanner sc = new Scanner(System.in);
//		String name = sc.next();
//		System.out.println("Enter Password:");
//		String pass = sc.next();
//		UserDAOImplementation com = new UserDAOImplementation();
//		boolean res=com.user(name, pass);
//		
//		if (res) {
//			System.out.println(">>>>LOGIN SUCESSFULL<<<<");
//			// view order details
//			System.out.println("Enter 1 To view  Product List");
//			Scanner sc1 = new Scanner(System.in);
//			int str = sc1.nextInt();
//			switch (str) {
//			case 1:
//				System.out.println(">>>>>>>>>Product List<<<<<<<<<");
//				ProductImplementation us = new ProductImplementation();
//				// Product d=new Product();
//
//				ArrayList<Product> out = new ArrayList<Product>();
//				out = us.displayProduct();
//				for (Product P : out) {
//					System.out.print("ProductId:" + P.getProductId() + ", ProductName:" + P.getProductName() + ", ProductType:"
//							+ P.getProductType() + ",Cost:" + P.getCost() + ",Quantity:"+P.getQuantity()+",ExpiryDate:" + P.getExpiryDate() + "\n");
//
//				}
//
//				//System.out.println(out);
//				System.out.println("Enter 2 To place Order");
//				Scanner scn = new Scanner(System.in);
//				int str1 = scn.nextInt();
//				switch (str1) {
//				case 2:
//					//// Again display productList to user
//					ProductImplementation us1 = new ProductImplementation();
//
//					ArrayList<Product> out1 = new ArrayList<Product>();
//					out1 = us1.displayProduct();
//					for (Product P1 : out1) {
//						System.out.print(
//								"ProductId: " + P1.getProductId() + ", ProductName: " + P1.getProductName() + ", ProductType: "
//										+ P1.getProductType() + ",Cost: " + P1.getCost() +",Quantity:"+P1.getQuantity()+ ",ExpiryDate " + P1.getExpiryDate() + "\n");
//
//					}
//				//	System.out.println(out1);
//
//					System.out.println("Enter ProductId:  ");
//					Scanner scn1 = new Scanner(System.in);
//
//					int numb = scn1.nextInt();
//					
//					ProductImplementation us3 = new ProductImplementation();
//					//Product d2= new Product();
//					
//			         
//					ArrayList<Product> out2 = new ArrayList<Product>();
//					
//					out2=us3.selectProductId(numb);
//
//					for (Product P3: out2) {
//						System.out.print(
//								"ProductId: " + P3.getProductId() + ", ProductName: " + P3.getProductName() + ", ProductType: "
//										+ P3.getProductType() + ",Cost: " + P3.getCost() + ",ExpiryDate " + P3.getExpiryDate() + "\n");
//
//					}
//					//System.out.println(out2);
//					System.out.println("Enter the product quantity needed");
//                     int need=sc.nextInt();
//                     switch(need)
//                     {
//                     case 1:
//                    	 System.out.println("Done");
//                    	 break;
//                     }
////                     if(Quantity>need)/////////////////////////////Add Quantity details  to check
////                     {
////                    	System.out.println("Do you like to place order ? \n Enter YES to place order \n Enter  NO to cancel  order \n Enter  H to back to Homepage");
////			             String o=sc.next();
////			                 switch (o)
////			               	 {
////			                 case "YES":
////			           		 break;
////			                    	
////			               	 }
//                     //}
//			
//				}
//
//			}
//
//		} 
//		else {
//			System.out.println(">>>>LOGIN FAILED<<<<");
//			
//	}
//	}

	

}
