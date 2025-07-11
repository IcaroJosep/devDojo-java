package teste;

import java.util.List;

import dominio.Producer;
import services.ProducerServices;

/*obcerve producerRepository
 * 
	O método saveTransaction tenta salvar vários produtores dentro de uma transação única.
	
	Se todos os inserts derem certo, ele comita.
	
	Se qualquer um falhar, ele faz rollback de tudo e não salva ninguém.
	
	Isso garante a consistência do banco (ou tudo ou nada).
 * 
 */

public class ConnectionFactoryTest {
	public static void main(String[] args) {	
		
		ProducerServices.saveTA(List.of(
				Producer.builder().name("igor").build(),
				Producer.builder().name("agnaldo").build(),
				Producer.builder().name("angelica").build()
				));

	}
}
