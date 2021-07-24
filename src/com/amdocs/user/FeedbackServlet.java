package com.amdocs.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amdocs.main.Feedback;

public class FeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FeedbackServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("insertFeedback.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String feedback_message = request.getParameter("feedback_message");
		int user_id = 0;
		
		Feedback feedback = new Feedback(user_id,feedback_message);
		System.out.print(feedback.getFeedback_id());
	}

}
