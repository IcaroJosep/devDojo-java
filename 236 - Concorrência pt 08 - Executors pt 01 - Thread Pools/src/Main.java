/*
	Execução concorrente: Sim, Executor e ExecutorService fornecem uma maneira elegante de 
	executar múltiplas tarefas concorrentemente, sem a necessidade de gerenciar manualmente a 
	criação e sincronização de threads.
	
	Gerenciamento de threads: O Thread Pool centraliza o gerenciamento de threads, incluindo:
		
		Criação: Um conjunto inicial de threads é criado ao instanciar o pool.
		
		Reutilização: As threads são reutilizadas para executar novas tarefas, evitando o overhead 
		de criar threads a cada nova tarefa.
		
		Limpeza: O pool gerencia a limpeza de threads que não estão mais em uso, liberando 
		recursosdo sistema.
		
	Flexibilidade: Thread Pools oferecem diferentes configurações para atender a diversas necessidades:
		
		Número máximo de threads: Permite limitar o número de threads concorrentes, evitando 
		sobrecarregar o sistema.
		
		Tipos de pool: Existem diferentes tipos de pools (FixedThreadPool, CachedThreadPool, 
		SingleThreadExecutor, ScheduledThreadPool) para atender a diferentes padrões de uso.
		
		Políticas de fila: A forma como as tarefas são enfileiradas e executadas pode ser configurada.
		
	
	Outros benefícios e considerações:
	
		Melhora do desempenho: Ao reutilizar threads, reduz-se o overhead de criação e destruição de threads, 
		o que pode levar a um ganho significativo de desempenho em aplicações com muitas tarefas concorrentes.
		
		Simplificação do código: Abstrai a complexidade da concorrência, permitindo que você se concentre na 
		lógica da sua aplicação.
		
		Facilidade de uso: A API ExecutorService fornece métodos intuitivos para submeter tarefas, controlar 
		a execução e encerrar o pool.
		
		Escalabilidade: Thread Pools podem ser configurados para escalar de acordo com a carga de trabalho 
		da sua aplicação.
		
		Gerenciamento de exceções: É importante tratar as exceções que ocorrem nas tarefas para evitar que 
		o pool entre em um estado inconsistente.
		
	Em resumo:
	Thread Pools são uma ferramenta essencial para qualquer desenvolvedor Java que trabalha com 
	aplicações concorrentes. Eles oferecem um mecanismo eficiente e flexível para gerenciar a 
	execução de múltiplas tarefas, melhorando o desempenho e a escalabilidade das suas aplicações.
 * */


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Printer implements Runnable{
	private final int num;
	
	public Printer(int num) {
		this.num=num;
	}
	
	@Override
	public void run() {
		System.out.printf("%s iniciol : %d %n",Thread.currentThread().getName(),num);
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("%s finalizou %n",Thread.currentThread().getName());
	}	
}

public class Main {
	public static void main(String[] args) {
		ExecutorService executorServices = Executors.newFixedThreadPool(2);
		
		executorServices.execute(new Printer(1));
		executorServices.execute(new Printer(2));
		executorServices.execute(new Printer(3));
		executorServices.execute(new Printer(4));
		executorServices.execute(new Printer(5));
		
		executorServices.shutdown();
			
		while(!executorServices.isTerminated()) {}
		System.out.println("fim");
		
	}
}
