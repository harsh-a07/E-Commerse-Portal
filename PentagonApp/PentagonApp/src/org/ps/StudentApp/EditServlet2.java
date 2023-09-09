package org.ps.StudentApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException{
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String username=request.getParameter("uname");
		String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		String city=request.getParameter("city");
		String country=request.getParameter("country");
		String password=request.getParameter("password");
		
		Student s=new Student();
		s.setName(name);
		s.setUsername(username);
		s.setEmail(email);
		s.setGender(gender);
		s.setCity(city);
		s.setCountry(country);
		s.setPassword(password);
		
		int status=StudentDao.update(s);
		if(status>0) {
			
			response.sendRedirect("ViewServlet");
			
		}
		else {
			out.println("sorry! unable to update record");
		}
		
		out.close();
	}
		

}
