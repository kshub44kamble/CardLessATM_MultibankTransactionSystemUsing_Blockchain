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
 * Servlet implementation class dbWithdraw
 */
@WebServlet("/dbWithdraw")
public class dbWithdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dbWithdraw() {
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
		String op = "WITHDRAW";
		String date = (new java.util.Date()).toString();
		String uname = request.getParameter("uname");
		int accno = Integer.parseInt(request.getParameter("accNo"));
		int amt = Integer.parseInt(request.getParameter("Amount"));
		String bal_sql = "SELECT balance FROM tx_details WHERE uname='"+uname+"' AND acc_no = "+accno+" AND isnew = 'YES'";
		//System.out.println(bal_sql);
		int bal1=0;
		int update=0;
		int bal = BankCommons.getBalance(bal_sql);
		if(bal == 0){
			//System.out.println("Current Balance : "+bal);
			response.sendRedirect("noBal.jsp");
		}else if(bal < amt){
			response.sendRedirect("noBal.jsp");
		}else {
			bal1 = bal - amt;
			//System.out.println("Withdraw : "+bal1);
			String sql_up = "UPDATE tx_details SET isnew = 'NO' WHERE uname='"+uname+"' AND acc_no = "+accno+" AND isnew = 'YES'";
			update = BankCommons.update(sql_up);
		}
		String sql = "INSERT INTO tx_details (uname, acc_no, operation, amt, balance, time1, isnew ) VALUES ('"+uname+"',"+accno+",'WITHDRAW',"+amt+","+bal1+", '"+date+"', 'YES')";
		//System.out.println(sql);
		update = BankCommons.update(sql);
		if(update==1)
		{
		pw.println("<script> alert('Amount WithDraw Successfuly');</script>");
		RequestDispatcher rd = request.getRequestDispatcher("/HomePage.jsp");
		rd.include(request, response);
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("/withdraw.jsp");
			rd.include(request, response);	
		}
		
	}

}
