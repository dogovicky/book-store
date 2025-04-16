package com.capricon.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capricon.web.dao.BookDAO;
import com.capricon.web.model.Book;

/**
 * Servlet implementation class Book
 */
@WebServlet("/Book")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String isbn = request.getParameter("isbn");
		String price = request.getParameter("price");
		
		Book book = new Book(title, author, isbn, price);
		
		boolean result = BookDAO.saveBook(book);
		if (result) {
			response.sendRedirect("dashboard.jsp");
		} else {
			response.sendError(0);
		}
		
		
		
	}

}
