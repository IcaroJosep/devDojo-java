import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/*
O que � uma ThreadFactory?
	Em Java, a ThreadFactory � uma interface que faz parte do pacote java.util.concurrent. 
	Ela � usada para criar novas threads de forma personalizada. 
	Em vez de criar threads diretamente usando o construtor da classe Thread, 
	voc� pode usar uma ThreadFactory para controlar como as threads s�o criadas, configuradas e inicializadas.

Para que serve?
	A principal vantagem de usar uma ThreadFactory � que ela permite que voc� personalize
	a cria��o de threads. Por exemplo, voc� pode:
Definir nomes personalizados para  
 	Isso facilita a identifica��o e o debugging.
Definir prioridades espec�ficas: 
	Voc� pode configurar a prioridade das threads criadas.
Configurar threads como daemon: 
	Threads daemon s�o threads que n�o impedem a JVM de terminar quando todas as outras threads n�o-daemon terminam.
Adicionar handlers de exce��o personalizados: 
	Voc� pode definir como as threads devem lidar com exce��es n�o capturadas.*/

public class texteMainDeep {
/*Usando a ThreadFactory com um ExecutorService
	Voc� pode usar uma ThreadFactory com um ExecutorService para 
	controlar como as threads s�o criadas no pool de threads:
*/
	public static void main(String[] args) {
		 ThreadFactory customThreadFactory = new CustomThreadFactory();
	     ExecutorService executor = Executors.newFixedThreadPool(5, customThreadFactory);

	     executor.submit(() -> System.out.println("Task 1 executed by " + Thread.currentThread().getName()));
	     executor.submit(() -> System.out.println("Task 2 executed by " + Thread.currentThread().getName()));
	     executor.submit(() -> System.out.println("Task 3 executed by " + Thread.currentThread().getName()));
	     	     
	     executor.shutdown();

	}

}
