package com.chainsys.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.pharmacyapp.dao.AdminDAO;
import com.chainsys.pharmacyapp.dao.impl.AdminDAOImplementation;
import com.chainsys.pharmacyapp.service.adminService;

@WebServlet("/Admin")

public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		adminService com = new adminService();
		// AdminDAO com = new AdminDAOImplementation();
		String name = request.getParameter("name");
		System.out.println(name);
		HttpSession sess = request.getSession();
		sess.setAttribute("uname", name);

		String password = request.getParameter("password");
		System.out.println(password);
		System.out.println(name + " " + password);

		try {

			boolean res = com.AdminLogin(name, password);
			System.out.println(res);
			if (res) {
				HttpSession ses = request.getSession();
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
