package repository;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ConnectionFactory;
import com.Usser;

import dominio.Producer;
import lombok.extern.log4j.Log4j2;


@Log4j2
public  class ProducerRepository {
	
	
	
	
	public static List<Producer> listaProducer(Connection conn) {
		String sql= "SELECT * FROM anime_store.producer;";
		List<Producer> producers = new ArrayList<>();
		
		try (Connection conn1 = conn ;
			Statement stmt = conn1.createStatement();
			ResultSet rs = stmt.executeQuery(sql)){
			
			while (rs.next()) {
				producers.add(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			log.warn("erro na captura");
		}
		
		return producers;
	}
	
	public static void incerir(Connection conn,String name) {
		String sql ="INSERT INTO `anime_store`.`producer` (`name`) VALUES (?);";
		try (PreparedStatement pstm= conn.prepareStatement(sql)){
			pstm.setString(1,name);
			System.out.printf("linhas afetadas %d\n", pstm.executeUpdate());
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
		
		
	
}
