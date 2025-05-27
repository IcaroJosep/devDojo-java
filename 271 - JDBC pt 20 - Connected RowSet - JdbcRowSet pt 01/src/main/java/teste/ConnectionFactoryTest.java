package teste;

import java.sql.Connection;

import dominio.Producer;
import services.ProducerServices;
/*Em Java, dentro da API JDBC (Java Database Connectivity), a interface CallableStatement
 *é usada para executar procedimentos armazenados (stored procedures) no banco de dados.
	
  📌 O que é um CallableStatement?
  É uma subinterface de PreparedStatement que permite chamar procedimentos armazenados 
  no banco de dados, os quais podem ter parâmetros de entrada (IN), saída (OUT) ou entrada/saída (INOUT).
*/


public class ConnectionFactoryTest {
	public static void main(String[] args) {	
		
		System.out.println(ProducerServices.findByNameJdbcRowSet("kacarot"));
		
		System.out.println("fim");
	}
}
