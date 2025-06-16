package teste;

import java.sql.Connection;

import dominio.Producer;
import services.ProducerServices;
/*nesta aula veremos  como fazer par atualizar um campo utilisando 
 * o msm row set "JdbcRowSet"
 */

/*incompleto  minuto 6:40*/

public class ConnectionFactoryTest {
	public static void main(String[] args) {	
		
		//System.out.println(ProducerServices.findByNameJdbcRowSet("kacarot"));
		
		ProducerServices.update(ProducerServices.PreUp("kacaroto"),"kalamar");
		
		
		System.out.println("fim");
	}
}
