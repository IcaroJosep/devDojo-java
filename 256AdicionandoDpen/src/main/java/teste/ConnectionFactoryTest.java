package teste;
/* aci uma demostra�ao basica de uma conec�a com banco de dados mysql
 * comtida nos qrquivos src/main/java (.com) , (teste) e tbm no arquivo (pom.xml)
 * comsidere que q o servi�o mysql ja vai instado previamente com cone�ao pela porta
 * 3306 e o banco anime ja foi criado .
 * */
import com.ConnectionFactory;

public class ConnectionFactoryTest {

	public static void main(String[] args) {
		
		System.out.println(ConnectionFactory.getConnection());
	}

}
//conectado