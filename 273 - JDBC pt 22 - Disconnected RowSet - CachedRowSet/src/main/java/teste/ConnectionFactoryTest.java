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


// aviso nao seg a aula codigo dentro de repositori retirado do chatgpt (faz uso de prepareStetmen)

//estou indo enfrente sem intender copletamente


@Log4j2
public class ConnectionFactoryTest {
	public static void main(String[] args) {	
		
		//System.out.println(ProducerServices.findByNameJdbcRowSet("kacarot"));
		
		
			// procura todosos producer q corepondao a o primeiro parametro e 
			// modifica o nome do primeiro producer encontrad para o segundo parametro
		ProducerServices.update("kacaroto","kalamar");
		
		List<Producer> producers = ProducerServices.findByNameJdbcRowSet("");
		log.info(producers);
	
		System.out.println("fim");
	}
}
