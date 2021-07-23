package com.amdocs.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("loginid");
		String password = request.getParameter("password");
		
		switch(login.loginUser(userid , password)) {
			case 0:
				request.getRequestDispatcher("userHome.jsp").forward(request, response);
			    break;
			 case 1:
				 request.getRequestDispatcher("adminHome.jsp").forward(request, response);
			    break;
			 default:
				 response.sendRedirect("user-register");  
		}

	}

}