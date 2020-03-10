package com.chainsys.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.pharmacyapp.dao.impl.UserDAOImplementation;
import com.chainsys.pharmacyapp.service.UserService;

@WebServlet("/User")

public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		// UserDAOImplementation u = new UserDAOImplementation();
		UserService u = new UserService();
		String name = request.getParameter("name");
		System.out.println(name);
		String password = request.getParameter("password");
		System.out.println(password);
		System.out.println(name + "  " + password);
		try {

			boolean res = u.user(name, password);
			System.out.println(res);
			if (res == true) {
				HttpSession ses = request.getSession();
				RequestDispatcher d = request.getRequestDispatcher("DisplayProductDetails.jsp");
				d.forward(request, response);
			} else {
				RequestDispatcher d = request.getRequestDispatcher("Login.jsp");
				d.forward(request, response);

			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
