package hu.mik.java2.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class RegistrationService {
	
	DataSource dataSource=null;
	
	public RegistrationService() {
		try {
			InitialContext context=new InitialContext();
			this.dataSource=(DataSource) context.lookup("book/bookDatasource");
			
			
		} catch (NamingException e) {
			throw new RuntimeException();
		}
	}
	
	public void registration(String username, String password){
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		int id=getNextId();		
		
		try {
			connection=this.dataSource.getConnection();
			preparedStatement=connection.prepareStatement("insert into t_book_users(id, Username, GivenPW) values(?,?,?)");
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, username);
			preparedStatement.setString(3, password);
			preparedStatement.executeQuery();
			preparedStatement=connection.prepareStatement("insert into t_book_roles(id, Username, userid) values(?,?,?)");
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, username);
			preparedStatement.setInt(3, id);
			preparedStatement.executeQuery();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	
	private Integer getNextId(){
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		try {
			connection=this.dataSource.getConnection();
			preparedStatement=connection.prepareStatement("SELECT s_book_users.nextval FROM dual");			
			
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()){
				return resultSet.getInt(1);
			}
			else{
				throw new RuntimeException();
			}						
			
		} catch (SQLException e) {				
			throw new RuntimeException();
		} finally{
			closeResource(resultSet);
			closeResource(preparedStatement);
			closeResource(connection);
		}
	}
	
	private void closeResource(AutoCloseable closeable){
		if(closeable != null){
			try {
				closeable.close();
			} catch (Exception e) {
				
				throw new RuntimeException(e);
			}
		}
	}	
	
	

}
