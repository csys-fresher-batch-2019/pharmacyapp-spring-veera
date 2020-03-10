package com.chainsys.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.pharmacyapp.model.Product;
import com.chainsys.pharmacyapp.service.ProductService;

@WebServlet("/UpdateProductType")

public class UpdateProductType extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int productId = Integer.parseInt(request.getParameter("productId"));
		String productType = request.getParameter("productType");
		ProductService Pi = new ProductService();
		// ProductImplementation Pi=new ProductImplementation();
		Product p = new Product();
		p.setProductId(productId);
		p.setProductType(productType);
		try {
			int n = Pi.updateProductType(productId, productType);
			System.out.println(n);
			if (n == 1) {
				//
				PrintWriter out = response.getWriter();
				out.println("\n");
				out.println("\n<h1>ProductType Updated </h1>");
			} else {
				PrintWriter out = response.getWriter();
				out.println("\n");
				out.println("\n<h1>ProductType cannot be Updated </h1>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
