package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.ConnectionFactory;

import dominio.Producer;
import listiner.CustomRowSetLitener;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ProducerRepository {
	
	public static List<Producer> findByName(String name) {
		
		String sql = "SELECT * FROM anime_store.producer where name like ?;";
		List<Producer> producers = new ArrayList<Producer>();
		
		try (CachedRowSet crs = ConnectionFactory.getCachedRowSet()) {
			crs.addRowSetListener(new CustomRowSetLitener());
			crs.setCommand(sql);
			crs.setString(1, String.format("%%%s%%", name));
			crs.execute();
			
			while (crs.next()) {
				producers.add(
					Producer.builder()
					.id(crs.getInt("id"))
					.name(crs.getString("name"))
					.build()
				);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return producers;
	}
	
	public static void Update(Producer producer, String newName) {
		
		// Usa CachedRowSet para verificar se o registro existe
		String selectSql = "SELECT * FROM anime_store.producer WHERE (`id` = ?);";
		
		try (CachedRowSet crs = ConnectionFactory.getCachedRowSet()) {
			crs.addRowSetListener(new CustomRowSetLitener());
			crs.setCommand(selectSql);
			crs.setInt(1, producer.getId());
			crs.execute();
			
			// Se não houver dados, retorna
			if (!crs.next()) return;
			
			// Usa PreparedStatement para a atualização (mais confiável)
			String updateSql = "UPDATE anime_store.producer SET name = ? WHERE id = ?";
			
			try (Connection conn = ConnectionFactory.getConnection();
				 PreparedStatement pstmt = conn.prepareStatement(updateSql)) {
				
				pstmt.setString(1, newName);
				pstmt.setInt(2, producer.getId());
				
				int rowsUpdated = pstmt.executeUpdate();
				log.info("Linhas atualizadas: " + rowsUpdated);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}