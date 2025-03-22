package com;
//bibliotecas de usso de banco de dados
import java.sql.Connection;//Importa a interface Connection do pacote java.sql. Essa interface representa uma conex�o com o banco de dados.
import java.sql.DriverManager;//Importa a classe DriverManager do pacote java.sql. Essa classe � usada para estabelecer conex�es com bancos de dados.
import java.sql.SQLException;//Importa a classe SQLException do pacote java.sql. Essa classe representa uma exce��o que pode ocorrer durante opera��es com o banco de dados.

public class ConnectionFactory {// Declara uma classe p�blica chamada ConnectionFactory. Essa classe tem a responsabilidade de criar e fornecer conex�es com o banco de dados.
	
	public static Connection getConnection() throws SQLException {// Especifica que o m�todo retorna um objeto do tipo Connection, que representa a conex�o com o banco de dados.
		
		String url = "jdbc:mysql://localhost:3306/anime_store";/*Define uma vari�vel url que armazena a URL de conex�o com o banco de dados MySQL.
													jdbc:mysql: Prefixo que indica que a conex�o � com um banco de dados MySQL usando JDBC.
													localhost:3306: Endere�o do servidor MySQL (localhost significa que est� na mesma m�quina) e a porta (3306 � a porta padr�o do MySQL).			
													anime_store: Nome do banco de dados que ser� acessado.*/
		String username= "root";//usuario			
		String password= "icaro";//senha
		
	
		return 	DriverManager.getConnection(url,username,password);

		
	}
}