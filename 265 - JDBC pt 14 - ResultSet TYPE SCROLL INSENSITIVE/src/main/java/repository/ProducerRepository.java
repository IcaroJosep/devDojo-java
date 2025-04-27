package repository;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
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
	
	public static List<Producer> findAll() {
	/* log.info("buscando todos os Producers");
		String sql = "SELECT id ,name FROM anime_store.producer;";
		List<Producer> producers = new ArrayList<>();

		try(Connection con = ConnectionFactory.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql)){//rersultset: � outra biblioteca diferente de "statment" o comando esta sendo executado dentro dos parametros para q seja fechado altomaticamentem assim como os demais
												   //ele � criado apartir de um stetemant
			
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
	*/
		return findByName("");
	}
	
	public static List<Producer> findByName(String name) {
		if (name!="") {
			log.info("buscando por '%s' em Producers".formatted(name));
		}else {
			log.info("buscando todos os Producers");
		}
		
		String sql = "SELECT * FROM anime_store.producer where name like '%%%s%%';".formatted(name);
		List<Producer> producers = new ArrayList<>();

		try(Connection con = ConnectionFactory.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql)){//rersultset: � outra biblioteca diferente de "statment" o comando esta sendo executado dentro dos parametros para q seja fechado altomaticamentem assim como os demais
												   //ele � criado apartir de um stetemant
			
			while (rs.next()) {//chama o procimo dado
				//int id = rs.getInt("id");//a lib ResultSet permite capiturar direto do banco camando pelo nome ou coluna
				//String name1 = rs.getString("name");
				//producers.add(Producer.builder().id(id).name(name1).build()); 
				producers.add(
						Producer.builder()
						.id(rs.getInt("id"))
						.name(rs.getString("name"))
						.build()
						);
			}
		} catch (SQLException e) {
			log.error("Erro na busca de de 'todos os produces' ",e);
			
		}
		return producers;
	}	
	
	
	public static void showProducerMetadata() {
		
			log.info("show Producer Metadata");
	
		String sql = "SELECT * FROM anime_store.producer;";	

		try(Connection con = ConnectionFactory.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql)){
				
				ResultSetMetaData rsMetadata = rs.getMetaData();
				
				int columCount = rsMetadata.getColumnCount();
				log.info("quantidade de colunas '{}'",columCount);
				

				log.info("table name : '{}'",rsMetadata.getTableName(columCount));
				for (int i = 1; i <= columCount; i++) {

					log.info("-------------------------------------------------");
					log.info("colun name : '{}'",rsMetadata.getColumnName(i));
					log.info("colun size : '{}'",rsMetadata.getColumnDisplaySize(i));
					log.info("colun tipe : '{}'",rsMetadata.getColumnTypeName(i));
				}
				
		
		} catch (SQLException e) {
			log.error("Erro na busca de de 'todos os produces' ",e);
			
		}
	}
	
	public static void showDriverMetadata() {
		
		log.info("show Driver Metadata");

		try(Connection con = ConnectionFactory.getConnection();){
			
			DatabaseMetaData DbMetaData = con.getMetaData();
			
			/*O que é testado aqui?
			 * Verifica se o driver suporta result sets apenas para leitura e somente para frente 
			 * (ou seja, não permite mover o cursor para trás nem alterar dados).
			 * É o tipo mais simples e mais amplamente suportado de ResultSet.*/
			if (DbMetaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
				log.info("suportado TYPE_FORWARD_ONLY.. ");
				
				/*Verifica se é possível atualizar os dados diretamente através do ResultSet
				 *(com updateRow(), deleteRow(), etc),
				 * mesmo quando o tipo de ResultSet é TYPE_FORWARD_ONLY.*/
				if(DbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE)) {
					log.info("e suportado CONCUR_UPDATABLE.. ");	
				}
			
			}
			
			/*O que é testado aqui?
			 * Verifica se o driver suporta navegação no ResultSet para frente e para trás,
			 * sem refletir alterações feitas no banco depois da consulta.*/
			if (DbMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
				log.info("suportado TYPE_SCROLL_INSENSITIVE.. ");
				
				/*Verifica se é possível atualizar os dados diretamente através do ResultSet
				 *(com updateRow(), deleteRow(), etc),
				 * mesmo quando o tipo de ResultSet é TYPE_SCROLL_INSENSITIVE*/
				if(DbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)) {
					log.info("e suportado CONCUR_UPDATABLE.. ");
					
				}
			
			}
			
			/*O que é testado aqui?
			 * Verifica se o driver suporta ResultSet que permite navegação para frente e para trás,
			 * refletindo alterações no banco feitas por outros usuários após o SELECT original.*/
			if (DbMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
				log.info("suportado TYPE_SCROLL_SENSITIVE.. ");
				
				/*Verifica se é possível atualizar os dados diretamente através do ResultSet
				 *(com updateRow(), deleteRow(), etc),
				 * mesmo quando o tipo de ResultSet é TYPE_SCROLL_SENSITIVE */
				if(DbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE)) {
					log.info("e suportado CONCUR_UPDATABLE.. ");
					
				}
			
			}else {
				log.info("TYPE_SCROLL_SENSITIVE insupported");
			}
				
			
		} catch (SQLException e) {
			log.error("Erro na busca de de 'todos os produces' ",e);
		
		}
	}
	
	public static void showTipeScrollWorcking(String name) {
		
		
		String sql = "SELECT * FROM anime_store.producer ;";

		try(Connection con = ConnectionFactory.getConnection();
			Statement stmt = con.createStatement(
					//quando estamos criando a Stetement presisamos falar com q tipo de 
					//resutSet quermos trabalhar e tbm a parte da comcorency
					
					ResultSet.TYPE_SCROLL_INSENSITIVE	//permite leitura bidirecional e não sensível a alterações no banco após a consulta,
					,ResultSet.CONCUR_UPDATABLE	 		//permite atualização (update) dos dados no próprio ResultSet. 
					);
			ResultSet rs = stmt.executeQuery(sql)){
			
			//a parte se cima e baixo sao relativas a quary feita nao sao pegados diretamente do banco
			//portando se a comsuta q tu faz em "sql" pega a tabela de baixo para cima o utimo dado sera o primeiro da tabela
			
			log.info("rs.last() :coloca o ponteiro na utima posiçao : {}",rs.last());
			log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
			log.info("rs.previous():volta o ponteiro uma posiçao : {}",rs.previous());
			log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
			log.info("rs.next(): avança o pontero uma posiçao : {}",rs.next());
			log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
			log.info("rs.first():posiciona na primeira a posiao : {}",rs.first());
			log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
			log.info("rs.absolute(4):posiciona na poziçao indicada : {}",rs.absolute(4));
			log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
			log.info("rs.relative(-2):decrementa ou encrementa a posiçao : {}",rs.relative(-2));
			log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
			
				
		} catch (SQLException e) {
			log.error("Erro na busca de de 'todos os produces' ",e);
			
		}
	}
	
		
	
}
