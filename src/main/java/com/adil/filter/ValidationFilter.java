package com.adil.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/reg")
public class ValidationFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;
	
	 

	public void init(FilterConfig fConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String sid_error = "", sname_error = "", semail_error = "", sage_error = "", smobile_error = "";

		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String name = request.getParameter("sname");
			String email = request.getParameter("semail");
			String age = request.getParameter("sage");
			String mobile = request.getParameter("smobile");
			String id = request.getParameter("sid");
			
			boolean flag = true;
			if (id == null || id.equals("")) {
				sid_error = "Id is required";
				flag = false;
			}
			if (name == null || name.equals("")) {
				sname_error = "Name is required";
				 flag = false;
			}
			if (email == null || email.equals("")) {
				semail_error = "Email is required";
				 flag = false;
			}
			if (age == null || age.equals("")) {
				sage_error = "Age must be greater than 0";
				 flag = false;
			}
			if (mobile == null || mobile.equals("")) {
				smobile_error = "Mobile number is required";
				 flag = false;
			}
			if(flag==true) {
				chain.doFilter(request, response);
			}else {
				out.println("<html>");
				out.println("<body>");
				out.println("<h1>Durga software solutions</h1>");
				out.println("<h2>Registration Details</h2>");
				
				out.println("<form action='./reg' method='post'>");
			    out.println("<table border='1'>");
			    
			    out.println("<tr>");
			    out.println("<th>id</th>");
			    out.println("<td>" + sid_error + "</td>");
			    out.println("</tr>");
			    
			    out.println("<tr>");
			    out.println("<th>Name</th>");
			    out.println("<td>" + sname_error + "</td>");
			    out.println("</tr>");

			    out.println("<tr>");
			    out.println("<th>Email</th>");
			    out.println("<td>" + semail_error + "</td>");
			    out.println("</tr>");

			    out.println("<tr>");
			    out.println("<th>Age</th>");
			    out.println("<td>" + sage_error + "</td>");
			    out.println("</tr>");

			    out.println("<tr>");
			    out.println("<th>Mobile</th>");
			    out.println("<td>" + smobile_error + "</td>");
			    out.println("</tr>");

			    out.println("</table>");
			    out.println("<input type='submit' value='Registration'>");
			    out.println("</form>");

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void destroy() {

	}

}
