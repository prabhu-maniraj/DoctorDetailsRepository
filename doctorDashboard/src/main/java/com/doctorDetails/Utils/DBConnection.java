package com.doctorDetails.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DBConnection {
	
	private static Connection getDBConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","2a2e5728");  
	    return con;
	}

	public static PreparedStatement getPreparedStatement(String sqlQuery) throws SQLException, ClassNotFoundException
	{
		Connection dbConnection = getDBConnection();
		PreparedStatement stmt =null;
		if(dbConnection!=null)
		{
			stmt = dbConnection.prepareStatement(sqlQuery);
		}
		return stmt;
	}
}
