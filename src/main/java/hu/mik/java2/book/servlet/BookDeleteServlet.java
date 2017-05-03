package hu.mik.java2.book.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.mik.java2.book.bean.Book;
import hu.mik.java2.service.BookService;
import hu.mik.java2.service.ServiceUtils;

@WebServlet(urlPatterns="/book_delete")
public class BookDeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Book book;
		BookService bookService=ServiceUtils.getBookService();
		if(req.getParameter("bookId") !=null){
			book=bookService.getBookById(Integer.parseInt(req.getParameter("bookId")));
			req.setAttribute("book", book);
			
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("/book_delete.jsp");
			requestDispatcher.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Book book;
		BookService bookService=ServiceUtils.getBookService();
		if(req.getParameter("id") != null){
			book=bookService.getBookById(Integer.parseInt(req.getParameter("id")));
			bookService.deleteBook(book);				
			resp.sendRedirect(req.getContextPath()+"/book_list");				
			}
	}
		
}
