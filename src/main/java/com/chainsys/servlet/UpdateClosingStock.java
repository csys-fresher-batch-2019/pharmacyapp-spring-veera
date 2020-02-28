package com.chainsys.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.pharmacyapp.daoImplementation.Stock1Implementation;
import com.chainsys.pharmacyapp.model.Stock1;



@WebServlet("/UpdateClosingStock")
public class UpdateClosingStock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		  int  stockId=Integer.parseInt(request.getParameter("stockId"));
		  Stock1Implementation nu=new Stock1Implementation();
          Stock1 s=new Stock1();
          s.setStockId(stockId);
          try {
			int n=nu.updateClosingStock(s);
			if(n==1)
			{
				PrintWriter out = response.getWriter();
		   		 out.println("\n");
		   			out.println("\n<h1>ClosingStock Updated</h1>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
