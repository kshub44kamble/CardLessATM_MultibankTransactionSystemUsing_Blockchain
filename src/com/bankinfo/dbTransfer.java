package com.bankinfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinebank.BankCommons;

/**
 * Servlet implementation class dbTransfer
 */
@WebServlet("/dbTransfer")
public class dbTransfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dbTransfer() {
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
		HttpSession session = request.getSession(false);
		String uname = (String)session.getAttribute("cust_name");
		System.out.println(uname);
		String date = (new java.util.Date()).toString();
		//String uname = request.getParameter("uname");
		int accno = Integer.parseInt(request.getParameter("accNo"));
		int daccno = Integer.parseInt(request.getParameter("daccNo"));
		int amt = Integer.parseInt(request.getParameter("Amount"));
		String bal_sql = "SELECT balance FROM tx_details WHERE uname='"+uname+"' AND acc_no = '"+accno+"' AND isnew = 'YES'";
		int bal = BankCommons.getBalance(bal_sql);
		String n = BankCommons.getNameByNo("SELECT uname FROM acc_details WHERE accno = '"+daccno+"'");
		String bal_sql_1 = "SELECT balance FROM tx_details WHERE uname='"+n+"' AND acc_no = '"+daccno+"' AND isnew = 'YES'";
		int bal_2 = BankCommons.getBalance(bal_sql_1);

		int bal1=0;

		if(bal < amt ){
			//System.out.println("Current Balance : "+bal);
			response.sendRedirect("lowBal.jsp");
		}else if(bal == 0){
			response.sendRedirect("noBal.jsp");
		}else {
			
			bal1 = bal - amt;
			String sql_up = "UPDATE tx_details SET isnew = 'NO' WHERE uname='"+uname+"' AND acc_no = '"+accno+"' AND isnew = 'YES'";
			int up = BankCommons.update(sql_up);
			
			String sql3 = "INSERT INTO tx_details (uname, acc_no, operation, amt, balance, time1, isnew ) VALUES ('"+uname+"','"+accno+"','TRANSFER','"+amt+"','"+bal1+"', '"+date+"', 'YES')";
			int update = BankCommons.update(sql3);
			//deposite into other account
			
			String str="UPDATE tx_details SET isnew = 'NO' WHERE uname='"+n+"' AND acc_no = '"+daccno+"'";
			BankCommons.update(str);
			int bal_sql_12 = bal_2 + amt;
			
			String msg="YES";
			String sql = "INSERT INTO tx_details (uname, acc_no, operation, amt, balance, time1, isnew ) VALUES ('"+n+"','"+daccno+"','DEPOSITE','"+amt+"','"+bal_sql_12+"', '"+date+"', '"+msg+"' )";
			
			int u = BankCommons.update(sql);
			if(u==1||up==1||update==1)
			{
			pw.println("<script> alert('Amount Transfer Successfuly');</script>");
			RequestDispatcher rd = request.getRequestDispatcher("/HomePage.jsp");
			rd.include(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("/transfer.jsp");
				rd.include(request, response);	
			}
		}
	}

}
