package com.capricon.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capricon.web.dao.UserDAO;
import com.capricon.web.model.User;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = new User(email, password);
		boolean isValid = UserDAO.saveUser(user);
		if (isValid) {
			session.setAttribute("email", email);
			response.sendRedirect("dashboard.jsp");
		} else {
			response.setContentType("text/html");
			PrintWriter writer = response.getWriter();
			writer.print("Failed to sing you up");
		}
	}

}
