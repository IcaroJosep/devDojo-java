package teste;




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
		
		System.out.println(ProducerServices.findByName("k"));
		
		
		System.out.println("fim");
	}
}