import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/*
O que é uma ThreadFactory?
	Em Java, a ThreadFactory é uma interface que faz parte do pacote java.util.concurrent. 
	Ela é usada para criar novas threads de forma personalizada. 
	Em vez de criar threads diretamente usando o construtor da classe Thread, 
	você pode usar uma ThreadFactory para controlar como as threads são criadas, configuradas e inicializadas.

Para que serve?
	A principal vantagem de usar uma ThreadFactory é que ela permite que você personalize
	a criação de threads. Por exemplo, você pode:
Definir nomes personalizados para  
 	Isso facilita a identificação e o debugging.
Definir prioridades específicas: 
	Você pode configurar a prioridade das threads criadas.
Configurar threads como daemon: 
	Threads daemon são threads que não impedem a JVM de terminar quando todas as outras threads não-daemon terminam.
Adicionar handlers de exceção personalizados: 
	Você pode definir como as threads devem lidar com exceções não capturadas.*/

public class texteMainDeep {
/*Usando a ThreadFactory com um ExecutorService
	Você pode usar uma ThreadFactory com um ExecutorService para 
	controlar como as threads são criadas no pool de threads:
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
