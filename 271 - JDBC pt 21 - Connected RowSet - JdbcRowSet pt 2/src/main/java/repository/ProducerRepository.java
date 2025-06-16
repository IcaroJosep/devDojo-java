package repository;




import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;

import com.ConnectionFactory;


import dominio.Producer;

import lombok.extern.log4j.Log4j2;


@Log4j2
	  public class ProducerRepository {
		
		public static List<Producer> findByName(String name) {
			
			String sql = "SELECT * FROM anime_store.producer where name like ?;";
			List<Producer> producers = 	new ArrayList<Producer>();
			try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()){
				jrs.setCommand(sql);
				jrs.setString(1, String.format("%%%s%%", name));
				jrs.execute();
					while (jrs.next()) {
						producers.add(
								Producer.builder()
								.id(jrs.getInt("id"))
								.name(jrs.getString("name"))
								.build()
								);
					}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return producers;
		}
		
		
		public static void Update(Producer producer,String newName) {
			
			String sql = "SELECT * FROM anime_store.producer WHERE (`id` = ?);";
			
			try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()){
				jrs.setCommand(sql);
				jrs.setInt(1, producer.getId());
				jrs.execute();
				if(!jrs.next())return;
				jrs.updateString("name",newName);
				jrs.updateRow();	
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

		
}
