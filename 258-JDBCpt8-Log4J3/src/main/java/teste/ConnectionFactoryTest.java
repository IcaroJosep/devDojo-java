package teste;
import dominio.Producer;
import repository.ProducerRepository;

public class ConnectionFactoryTest {
	public static void main(String[] args) {	
		
		
	 
	Producer a = Producer.builder().name("asdfgg").build();
	 
	 	ProducerRepository.save(a);
	 	
	 
	 System.out.println("fim");
	}
}
/* sera adicionado logs "log4j2" : adicionado arq em src/main/resurces com xml de comfigura�ao
 * log introduzido em producerRepository
 * 
 * 
 * 
 * Os logs em Java, como os implementados pela biblioteca Log4j2, servem para v�rias fun��es essenciais no desenvolvimento e manuten��o de software:

Depura��o e diagn�stico - Permitem acompanhar o fluxo de execu��o do programa e identificar problemas durante o desenvolvimento
Monitoramento em tempo real - Oferecem visibilidade sobre o comportamento do aplicativo em produ��o
An�lise p�s-mortem - Facilitam a investiga��o de falhas ap�s sua ocorr�ncia
Auditoria - Registram a��es importantes do sistema, permitindo rastrear atividades dos usu�rios

O Log4j2 especificamente � uma biblioteca de logging poderosa para Java que oferece:

Configura��o flex�vel - Pode ser configurado via arquivos XML, JSON, YAML, propriedades ou programaticamente
Performance superior - � significativamente mais r�pido que vers�es anteriores e outras bibliotecas de log
N�veis de severidade - Permite classificar mensagens como TRACE, DEBUG, INFO, WARN, ERROR e FATAL
Appenders variados - Permite enviar logs para console, arquivos, bancos de dados, servi�os remotos, etc.
Layouts personaliz�veis - Define como as mensagens s�o formatadas
Filtros - Controla quais mensagens s�o processadas com base em crit�rios diversos
 * 
 */