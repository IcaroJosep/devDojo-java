package repository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.ConnectionFactory;

import dominio.Producer;
import lombok.extern.log4j.Log4j2;


@Log4j2
public  class ProducerRepository {
	
	
		public static void saveTransaction(List<Producer> producers) {
			try (Connection conn = ConnectionFactory.getConnection()){
				conn.setAutoCommit(false); 
				prepareStatemanSaveTransaction(conn, producers);
				conn.commit();//comita para o banco de dados
			} catch (SQLException e) {
				e.printStackTrace();
				log.warn("erro ao salvar no banco '{}'",producers );
			}
			
		}
		
		public static void prepareStatemanSaveTransaction(Connection conn,List<Producer> producers)throws SQLException {
		 String sql="INSERT INTO `anime_store`.`producer` (`name`) VALUES (?);";
		 	boolean rollback = false;
			for (Producer p : producers) {
				try (PreparedStatement ps = conn.prepareStatement(sql)){
					log.info("saving producer '{}'",p.getName());
					
					//lançamento de erro
					//if (p.getName().equals("igor")) throw new SQLException("nao pode salvar icaro") ;
					
					ps.setString(1, p.getName());
					ps.execute();
					
				} catch (SQLException e) {
					e.printStackTrace();
					rollback = true;
				}
			}
			if(rollback) {
				conn.rollback();//desfas as alteraçoes feitas 
				throw new SQLException();//lança a eceçao para o proximo metodo
			}
		}
		
	
}
