import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

/*Collable "irmao do Runnable"
 * -Diferemça:
 * Runnable tem retorno Void
 * Collable te retorno generico "<T>"*/

class RandomNumberCalable implements Callable<String>{
	@Override
	public String call() throws Exception {
	/*	Metodos de geraçao de numeros aleatorios:	
		 Math.random()
			Sincronizado: Sim, Math.random() é um método sincronizado, o que significa que apenas uma thread pode acessá-lo por vez.
			Concorrência: Em cenários multithread, isso pode levar a contenção, ou seja, as threads podem ficar "esperando na fila" para obter um número aleatório, prejudicando o desempenho.
			Sequência: Todas as threads que chamarem Math.random() receberão números da mesma sequência, o que pode não ser desejável em muitas aplicações.
		 ThreadLocalRandom
			Não sincronizado: Cada thread possui sua própria instância de ThreadLocalRandom, eliminando a contenção e melhorando o desempenho em aplicações multithread.
			Sequências independentes: Cada thread gera sua própria sequência de números aleatórios, garantindo maior aleatoriedade e independência entre as threads.
	*/	
		 int num = ThreadLocalRandom.current().nextInt(1,11);
		 
		 for (int i = 0; i < num; i++) {
			System.out.printf("\n%s Executando uma tarefa callable....",Thread.currentThread().getName());
		} 
		 
		return String.format("%s finalizada e a geracao de numero é %d",Thread.currentThread().getName(),num);
	}
}

public class Main {	
	public static void main(String[] args) {
		RandomNumberCalable randomNumberCalable = new RandomNumberCalable();
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		/*future é utilisado pos ao chamar seu get ele faz com q o programa espere pelo seu valor
		 * */
		Future<String> future =executorService.submit(randomNumberCalable);
		
		
		try {
			System.out.printf("\nprogram Finishid %s",future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		executorService.shutdown();
		

	}

}
