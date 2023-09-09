package org.ps.StudentApp;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException
	{
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		String username=req.getParameter("uname");
		String password=req.getParameter("pw");
		if(Validate.checkUser(username,password)) {
			
			RequestDispatcher rd=req.getRequestDispatcher("Firstpage.html");
			rd.forward(req, resp);
			
		}
		
		else {
			out.println("user name or password incorrect");
			RequestDispatcher rd=req.getRequestDispatcher("index.html");
			rd.include(req, resp);
		}
	}
}
