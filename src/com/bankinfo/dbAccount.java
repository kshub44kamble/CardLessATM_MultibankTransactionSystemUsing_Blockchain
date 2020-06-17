package com.bankinfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinebank.BankCommons;

/**
 * Servlet implementation class dbAccount
 */
@WebServlet("/dbAccount")
public class dbAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dbAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String uname = request.getParameter("uname");
		int accno = Integer.parseInt(request.getParameter("accno"));
		String acc_type = request.getParameter("acc_type");
		String details = request.getParameter("details");
		String sql = "INSERT INTO acc_details VALUES ("+accno+",'"+uname+"','"+acc_type+"','"+details+"')";
		//System.out.println(sql);
		int update = BankCommons.update(sql);
		if(update==1)
		{
		pw.println("<script> alert(' Account Details Successfuly');</script>");
		RequestDispatcher rd = request.getRequestDispatcher("/HomePage.jsp");
		rd.include(request, response);
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("/account.jsp");
			rd.include(request, response);	
		}
	}

}
