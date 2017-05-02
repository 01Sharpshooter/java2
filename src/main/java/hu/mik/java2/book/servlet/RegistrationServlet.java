package hu.mik.java2.book.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

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
			//Névellenőrzés	
				boolean foglalt=foglalte(username);	
				if(foglalt){
					resp.sendRedirect(req.getContextPath()+"/foglalt.html");
				}
				else{
				RegistrationService registrationService=new RegistrationService();
				registrationService.registration(username, password);
				req.setAttribute("username", username);
				req.setAttribute("password", password);
				RequestDispatcher requestDispatcher=req.getRequestDispatcher("/regLogin.jsp");
				requestDispatcher.forward(req, resp);
				}
		}		
	}
	
	private void closeResource(AutoCloseable closeable){
		if(closeable != null){
			try {
				closeable.close();
			} catch (Exception e) {
				
				throw new RuntimeException(e);
			}}
		}
	private boolean foglalte(String username){
		Connection connection=null;
		ResultSet resultSet=null;
		PreparedStatement preparedStatement=null;
		try {
			InitialContext context=new InitialContext();
			DataSource dataSource=(DataSource) context.lookup("book/bookDatasource");
			connection=dataSource.getConnection();
			preparedStatement=connection.prepareStatement(
					"select username from t_book_users");
			resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()){
				String aktnev=resultSet.getString(1);
				if(aktnev.equals(username)){
					return true;					
				}
			}
		} catch (SQLException | NamingException e) {
			throw new RuntimeException();
		}finally{
			closeResource(connection);
			closeResource(preparedStatement);
			closeResource(resultSet);
		}
		return false;
	}
}

	

