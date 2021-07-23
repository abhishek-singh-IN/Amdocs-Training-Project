package com.amdocs.user;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amdocs.main.Register;

/**
 * Servlet implementation class UserRegisterServlet
 */
@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("userRegister.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        Date reg_date = new java.sql.Date(new java.util.Date().getTime());
        String password = request.getParameter("password");
		String photo = request.getParameter("photo");
		
        User user = new User();
        
        user.setName(name);
        user.setPhone(phone);
        user.setAddress(address);
        user.setEmail(email);
        user.setReg_date(reg_date);
        user.setPassword(password);
        user.setUpload_photo(photo);
        
        int s = -1;
        try {
        	s= com.amdocs.main.Register.registerUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
		request.setAttribute("message",s);
		request.getRequestDispatcher("userHome.jsp").forward(request, response);
	}

}
