package com.chainsys.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.pharmacyapp.dao.impl.ProductImplementation;
import com.chainsys.pharmacyapp.model.Product;



@WebServlet("/UpdateProductCost")

public class UpdateProductCost extends HttpServlet {
	private static final long serialVersionUID = 1L;   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		  int  productId=Integer.parseInt(request.getParameter("productId"));
		  int productCost=Integer.parseInt(request.getParameter("productCost"));
          ProductImplementation Pi=new ProductImplementation();
          Product p=new Product();
          p.setProductId(productId);
          p.setCost(productCost);
         try {
			int n=Pi.updateCost(productId, productCost);
			System.out.println(n);
			if(n==1)
			{
				PrintWriter out = response.getWriter();
	   		 out.println("\n");
	   			out.println("\n<h1>ProductCost Updated </h1>");
				
			}
			else
			{
				PrintWriter out = response.getWriter();
		   		 out.println("\n");
		   			out.println("\n<h1>ProductCost not Updated </h1>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
