import java.awt.desktop.ScreenSleepEvent;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* Em Java, um objeto Future representa o resultado futuro de uma tarefa ass�ncrona. 
 * Essa tarefa � normalmente executada em uma thread separada, permitindo que o 
 * c�digo principal continue sua execu��o sem esperar pela conclus�o da tarefa. 
 * O Future serve como um "contrato" que garante que o resultado estar� dispon�vel 
 * em algum momento no futuro, e oferece m�todos para verificar se a tarefa foi conclu�da, 
 * obter o resultado ou cancelar a tarefa.
 * 
 * Pontos importantes a serem considerados:
 *
 *	Bloqueio: 
 *	O m�todo get() pode bloquear a thread principal se a tarefa ainda n�o estiver conclu�da. 
 *	Para evitar bloqueios, � comum usar future.isDone() para verificar se a tarefa j� 
 *	terminou antes de chamar get().
 *
 *	Exce��es: 
 *	Se a tarefa lan�ar uma exce��o, ela ser� encapsulada em uma ExecutionException quando voc� chamar get().
 *
 *	Cancelamento: 
 *	Cancelar uma tarefa pode n�o ser instant�neo, pois a tarefa pode estar em um estado que n�o permita 
 *	o cancelamento imediato.
 *
 *	Timeout: 
 *	O m�todo get() pode ser usado com um timeout para evitar que a thread principal bloqueie indefinidamente.
 *	 * */

public class Main {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		Future<Double> dollarRefresh = executorService.submit(new Callable<Double>(){
			@Override
			public Double call() throws Exception {
				TimeUnit.SECONDS.sleep(2); //tempo eperando
				System.out.println("cuss");
				return 4.35D;
			}
		});	
		
		System.out.println(doSomething());
		
		try {
			try {
				//Double dolar=dollarRefresh.get(10,TimeUnit.SECONDS);
				System.out.println(dollarRefresh.get(10,TimeUnit.SECONDS));
			} catch (TimeoutException e) {
				System.out.println("tempo exedido");
				e.printStackTrace();
			}
		} catch (InterruptedException e) {
			System.out.println("thread interompida");
			e.printStackTrace();
		} catch (ExecutionException e) {
			System.out.println("erro ");
			e.printStackTrace();
		}
		
		executorService.shutdown();
	}
	
	private static long doSomething(){
			System.out.println(Thread.currentThread().getName());
			long sum =0;
			for(int i =0;i<1_000_000;i++) {
				sum+=i;
			}
			
			return sum;
		}

}
