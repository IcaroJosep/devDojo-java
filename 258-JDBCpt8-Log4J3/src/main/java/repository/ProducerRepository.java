package repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.ConnectionFactory;

import dominio.Producer;
import lombok.extern.log4j.Log4j2;


@Log4j2
public class ProducerRepository {
	public static void save(Producer producer) {
		String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES ('%s');".formatted(producer.getName());
		
		try(Connection con = ConnectionFactory.getConnection();
			Statement stmt = con.createStatement()){
			
				int rowsAffected = stmt.executeUpdate(sql);
				log.info("linhas afetadas no banco de dados:{}",rowsAffected);
				stmt.close();
				con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	
}
