package repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.ConnectionFactory;

import dominio.Producer;

public class ProducerRepository {
	public static void save(Producer producer) {
		String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES ('%s');".formatted(producer.getName());
		
		try(Connection con = ConnectionFactory.getConnection();
			Statement stmt = con.createStatement()){
			
				int rowsAffected = stmt.executeUpdate(sql);
				System.out.println(rowsAffected);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
