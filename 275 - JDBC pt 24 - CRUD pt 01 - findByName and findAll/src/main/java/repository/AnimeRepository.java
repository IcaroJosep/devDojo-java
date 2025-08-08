package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import dominio.Anime;
import dominio.Producer;

import com.ConnectionFactory;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class AnimeRepository {
	//##################################### FIND BY NAME ######################################################3
		public static List<Anime> findByName(String name) {
			log.info("finding Anime by name '{}'",name);
			List<Anime> animes= new ArrayList<>();
			try (Connection conn = ConnectionFactory.getConnection();
				 PreparedStatement ps = creatPrepareStatmanFindByName(conn,name);
				 ResultSet rs = ps.executeQuery()){
					
					while (rs.next()) {
						
						animes.add(Anime.builder()
								.id(rs.getInt("id"))
								.name(rs.getString("name"))
								.episodes(rs.getInt("episodes"))
								.producer(ProducerRepository.findByIdToUpdate(rs.getInt("producer_id")).orElse(null))
								.build());
					}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return animes;
		}
		
	
		/**
		 * @param conn
		 * @param name
		 * @return PreparedStatement
		 * @throws SQLException 
		 */
		private static PreparedStatement creatPrepareStatmanFindByName(Connection conn, String name) throws SQLException {
				String sql="SELECT * FROM anime_store.anime where name like ?;";
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
				String sql = "DELETE FROM `anime_store`.`anime` WHERE (`id` = ?);";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1,id);
			return ps;
		}
	//####################################### END delete	####################################

	//######################################## SAVE ############################################
		//obs : od de producer pode ser incerido sem relaçao com nenhum producer!!!!!
		public static void save(Anime anime) {
			log.info("salvando anime = '{}'",anime);
			try (Connection conn = ConnectionFactory.getConnection();
					PreparedStatement ps = createPreparedStatement(conn,anime)){
					log.info("linha adicinada {}",!ps.execute());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
		private static PreparedStatement createPreparedStatement(Connection conn, Anime anime) throws SQLException {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO `anime_store`.`anime` (`name`, `episodes`, `producer_id`) VALUES (?, ?, ?);");
				ps.setString(1,anime.getName());
				ps.setInt(2,anime.getEpisodes());
				ps.setInt(3,anime.getProducer().getId());
			return ps;
		}
	//######################################## END SAVE ############################################	
		
	//####################################### UPDATE ###############################################
		
		public static void update(Anime anime) {
			//so atualiza numero de ep's
			log.info("atualisando ep's de anime : {}",anime);
			try (Connection conn = ConnectionFactory.getConnection();
				 PreparedStatement ps= creatPreparedStatementUpdate(conn,anime)){

					ps.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
				log.info("erro ao atualizar {}",anime);
			}
			
		}

		
		private static PreparedStatement creatPreparedStatementUpdate(Connection conn, Anime anime) throws SQLException {
			PreparedStatement ps = conn.prepareStatement("UPDATE `anime_store`.`anime` SET `episodes` = ? WHERE (`id` = ?);");
			ps.setInt(1, anime.getEpisodes());
			ps.setInt(2, anime.getId());
		return ps;
		}
		
		
		public static Optional<Anime> findByIdToUpdate(int id) {
			log.info("finding Anime by name '{}'",id);
			
			try (Connection conn = ConnectionFactory.getConnection();
				 PreparedStatement ps = creatPrepareStatmanFindByIdToUpdate(conn,id);
				 ResultSet rs = ps.executeQuery()){
					
					if(!rs.next())return Optional.empty();
					
					return Optional.of(Anime.builder()
							.id(rs.getInt("id"))
							.name(rs.getString("name"))
							.producer(ProducerRepository.findByIdToUpdate(rs.getInt("producer_id")).orElse(null))
							.build());
				
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
				String sql="SELECT * FROM anime_store.anime where id = ?;";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1,id);
			return ps;
		}
		
	//####################################### END UPDATE ###############################################
		
		
		
}
