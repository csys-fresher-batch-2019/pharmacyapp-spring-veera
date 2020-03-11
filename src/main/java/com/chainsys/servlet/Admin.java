package com.chainsys.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.pharmacyapp.dao.impl.ProductDAOImpl;
import com.chainsys.pharmacyapp.service.AdminService;

@WebServlet("/Admin")

public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductDAOImpl.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminService com = new AdminService();
		// AdminDAO com = new AdminDAOImplementation();
		String name = request.getParameter("name");
		HttpSession sess = request.getSession();
		sess.setAttribute("uname", name);

		String password = request.getParameter("password");
		try {

			boolean res = com.AdminLogin(name, password);
			if (res) {
				RequestDispatcher d = request.getRequestDispatcher("Adminaccess.jsp");
				d.forward(request, response);
			} else {
				RequestDispatcher d = request.getRequestDispatcher("Admin.jsp");
				d.forward(request, response);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
