package com.chainsys.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.pharmacyapp.dao.impl.ProductImplementation;
import com.chainsys.pharmacyapp.model.Product;
import com.chainsys.pharmacyapp.service.productService;
@WebServlet("/DisplayProductDetails")

public class DisplayProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("productId"));
		//ProductImplementation p = new ProductImplementation();
		productService p=new productService();
		// pr.setProductId(productId);
		ArrayList<Product> n = new ArrayList<Product>();
		try {
			n = p.selectProductId(productId);
			RequestDispatcher rd = request.getRequestDispatcher("SelectProductId.jsp");
			request.setAttribute("list", n);
			rd.forward(request, response);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
