package teste;

import dominio.Producer;
import services.ProducerServices;
/*nesta aula a a esploracao do TYPE SCROLL INSENSITIVE e CONCUR_UPDATABLE
 * 
 * para incrementar e deletar da tabela producer "banco de dados"
 * diretamente pelo resultset ou seja sem a nesecidade de um segundo sql
 * 
 * #atribuço de novo metodo em ProducerRepository 
 * "FindByNameDelet" e "findByNameAndIncertWhenNotFound".
 * 
 * 
 * */



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
		
	//	ProducerServices.findByNameAndIncertWhenNotFound("ka");
	//	ProducerServices.delet("mi");//deletad todos cuidado
		
		
		System.out.println("fim");
	}
}
