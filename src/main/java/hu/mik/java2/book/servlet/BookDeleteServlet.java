package hu.mik.java2.book.servlet;

import java.io.IOException;

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
			bookService.deleteBook(book);
			
			
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("/book_delete.jsp");
			requestDispatcher.forward(req, resp);
		}
	}
}
