package teste;

import java.sql.Connection;
import java.util.List;

import dominio.Producer;
import lombok.extern.log4j.Log4j2;
import services.ProducerServices;
/*nesta aula veremos  como fazer par atualizar um campo utilisando 
 * o msm row set "JdbcRowSet"
 * implementaçoes:
 * listiner na classe: CustomRowSetListiners.java
 * metodo Update em producerRepositori
 */



@Log4j2
public class ConnectionFactoryTest {
	public static void main(String[] args) {	
		
		//System.out.println(ProducerServices.findByNameJdbcRowSet("kacarot"));
		
		
			// procura todosos producer q corepondao a o primeiro parametro e 
			// modifica o nome do primeiro producer encontrad para o segundo parametro
		ProducerServices.update("kalamar","kacaroto");
		
		List<Producer> producers = ProducerServices.findByNameJdbcRowSet("");
		log.info(producers);
	
		System.out.println("fim");
	}
}
