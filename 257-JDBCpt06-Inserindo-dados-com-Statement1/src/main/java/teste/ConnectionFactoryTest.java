package teste;
/* aci uma demostraçao basica de uma conecça com banco de dados mysql
 * comtida nos qrquivos src/main/java (.com) , (teste) e tbm no arquivo (pom.xml)
 * comsidere que q o serviço mysql ja vai instado previamente com coneçao pela porta
 * 3306 e o banco anime ja foi criado .
 * */
import com.ConnectionFactory;

import dominio.Producer;
import repository.ProducerRepository;

public class ConnectionFactoryTest {
	public static void main(String[] args) {	
		
		
	 Producer a = new Producer.Builder()
			 .name("josedp")
			 .builder();
	 
	 	ProducerRepository.save(a);
	 	
	 System.out.println("fim");
	}
}
//conectado