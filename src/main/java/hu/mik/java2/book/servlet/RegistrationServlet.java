package hu.mik.java2.book.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import hu.mik.java2.service.RegistrationService;

@WebServlet(urlPatterns="/registration")
public class RegistrationServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
				
		if(req.getParameter("username").isEmpty() || req.getParameter("password").isEmpty()){
			resp.sendRedirect(req.getContextPath()+"/error.html");
		}
		else{
				String username=req.getParameter("username");
				String password=req.getParameter("password");
				RegistrationService registrationService=new RegistrationService();
				registrationService.registration(username, password);
				req.setAttribute("username", username);
				req.setAttribute("password", password);
				RequestDispatcher requestDispatcher=req.getRequestDispatcher("/regLogin.jsp");
				requestDispatcher.forward(req, resp);
		}		
	}
}

	

