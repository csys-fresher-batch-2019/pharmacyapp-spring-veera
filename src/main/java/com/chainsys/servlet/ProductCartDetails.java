package com.chainsys.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.pharmacyapp.dao.impl.ProductImplementation;
import com.chainsys.pharmacyapp.model.Product;
import com.chainsys.pharmacyapp.service.productService;

@WebServlet("/ProductCartDetails")
public class ProductCartDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int productId = Integer.parseInt(request.getParameter("productId"));

		ProductImplementation Pi = new ProductImplementation();
		// productService p=new productService();
		Product p = new Product();
		p.setProductId(productId);

	}

}
