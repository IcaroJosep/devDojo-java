/*
	Execu��o concorrente: Sim, Executor e ExecutorService fornecem uma maneira elegante de 
	executar m�ltiplas tarefas concorrentemente, sem a necessidade de gerenciar manualmente a 
	cria��o e sincroniza��o de threads.
	
	Gerenciamento de threads: O Thread Pool centraliza o gerenciamento de threads, incluindo:
		
		Cria��o: Um conjunto inicial de threads � criado ao instanciar o pool.
		
		Reutiliza��o: As threads s�o reutilizadas para executar novas tarefas, evitando o overhead 
		de criar threads a cada nova tarefa.
		
		Limpeza: O pool gerencia a limpeza de threads que n�o est�o mais em uso, liberando 
		recursosdo sistema.
		
	Flexibilidade: Thread Pools oferecem diferentes configura��es para atender a diversas necessidades:
		
		N�mero m�ximo de threads: Permite limitar o n�mero de threads concorrentes, evitando 
		sobrecarregar o sistema.
		
		Tipos de pool: Existem diferentes tipos de pools (FixedThreadPool, CachedThreadPool, 
		SingleThreadExecutor, ScheduledThreadPool) para atender a diferentes padr�es de uso.
		
		Pol�ticas de fila: A forma como as tarefas s�o enfileiradas e executadas pode ser configurada.
		
	
	Outros benef�cios e considera��es:
	
		Melhora do desempenho: Ao reutilizar threads, reduz-se o overhead de cria��o e destrui��o de threads, 
		o que pode levar a um ganho significativo de desempenho em aplica��es com muitas tarefas concorrentes.
		
		Simplifica��o do c�digo: Abstrai a complexidade da concorr�ncia, permitindo que voc� se concentre na 
		l�gica da sua aplica��o.
		
		Facilidade de uso: A API ExecutorService fornece m�todos intuitivos para submeter tarefas, controlar 
		a execu��o e encerrar o pool.
		
		Escalabilidade: Thread Pools podem ser configurados para escalar de acordo com a carga de trabalho 
		da sua aplica��o.
		
		Gerenciamento de exce��es: � importante tratar as exce��es que ocorrem nas tarefas para evitar que 
		o pool entre em um estado inconsistente.
		
	Em resumo:
	Thread Pools s�o uma ferramenta essencial para qualquer desenvolvedor Java que trabalha com 
	aplica��es concorrentes. Eles oferecem um mecanismo eficiente e flex�vel para gerenciar a 
	execu��o de m�ltiplas tarefas, melhorando o desempenho e a escalabilidade das suas aplica��es.
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
