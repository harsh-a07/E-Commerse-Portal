package org.ps.StudentApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

@WebServlet("/RetrieveVideoDemo")

public class RetrieveVideoDemo extends HttpServlet {
	
	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws IOException, ServletException{
			   
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307?user=root&password=tiger");
				PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("Select * FROM pentagondb.videos");
			    ResultSet rs=stmt.executeQuery();
			    
			    resp.setContentType("text/html");
			    PrintWriter out=resp.getWriter();
			    out.println("<DOCTYPE html>");
			    out.println("<html>");
			    out.println("<head>");
			    out.println("<title>Video Player</title>");
			    out.println("<link href=\"Testi.css\" rel=\"stylesheet\">");
			    out.println("</head>");
			    out.println("<div class='aboutback'>");
			    out.println("<center><h1 class='head'>Student Testimonies Gallery</h1></center>");
			    out.println("<div class='underline'></div>");
			    out.println("</div>");
			    out.println("<div class=\"gallery\">"); 
			    
			    while(rs.next()) {
			    	String path=rs.getString("video");
			    	if(path!=null) {
			    		out.println("<div class=\"video-container\">");
			    		out.println("<video controls>");
			    		out.println("</video>");
			    		out.println("</div>");
			    		
			    	}else {
			    		resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			    	}
			    
			}
			    out.println("</div>");
			    out.println("</body>");
			    out.println("</html>");
			    
			    rs.close();
			    stmt.close();
			    conn.close();
			}  catch (ClassNotFoundException| SQLException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
				resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
		}
			
		}


