package teste;

import java.sql.Connection;

import dominio.Producer;
import services.ProducerServices;
/*nessta aula fizemos o metodo update utilizando prepardStatmen
*
*atraves de  dois metodos comtidos em producerRepository.java
*	sendo :
*		# updatePrepardStatman(Producer producer) ;
*		e seu metodo acoplado 
*		# prepardStatmenUpdade(Connection con, Producer producer);
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
		
		ProducerServices.showDriverMetadata();	
		
	    //ProducerServices.showTipeScrollWorcking();
		
		//ProducerServices.findByNameAndUpdateUpperLowCase("sasuke",false);
		
		//ProducerServices.findByNameAndIncertWhenNotFound("caracu");
	
		//ProducerServices.findByNamePreperdStetement("sasuke"); 
		
		//ProducerServices.updatePrepardStatman(Producer.builder().id(12).name("kacaroto").build());
		System.out.println("fim");
	}
}
