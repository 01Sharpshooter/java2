package hu.mik.java2.book.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import hu.mik.java2.service.BookService;
import hu.mik.java2.service.ServiceUtils;

<<<<<<< HEAD:src/main/java/hu/mik/java2/book/servlet/LogoutServlet.java
@WebServlet(urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {
=======
//@WebServlet(urlPatterns = "/book_list")
public class BookServlet extends HttpServlet {
>>>>>>> remotes/origin/master:src/main/java/hu/mik/java2/book/servlet/BookServlet.java

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
<<<<<<< HEAD:src/main/java/hu/mik/java2/book/servlet/LogoutServlet.java
		req.getSession().invalidate();
=======
		BookService bookService = ServiceUtils.getBookService();
		req.setAttribute("books", bookService.listBooks());
		req.setAttribute("username", req.getRemoteUser());
		req.setAttribute("isEditor", req.isUserInRole("editor"));
>>>>>>> remotes/origin/master:src/main/java/hu/mik/java2/book/servlet/BookServlet.java
		
		resp.sendRedirect(req.getContextPath());
	}
	
	

}
