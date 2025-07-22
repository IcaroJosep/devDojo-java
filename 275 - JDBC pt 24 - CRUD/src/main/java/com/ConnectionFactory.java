package com;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection getConnection(Usser a) throws SQLException {
		
		String url = "jdbc:mysql://localhost:3306/anime_store";
		
		String username=a.getUsser();		
		String password=a.getSenha();
	
		return 	DriverManager.getConnection(url,username,password);
	}	
	
}