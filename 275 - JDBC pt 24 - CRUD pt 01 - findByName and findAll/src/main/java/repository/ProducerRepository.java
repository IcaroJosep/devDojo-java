package repository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ConnectionFactory;

import dominio.Producer;
import lombok.extern.log4j.Log4j2;


@Log4j2
public  class ProducerRepository {

//##################################### FIND BY NAME ######################################################3
	public static List<Producer> findByName(String name) {
		log.info("finding Producer by name '{}'",name);
		List<Producer> producers= new ArrayList<>();
		try (Connection conn = ConnectionFactory.getConnection();
			 PreparedStatement ps = creatPrepareStatmanFindByName(conn,name);
			 ResultSet rs = ps.executeQuery()){
				
				while (rs.next()) {
					producers.add(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return producers;
	}
	/**
	 * @param conn
	 * @param name
	 * @return PreparedStatement
	 * @throws SQLException 
	 */
	private static PreparedStatement creatPrepareStatmanFindByName(Connection conn, String name) throws SQLException {
			String sql="SELECT * FROM anime_store.producer where name like ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,String.format("%%%s%%", name));
		return ps;
	}
		
//####################################### END FIND BY NAME #######################################################		
		
//#######################################    DELET    ################################
	public static void delet(int id) {
		
		try(Connection con = ConnectionFactory.getConnection();
			PreparedStatement ps = creatPrepareStatmanDelet(con, id)){
			
				ps.execute();
				log.info("delatado  do banco  o id:{} ",id);
				ps.close();
				con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	private static PreparedStatement creatPrepareStatmanDelet(Connection conn, int id) throws SQLException {
			String sql = "DELETE FROM `anime_store`.`producer` WHERE (`id` = ?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
		return ps;
	}
//####################################### END delete	####################################

//######################################## SAVE ############################################
	
	public static void save(Producer producer) {
		log.info("salvando produce = '{}'",producer);
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement ps = createPreparedStatement(conn,producer)){
				log.info("linha adicinada {}",!ps.execute());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	private static PreparedStatement createPreparedStatement(Connection conn, Producer producer) throws SQLException {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO `anime_store`.`producer` (`name`) VALUES (?);");
			ps.setString(1,producer.getName());
		return ps;
	}
//######################################## END SAVE ############################################	
	
//####################################### UPDATE ###############################################
	
	public static void update(Producer producer) {
		log.info("atualisando producer : {}",producer);
		try (Connection conn = ConnectionFactory.getConnection();
			 PreparedStatement ps= creatPreparedStatementUpdate(conn,producer)){

				ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			log.info("erro ao atualizar {}",producer);
		}
		
	}

	
	private static PreparedStatement creatPreparedStatementUpdate(Connection conn, Producer producer) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("UPDATE `anime_store`.`producer` SET `name` = ? WHERE (`id` = ?);");
		ps.setString(1, producer.getName());
		ps.setInt(2, producer.getId());
	return ps;
	}
	
	
	public static Optional<Producer> findByIdToUpdate(int id) {
		log.info("finding Producer by name '{}'",id);
		
		try (Connection conn = ConnectionFactory.getConnection();
			 PreparedStatement ps = creatPrepareStatmanFindByIdToUpdate(conn,id);
			 ResultSet rs = ps.executeQuery()){
				
				if(!rs.next())return Optional.empty();
				
				return Optional.of(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Optional.empty();
	}
	/**
	 * @param conn
	 * @param name
	 * @return PreparedStatement
	 * @throws SQLException 
	 */
	private static PreparedStatement creatPrepareStatmanFindByIdToUpdate(Connection conn, int id) throws SQLException {
			String sql="SELECT * FROM anime_store.producer where id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
		return ps;
	}

	
//####################################### END UPDATE ###############################################
	
	
	
}
