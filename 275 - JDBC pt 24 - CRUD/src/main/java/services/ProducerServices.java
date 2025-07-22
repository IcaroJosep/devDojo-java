package services;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ConnectionFactory;
import com.Usser;


import dominio.Producer;
import repository.ProducerRepository;

public class ProducerServices {
		
	public static Connection Conecao(String usser,String senha) throws SQLException {
		Connection conn = ConnectionFactory.getConnection(Usser.builder().usser(usser).senha(senha).build());
		return conn;	
	}
	
	public static void ListaProducer(Connection con) {
		System.out.println(ProducerRepository.listaProducer(con));
	}
	
	public static void adicionaProducer(Connection con ,Scanner scn) {
		System.out.println("incira o nome o producer a ser adicionado:");
		scn.nextLine();
		ProducerRepository.incerir(con, scn.nextLine());
	}
	
}
