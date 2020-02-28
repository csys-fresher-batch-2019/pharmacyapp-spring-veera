package com.chainsys.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.pharmacyapp.daoImplementation.ProductImplementation;
import com.chainsys.pharmacyapp.model.Product;

@WebServlet("/AddProductDetails")
public class AddProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		  int  productId=Integer.parseInt(request.getParameter("productId"));
			String productName=request.getParameter("productName");
			String productType=request.getParameter("productType");
			int cost=Integer.parseInt(request.getParameter("cost"));
			int quantity=Integer.parseInt(request.getParameter("quantity"));
			String dat = request.getParameter("expiryDate");
			LocalDate date = java.time.LocalDate.parse(dat);
	      
			
          ProductImplementation Pi=new ProductImplementation();
          Product p=new Product();
          p.setProductId(productId);
          p.setProductName(productName);
          p.setProductType(productType);
          p.setCost(cost);
          p.setQuantity(quantity);
          p.setExpiryDate(date);
          try {
			int n=Pi.addProductDetails(p);
			System.out.println(n);
			if(n==1)
			{
				RequestDispatcher d = request.getRequestDispatcher("AddProductDetails.jsp");
			d.forward(request, response);
				PrintWriter out = response.getWriter();
		   		 out.println("\n");
		   			out.println("\n<h1>ProductDetails Added</h1>");
			}
			else
			{
		   		PrintWriter out = response.getWriter();
	      		 out.println("\n");
	      			out.println("\n <h1>ProductDetails already exist</h1>");
	    
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          
	}

	
}
