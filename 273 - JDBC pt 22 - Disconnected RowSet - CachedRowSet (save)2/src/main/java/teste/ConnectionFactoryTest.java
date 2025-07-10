package teste;

import java.sql.Connection;
import java.util.List;

import dominio.Producer;
import lombok.extern.log4j.Log4j2;
import services.ProducerService;
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
        ProducerService producerService = new ProducerService();
        
        // Listar producers antes da atualização
        System.out.println("ANTES DA ATUALIZAÇÃO:");
        producerService.listAllProducers();
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Atualizar o producer com ID 1 para o nome "Studio Ghibli Updated"
        producerService.producerServicesUpdate(2, "asd");
        
       
    }
}
