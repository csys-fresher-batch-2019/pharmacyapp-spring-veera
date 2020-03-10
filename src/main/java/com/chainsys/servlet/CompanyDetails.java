package com.chainsys.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.pharmacyapp.model.CompanyModel;
import com.chainsys.pharmacyapp.service.CompanyService;

@WebServlet("/CompanyDetails")

public class CompanyDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// int companyId=Integer.parseInt("companyId");
		int companyId = Integer.parseInt(request.getParameter("companyId"));
		String companyName = request.getParameter("companyName");
		String companyType = request.getParameter("companyType");
		String companyAddress = request.getParameter("companyAddress");
		// CompanyImplementation im=new CompanyImplementation() ;
		CompanyService im = new CompanyService();
		CompanyModel m = new CompanyModel();
		m.setCompanyId(companyId);
		m.setCompanyName(companyName);
		m.setCompanyType(companyType);
		m.setCompanyAddress(companyAddress);
		try {
			int n = im.save(m);
			System.out.println(n);
			if (n == 1) {
				PrintWriter out = response.getWriter();
				out.println("\n");
				out.println("\n<h1>Companydetails Added</h1>");
			} else {
				PrintWriter out = response.getWriter();
				out.println("\n");
				out.println("\n <h1>Companydetails already exists</h1>");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
