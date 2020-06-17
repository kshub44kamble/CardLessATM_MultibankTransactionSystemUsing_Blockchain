package com.userinfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Statement;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mail.SendKeyMail;

import com.onlinebank.BankCommons;

/**
 * Servlet implementation class doLogin
 */
@WebServlet("/doLogin")
public class doLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();  

		HttpSession session=request.getSession();  
		session.invalidate();  

		out.println("<script type=\"text/javascript\">");  
		out.println("alert('You are successfully logged out!');");  
		out.println("</script>");
		request.getRequestDispatcher("index.jsp").include(request, response);         
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public String otpcode() 
	{
	
		StringBuilder ss = new StringBuilder();
		Random r = new Random();
		char ch;

		for (int i = 0; i < 5; i++) 
		{
			ch = (char) (Math.floor(26 * r.nextDouble() + 65));
			ss.append(ch);
		}

		return ss.toString();

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession(false);
		String uname = request.getParameter("username");
		String password = request.getParameter("password");
		String sql = "SELECT uname, upass FROM user_details WHERE email ='"+uname+"' AND upass = '"+password+"'";
		//System.out.println(sql);
		boolean ck = BankCommons.checkUser(sql,session);
		if(ck == true ){
			String otpcodes=otpcode();
			session.setAttribute("email",uname);
			String username=(String)session.getAttribute("cust_name");
			String str="update otpcodetble set otpcode='"+otpcodes+"' where email='" +uname+ "'";

			BankCommons.update(str);
			SendKeyMail.SendOTP(uname,otpcodes);
			pw.println("<script> alert(' Login Successfuly');</script>");
			RequestDispatcher rd = request.getRequestDispatcher("/OTPCode.jsp");
			rd.include(request, response);
		}else {
			response.sendRedirect("index.jsp");
		}
	}

}
