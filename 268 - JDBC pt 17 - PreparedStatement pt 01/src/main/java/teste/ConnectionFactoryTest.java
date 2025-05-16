package teste;

import dominio.Producer;
import services.ProducerServices;
/* O que é PreparedStatement?
	O PreparedStatement é uma interface do JDBC usada para executar comandos 
	SQL com parâmetros (valores que você insere depois). É mais seguro e eficiente 
	do que usar Statement.
	
	✅ Por que usar PreparedStatement?
	Evita SQL Injection (ataques maliciosos no banco de dados).
	Melhora a performance, pois o SQL é pré-compilado.
	Facilita a reutilização do código com diferentes valores.
	
	ex: ele devidne o local onde sera incerido o dado com ?
	para a incerçao posterior e precompila o sql
	quando tu vai incerir faz a indicaçao de tipo ".setString(value)" indicaçao de string
	assim o sql travta o valo como oq sera incereido em uma selula nao como parte do sql
	
	
	NESSTA AULA:
	PORRAO INCERIDOS DOIS METODOS NA NA CLASSE PRODUCERREPOSITORY
	CLASSE 1 : findByNamePreperdStetement 
	CLASSE 2 : prepareStatman , esta em si é uma exraçao para retirar a complecidade da primeira (é possivel fazer sem!) 
		
*/


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
		
		//ProducerServices.showDriverMetadata();	
		
	    //ProducerServices.showTipeScrollWorcking();
		
		//ProducerServices.findByNameAndUpdateUpperLowCase("sasuke",false);
		
		//ProducerServices.findByNameAndIncertWhenNotFound("caracu");
	
		ProducerServices.findByNamePreperdStetement("sasuke");
		
		System.out.println("fim");
	}
}
