import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

/*Collable "irmao do Runnable"
 * -Diferem�a:
 * Runnable tem retorno Void
 * Collable te retorno generico "<T>"*/

class RandomNumberCalable implements Callable<String>{
	@Override
	public String call() throws Exception {
	/*	Metodos de gera�ao de numeros aleatorios:	
		 Math.random()
			Sincronizado: Sim, Math.random() � um m�todo sincronizado, o que significa que apenas uma thread pode acess�-lo por vez.
			Concorr�ncia: Em cen�rios multithread, isso pode levar a conten��o, ou seja, as threads podem ficar "esperando na fila" para obter um n�mero aleat�rio, prejudicando o desempenho.
			Sequ�ncia: Todas as threads que chamarem Math.random() receber�o n�meros da mesma sequ�ncia, o que pode n�o ser desej�vel em muitas aplica��es.
		 ThreadLocalRandom
			N�o sincronizado: Cada thread possui sua pr�pria inst�ncia de ThreadLocalRandom, eliminando a conten��o e melhorando o desempenho em aplica��es multithread.
			Sequ�ncias independentes: Cada thread gera sua pr�pria sequ�ncia de n�meros aleat�rios, garantindo maior aleatoriedade e independ�ncia entre as threads.
	*/	
		 int num = ThreadLocalRandom.current().nextInt(1,11);
		 
		 for (int i = 0; i < num; i++) {
			System.out.printf("\n%s Executando uma tarefa callable....",Thread.currentThread().getName());
		} 
		 
		return String.format("%s finalizada e a geracao de numero � %d",Thread.currentThread().getName(),num);
	}
}

public class Main {	
	public static void main(String[] args) {
		RandomNumberCalable randomNumberCalable = new RandomNumberCalable();
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		/*future � utilisado pos ao chamar seu get ele faz com q o programa espere pelo seu valor
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
