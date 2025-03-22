package com;
//bibliotecas de usso de banco de dados
import java.sql.Connection;//Importa a interface Connection do pacote java.sql. Essa interface representa uma conexão com o banco de dados.
import java.sql.DriverManager;//Importa a classe DriverManager do pacote java.sql. Essa classe é usada para estabelecer conexões com bancos de dados.
import java.sql.SQLException;//Importa a classe SQLException do pacote java.sql. Essa classe representa uma exceção que pode ocorrer durante operações com o banco de dados.

public class ConnectionFactory {// Declara uma classe pública chamada ConnectionFactory. Essa classe tem a responsabilidade de criar e fornecer conexões com o banco de dados.
	
	public static Connection getConnection() throws SQLException {// Especifica que o método retorna um objeto do tipo Connection, que representa a conexão com o banco de dados.
		
		String url = "jdbc:mysql://localhost:3306/anime_store";/*Define uma variável url que armazena a URL de conexão com o banco de dados MySQL.
													jdbc:mysql: Prefixo que indica que a conexão é com um banco de dados MySQL usando JDBC.
													localhost:3306: Endereço do servidor MySQL (localhost significa que está na mesma máquina) e a porta (3306 é a porta padrão do MySQL).			
													anime_store: Nome do banco de dados que será acessado.*/
		String username= "root";//usuario			
		String password= "icaro";//senha
		
	
		return 	DriverManager.getConnection(url,username,password);

		
	}
}