package com;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class ConnectionFactory {
	
	
	
	public static JdbcRowSet getJdbcRowSet() throws SQLException {
		
		String url = "jdbc:mysql://localhost:3306/anime_store";
		
		String username= "root";			
		String password= "icaro";
		JdbcRowSet jdbcRowSet= RowSetProvider.newFactory().createJdbcRowSet();
		jdbcRowSet.setUrl(url);
		jdbcRowSet.setPassword(password);
		jdbcRowSet.setUsername(username);
	
		return jdbcRowSet;
		}
}