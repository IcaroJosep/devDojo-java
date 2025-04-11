package teste;




import services.ProducerServices;

public class ConnectionFactoryTest {
	public static void main(String[] args) {	
			
		/*Producer a = Producer.builder().name("josep").build();
		 
		 	ProducerServices.save(a);
		 */
		//ProducerServices.delet(5);
		
		//ProducerServices.update(28,"machado");
		
		
		
		System.out.println(ProducerServices.findAll());
		
		
		System.out.println("fim");
	}
}