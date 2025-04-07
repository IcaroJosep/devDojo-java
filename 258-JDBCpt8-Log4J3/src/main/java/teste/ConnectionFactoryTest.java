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
/* sera adicionado logs "log4j2" : adicionado arq em src/main/resurces com xml de comfiguraçao
 * log introduzido em producerRepository
 * 
 * 
 * 
 * Os logs em Java, como os implementados pela biblioteca Log4j2, servem para várias funções essenciais no desenvolvimento e manutenção de software:

Depuração e diagnóstico - Permitem acompanhar o fluxo de execução do programa e identificar problemas durante o desenvolvimento
Monitoramento em tempo real - Oferecem visibilidade sobre o comportamento do aplicativo em produção
Análise pós-mortem - Facilitam a investigação de falhas após sua ocorrência
Auditoria - Registram ações importantes do sistema, permitindo rastrear atividades dos usuários

O Log4j2 especificamente é uma biblioteca de logging poderosa para Java que oferece:

Configuração flexível - Pode ser configurado via arquivos XML, JSON, YAML, propriedades ou programaticamente
Performance superior - É significativamente mais rápido que versões anteriores e outras bibliotecas de log
Níveis de severidade - Permite classificar mensagens como TRACE, DEBUG, INFO, WARN, ERROR e FATAL
Appenders variados - Permite enviar logs para console, arquivos, bancos de dados, serviços remotos, etc.
Layouts personalizáveis - Define como as mensagens são formatadas
Filtros - Controla quais mensagens são processadas com base em critérios diversos
 * 
 */