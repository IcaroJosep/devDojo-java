package teste;
/*result set é bem mas poderoso doq so traser dados  comop poresemplo 
 * trabalhar com meta dados pos ele esta conectado diretamanete a tabela
 * 
 * nesta alula o usaremos para pegar os meta dados :
 * imagine q a tabela e d um sistema estrangeiro e tu nao sabe q dados ela comtem
 * usaremos result ser para pegar o atabela vermos seus campos e seus comteudos.
 * 
 * a implemntaçao do metodo estara em "ProducerRepository" no metodo com nome :showProducerMetadata.
 * 
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
		
		ProducerServices.showProducerMetadata();
		
		System.out.println("fim");
	}
}