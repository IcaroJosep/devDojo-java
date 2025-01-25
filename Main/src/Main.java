
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


public class Main {
	static Callable<Double> a = ()->{
			for (int i = 0; i < 2; i++) {
				System.out.printf("Calleble ex %d\n",i);
				TimeUnit.SECONDS.sleep(2);
			}
			return 4.51d;
	};
	
	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newSingleThreadExecutor(); 
		Future<Double> a1 = executor.submit(a);
		
		
		new Thread(() -> {
	        int p =0;
	        do {
	        	p++;
	        	try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.printf("carregando %s\n",p);
			} while (!a1.isDone());
	        try {
				System.out.println(a1.get(10,TimeUnit.SECONDS));
			} catch (TimeoutException | InterruptedException | ExecutionException e) {
						e.printStackTrace();
			}finally {	
				System.out.println("fim Executor ");
				executor.shutdown();
			}	
				
	    }).start();
		
		
		
		for (int i = 0; i < 10; i++) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(i);
		}
		
		
		
	}
}
