package teste;

import dominio.Producer;
import services.ProducerServices;
/*nesta aula a a esploracao do TYPE SCROLL INSENSITIVE
 * com leituras de cima pra baixo ,baixo pra cima e posiçao expecitca etc.. 
 * 
 * #atribuço de novo metodo em ProducerRepository "shoTipeScrollWorcking"
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
		
		ProducerServices.findByNameAndIncertWhenNotFound("caracu");
		System.out.println("fim");
	}
}
