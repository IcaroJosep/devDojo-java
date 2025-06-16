package teste;

import java.sql.Connection;

import dominio.Producer;
import services.ProducerServices;
/*Você está falando sobre RowSet em Java JDBC, que é
 *uma extensão da interface ResultSet, oferecendo mais flexibilidade e funcionalidades. 
 *Vamos destrinchar cada uma dessas características:

✅ Pode manter uma conexão ou pode desconectar do banco de dados
Existem dois tipos de RowSet:

	Connected RowSet (Conectado): Mantém a conexão aberta com o banco enquanto 
	navega pelos dados. Ex.: JdbcRowSet.
	
	Disconnected RowSet (Desconectado): Recupera os dados e fecha a conexão imediatamente.
	Os dados ficam disponíveis localmente na memória. Ex.: CachedRowSet.
	
	Isso permite trabalhar com dados mesmo sem estar conectado ao banco, economizando recursos.

✅ Pode ser serializado
	Um RowSet desconectado, como CachedRowSet, implementa a interface Serializable.
	Isso significa que você pode salvar o estado do RowSet (em disco, em arquivo, etc.) 
	ou transmiti-lo por rede.

✅ Pode ser mandado via network (rede)
	Graças à serialização, um RowSet desconectado pode ser enviado por rede para outras aplicações Java.
	Isso é útil, por exemplo, em aplicações distribuídas, Web Services, ou aplicações cliente-servidor.

✅ É um JavaBean
	Sim, RowSet segue as convenções de um JavaBean:
	Tem construtor padrão (sem argumentos).
	Possui métodos getters e setters.
	Suporte a eventos (listeners), como RowSetListener, para ser notificado quando dados são alterados.
	Isso facilita sua integração com ferramentas gráficas, IDEs e frameworks.

✅ É scrollable e updatable
	Por padrão, um RowSet é:
	Scrollable (Rolável): Pode navegar livremente pelos dados (próximo, anterior, primeiro, último, absoluto).
	Updatable (Atualizável): Permite alterar dados diretamente no RowSet e depois sincronizar essas alterações
	com o banco (no caso dos desconectados, quando a conexão for reestabelecida).

🔍 Resumo das Características do RowSet em JDBC:
			Característica								Descrição
		Conectado ou Desconectado		Funciona com e sem conexão ativa no banco.
		Serializável					Pode ser salvo ou transmitido.
		Transmissão via Rede			Pode ser enviado entre aplicações através de rede.
		JavaBean						Segue padrões JavaBean: getters/setters, eventos, construtor padrão.
		Scrollable & Updatable			Permite navegação completa e atualização dos dados.
*/

/*
 nesta aula foi feito um novo tipo de coneçao na connectionFactori chamado jdbcRowSet
 para ser utilizada no  mertodo findByName em Producer repository.
 */

public class ConnectionFactoryTest {
	public static void main(String[] args) {	
		
		System.out.println(ProducerServices.findByNameJdbcRowSet("kacarot"));
		
		System.out.println("fim");
	}
}
