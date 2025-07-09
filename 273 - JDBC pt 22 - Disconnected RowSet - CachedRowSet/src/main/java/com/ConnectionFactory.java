package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class ConnectionFactory {
	
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/anime_store";
		String username = "root";
		String password = "icaro";
		
		return DriverManager.getConnection(url, username, password);
	}
	
	public static CachedRowSet getCachedRowSet() throws SQLException {
		CachedRowSet cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
		
		// CachedRowSet precisa de uma conexão para popular os dados
		String url = "jdbc:mysql://localhost:3306/anime_store";
		String username = "root";
		String password = "icaro";
		
		cachedRowSet.setUrl(url);
		cachedRowSet.setUsername(username);
		cachedRowSet.setPassword(password);
		
		return cachedRowSet;
	}
}