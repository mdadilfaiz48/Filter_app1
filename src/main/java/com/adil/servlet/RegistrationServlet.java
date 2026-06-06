package com.adil.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/reg")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// call service method
		try {
			// fetch data from request and validate
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("sname");
		String email = request.getParameter("semail");
		String age = request.getParameter("sage");
		String mobile = request.getParameter("smobile");
		String id = request.getParameter("sid");
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Durga software solutions</h1>");
		out.println("<h2>Registration Details</h2>");
		

	    out.println("<table border='1'>");
	    
	    out.println("<tr>");
	    out.println("<th>id</th>");
	    out.println("<td>" + id + "</td>");
	    out.println("</tr>");
	    
	    out.println("<tr>");
	    out.println("<th>Name</th>");
	    out.println("<td>" + name + "</td>");
	    out.println("</tr>");

	    out.println("<tr>");
	    out.println("<th>Email</th>");
	    out.println("<td>" + email + "</td>");
	    out.println("</tr>");

	    out.println("<tr>");
	    out.println("<th>Age</th>");
	    out.println("<td>" + age + "</td>");
	    out.println("</tr>");

	    out.println("<tr>");
	    out.println("<th>Mobile</th>");
	    out.println("<td>" + mobile + "</td>");
	    out.println("</tr>");

	    out.println("</table>");

	    out.println("</body>");
	    out.println("</html>");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
