import java.util.concurrent.atomic.*;

/*	
 AtomicInteger � uma classe dentro do pacote java.util.concurrent.atomic em Java,
 projetada especificamente para opera��es at�micas em vari�veis inteiras em 
 ambientes com m�ltiplas threads. Ela fornece uma camada de abstra��o que 
 simplifica o trabalho com concorr�ncia, evitando a necessidade de sincroniza��o
 manual com synchronized ou Lock em muitos casos
 * */
class Counter{
	private int count;
	private AtomicInteger  atomicInterger = new AtomicInteger();

	public int getCount() {
		return count;
	}
	
	
	public AtomicInteger getAtomicInterger() {
		return atomicInterger;
	}

	
	/*com synchronized*/
/*	synchronized void  increment() {
		count++;
	}
*/
	/*sem nemnhum metodo de sincronia
	 *e com atomic */
	void  increment() {
		count++;
		atomicInterger.incrementAndGet();
	}
	
}


public class Main {
	public static void main(String[] args) {
		
		Counter counter = new Counter();
		
		Runnable r =()->{
			for(int i=0; i<10000; i++) {
				counter.increment();
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
		System.out.println(counter.getAtomicInterger());
	
	
	
	}
}
