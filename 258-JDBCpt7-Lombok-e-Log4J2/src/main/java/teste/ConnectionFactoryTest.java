package teste;
import dominio.Producer;
import repository.ProducerRepository;

public class ConnectionFactoryTest {
	public static void main(String[] args) {	
		
		
	 
	Producer a = Producer.builder().name("rfdqqqf").build();
	 
	 	ProducerRepository.save(a);
	 	
	 System.out.println("fim");
	}
}
//conectado