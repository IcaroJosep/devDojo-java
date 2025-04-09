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
	public static void delet(int id) {
		String sql = "DELETE FROM `anime_store`.`producer` WHERE (`id` = '%d');".formatted(id);
		
		try(Connection con = ConnectionFactory.getConnection();
			Statement stmt = con.createStatement()){
			
				int rowsAffected = stmt.executeUpdate(sql);
				log.info("linhas afetadas no banco de dados:{} :deletado id {}",rowsAffected,id);
				stmt.close();
				con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public static void update(int id , String name) {
		String sql = "UPDATE `anime_store`.`producer` SET `name` = '%s' WHERE (`id` = %d);".formatted(name,id);
		
		try(Connection con = ConnectionFactory.getConnection();
			Statement stmt = con.createStatement()){
			
				int rowsAffected = stmt.executeUpdate(sql);
				log.info("linhas afetadas '{}' id: '{}' teve seu name alterado para '{}'",rowsAffected,id,name);
				stmt.close();
				con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	
	
}
