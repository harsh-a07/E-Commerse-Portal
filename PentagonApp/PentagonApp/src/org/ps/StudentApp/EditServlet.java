package org.ps.StudentApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException{
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<body style='background-image:url(\"img/hand.jpeg\"); background-size:cover;>"
		+"<h1>Update Employee </h1>");
				String username=request.getParameter("username");
				
				Student s=StudentDao.getStudentByUsername(username);
				
				out.print("<form action='EditServlet2' method='post'>");
				out.print("<table>");
				out.print("<tr><td>Name</td><td><input type='text' name='name' value='"+s.getName()+"'/></td></tr>");
				out.print("<tr><td>UserName</td><td><input type='text' name='uname' value='"+s.getUsername()+"'/></td></tr>");
				out.print("<tr><td>Email</td><td><input type='text' name='email' value='"+s.getEmail()+"'/></td></tr>");
				out.print("<tr><td>Gender</td><td><input type='text' name='gender' value='"+s.getGender()+"'/></td></tr>");
				out.print("<tr><td>City</td><td><input type='text' name='city' value='"+s.getCity()+"'/></td></tr>");
				out.print("<tr><td>Country:</td><td>");
				out.print("<select name='country' style='width:150px'>");
				out.print("<option>India</india>");
				out.print("<option>USA</india>");
				out.print("<option>UK</india>");
				out.print("<option>Japan</india>");
				out.print("<option>Other</india>");
				out.print("</select>");
				out.print("</td></tr>");
				out.print("<tr><td>Password:</td><input type='password' value='"+s.getPassword()+"'/></td></tr>");
				out.print("<tr><td colspan='2' <input type='submit' value='Edit &amp; save' /></td></tr>");
				out.print("</table>");
				out.print("</form></body>");
				out.close();
						
				
				
					
	}
	

}
