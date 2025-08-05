package repository;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import dominio.Producer;
import lombok.extern.log4j.Log4j2;


@Log4j2
public  class ProducerRepository {
	
	
	
	
	public static List<Producer> listaProducer(Connection conn) {
		//String sql= "SELECT * FROM anime_store.producer;";
		List<Producer> producers = new ArrayList<>();
		
		try (Connection conn1 = conn ;
			Statement stmt = conn1.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM anime_store.producer;")){
			
			while (rs.next()) {
				producers.add(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			log.warn("erro na captura");
		}
		
		return producers;
	}
	
	
	public static void exportarXml(List<Producer> lista) {
		   File xmlFile = new File("C:\\Users\\icaro\\Desktop\\saida.xml");
	        try(FileWriter writer = new FileWriter(xmlFile)) {
	        	 writer.write("<itens>\n");
	        	 
	        	 for (Producer item : lista) {
	                 writer.write("  <item>\n");
	                 writer.write("    <id>" + item.getId() + "</id>\n");
	                 writer.write("    <nome>" + item.getName() + "</nome>\n");
	                 writer.write("  </item>\n");
	             }
	        	 writer.write("</itens>");
	        	 
	        	 System.out.println("Arquivo XML salvo com sucesso em: " + xmlFile.getAbsolutePath());

	        	 
			} catch (IOException e) {
				e.printStackTrace();			}
		
	}
	
	
	public static void incerir(Connection conn,String name) {
		//String sql ="INSERT INTO `anime_store`.`producer` (`name`) VALUES (?);";
		try (PreparedStatement pstm= conn.prepareStatement("INSERT INTO `anime_store`.`producer` (`name`) VALUES (?);")){
			pstm.setString(1,name);
			System.out.printf("linhas afetadas %d\n", pstm.executeUpdate());
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	
	
	
		
		
	
}
