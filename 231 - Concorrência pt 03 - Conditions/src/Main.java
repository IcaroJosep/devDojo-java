
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*esta aula foi subistituido o sincronizi da aula 229
 * pela manipulacao direta de lock*/
class Counter{
	private int count;

	public int getCount() {
		return count;
	}
	
	void  increment() {
		count++;
	}
	
}

public class Main {
	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();//criaçao de lock
		
        Counter counter = new Counter();
		
		Runnable r =()->{
			lock.lock();//utilizaçao do lock
			try {
				for(int i=0; i<10; i++) {
				counter.increment();
				System.out.println(Thread.currentThread().getName());
				}
			} finally {
				lock.unlock();//liberaçao do lock
			}
			
		};
		
		Thread t1 = new Thread(r,"primeira");
		Thread t2 = new Thread(r,"segunda");
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(counter.getCount());
		
	}
}
