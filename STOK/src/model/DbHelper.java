package model;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbHelper {
	private static Connection con;
	private String userName="root";
	private String password="duygu.13";
	private String dbUrl="jdbc:mysql://localhost:3306/stok?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection(dbUrl,userName,password);
		
	}
	
	public void showErrorMessage(SQLException exception)
	{
		System.out.println("Error: "+ exception.getMessage());
		System.out.println("Error Code:"+ exception.getErrorCode());  
	}
	
	static ResultSet listele(String sorgu)
	{
		try
		{
			
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sorgu);
			return rs;
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
			return null;
		}
	}
	

}
