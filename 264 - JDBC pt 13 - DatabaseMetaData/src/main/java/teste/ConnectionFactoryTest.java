package teste;
/* nesta ala exploramos a DatabaseMetadata 
 * Serve para recuperar informações sobre o banco de dados em si e o driver JDBC.
 * Analogia:
 * "É como perguntar: “Quais são as capacidades e características do sistema de banco de dados que estou conectado?”
 * 
	 * O que DatabaseMetaData faz:
	Ela permite você consultar informações sobre:
	
	Nome do banco (getDatabaseProductName())
	
	Nome do driver JDBC (getDriverName())
	
	Suporte a transações, joins, subconsultas etc.
	
	Tipos de ResultSet suportados
	
	Lista de tabelas, colunas, chaves primárias e estrangeiras
	
	Procedimentos armazenados, tipos SQL definidos no banco
	
	Se o banco suporta views, schemas, etc.
	
	💡 Ou seja, você pode "explorar" e entender como o banco está estruturado, mas não pode alterar nada com DatabaseMetaData.
 * 
 * por fim na clase ProducerRepositori avara a implementaçao 
 * de um metodo showDriverMetadata :
 * Oque ocorre dentro deste metodo é a a captura dos metadados e drives jdbc atraves do databeseMetadata
 * e atraves dele é perguntado :
	   "Você suporta um ResultSet que seja apenas para frente (TYPE_FORWARD_ONLY ,etc), 
	   	mas que possa ser usado para atualizar os dados diretamente no banco (CONCUR_UPDATABLE)?”
	
		Se a resposta for sim, significa que você poderá usar métodos como:
		
		rs.updateString("coluna", "novo valor");
		
		rs.updateRow();
		
		rs.deleteRow();
		
		rs.insertRow();
		
		Diretamente no objeto ResultSet."
 * */

import dominio.Producer;
import services.ProducerServices;

public class ConnectionFactoryTest {
	public static void main(String[] args) {	
			
		/*Producer a = Producer.builder().name("kome ku").build();
		 
		 	ProducerServices.save(a);
		 */
		//ProducerServices.delet(5);
		
		//ProducerServices.update(28,"machado");
		
		
		
		//System.out.println(ProducerServices.findAll());
		
		//System.out.println(ProducerServices.findByName("k"));
		
		//ProducerServices.showProducerMetadata();
		
		ProducerServices.showDriverMetadata();	
		
		System.out.println("fim");
	}
}