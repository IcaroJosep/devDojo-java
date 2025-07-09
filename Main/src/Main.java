
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
		
		
		System.out.println(cus.out());
		System.out.println(cus.out());
		System.out.println(cus.out());
		//f6 f5 ctrl+shift+i		
		
	}
}
