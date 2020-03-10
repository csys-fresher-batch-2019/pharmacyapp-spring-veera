package com.chainsys.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.pharmacyapp.dao.impl.UserDAOImplementation;
import com.chainsys.pharmacyapp.model.UserDetails;
import com.chainsys.pharmacyapp.service.UserService;

@WebServlet("/userRegistration")

public class userRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String name = request.getParameter("name");
		String emailId = request.getParameter("emailId");
		String password = request.getParameter("password");
		String contacts = request.getParameter("contact");
		long contact = Long.parseLong(contacts);
		// UserDAOImplementation obj = new UserDAOImplementation();
		UserService obj = new UserService();
		UserDetails u = new UserDetails();
		u.setName(name);
		u.setEmailId(emailId);
		u.setPassword(password);
		u.setContact(contact);
		try {
			int n = obj.addUserDetails(u);
			if (n == 1) {
				RequestDispatcher d = request.getRequestDispatcher(".jsp");
				d.forward(request, response);
			} else {
				PrintWriter out = response.getWriter();
				out.println("\n");
				out.println("\n<h1>User Already Exist</h1>");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
