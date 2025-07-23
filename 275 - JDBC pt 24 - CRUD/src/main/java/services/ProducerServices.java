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
		
	public static Connection conecao(String usser,String senha) throws SQLException {
		Connection conn = ConnectionFactory.getConnection(Usser.builder().usser(usser).senha(senha).build());
		return conn;	
	}
	
	public static void listaProducer(Connection con , Scanner scn,int op) {
		List<Producer> lista=ProducerRepository.listaProducer(con);
		System.out.println(lista);
		System.out.println("para esporta : 1 ,para volta:qualquer tecla");
			
		if ((op=scn.nextInt())==1) {
			exporar(lista);
		}
	}
	
	private static void exporar(List<Producer> lista) {
		ProducerRepository.exportarXml(lista);
	}

	public static void adicionaProducer(Connection con ,Scanner scn) {
		System.out.println("incira o nome o producer a ser adicionado:");
		scn.nextLine();
		ProducerRepository.incerir(con, scn.nextLine());
	}
	
}
