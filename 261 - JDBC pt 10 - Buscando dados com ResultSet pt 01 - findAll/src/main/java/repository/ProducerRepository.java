package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
				stmt.close();
				con.close();
				log.info("linhas afetadas no banco de dados:{} :deletado id {}",rowsAffected,id);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public static List<Producer> findAll() {
		log.info("buscando todos os Producers");
		String sql = "SELECT id ,name FROM anime_store.producer;";
		List<Producer> producers = new ArrayList<>();

		try(Connection con = ConnectionFactory.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql)){//rersultset: é outra biblioteca diferente de "statment" o comando esta sendo executado dentro dos parametros para q seja fechado altomaticamentem assim como os demais
												   //ele é criado apartir de um stetemant
			
			while (rs.next()) {//chama o procimo dado
				int id = rs.getInt("id");//a lib ResultSet permite capiturar direto do banco camando pelo nome ou coluna
				String name = rs.getString("name");
				producers.add(Producer.builder().id(id).name(name).build()); 
			
			}
		} catch (SQLException e) {
			log.error("Erro na busca de de 'todos os produces' ",e);
			e.printStackTrace();
		}
		return producers;
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
