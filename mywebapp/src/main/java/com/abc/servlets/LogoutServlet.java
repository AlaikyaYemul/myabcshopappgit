package com.abc.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if(session!=null) {
			
			session.invalidate();
			
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			
			out.println("<h3>You have Logged out successfully</h3>");
			
			out.println("<br>Session Id: "+session.getId()+"<br>");
			
			out.println("<a href='signin.html'>Click Here to Login Again</a>");
			
			out.println("</body></html>");
			
			out.close();
			
		}
		
	}

}
