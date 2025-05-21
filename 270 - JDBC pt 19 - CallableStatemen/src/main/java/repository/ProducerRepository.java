package repository;

import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.ConnectionFactory;


import dominio.Producer;

import lombok.extern.log4j.Log4j2;


@Log4j2
public class ProducerRepository {
	
	 public static List<Producer> findByNameCallable(String name) {
		log.info("procurando name in producer");
		 List<Producer> producers = new ArrayList<Producer>(); 
		 try (Connection conn = ConnectionFactory.getConnection();
		CallableStatement cs = CallableStatementFindByName(name , conn) ;
		ResultSet rs = cs.executeQuery()){
			
			 while (rs.next()) {
				producers.add(Producer.builder()
						.id(rs.getInt("id"))
						.name(rs.getString("name"))
						.build());
			}
			 
		} catch (SQLException e) {
			log.error("fudeu!");
			e.printStackTrace();
		}
		 return producers;
	}
	 
	 private static CallableStatement CallableStatementFindByName(String name ,Connection conn) throws SQLException {
		 String sql = "CALL `anime_store`.`sp_get_producer_by_name`(?);";
		 CallableStatement cs = conn.prepareCall(sql);
		 cs.setString(1, name);
		 return cs;
	}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
		
		
	
}
