import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Worker implements Runnable{
	private String name;
	private ReentrantLock lock;
	
	public Worker(String name,ReentrantLock lock){
		this.name=name;
		this.lock=lock;
	}

	@Override
	public void run() {
		lock.lock();
		try {
			if(lock.isHeldByCurrentThread()) {
				System.out.printf("\n thread %s entrou em uma sessão critica",name);
			}
			System.out.printf("\n %d threads esperando na fila",lock.getQueueLength());
			System.out.printf("\n thread %s vai esperar 2s",name);
			Thread.sleep(2000);
			System.out.printf("\n thread %s finalizou a espera",name);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

}
	
public class Main {
  
	
	public static void main(String[] args) {
		ReentrantLock lock= new ReentrantLock();
		new Thread (new Worker("A", lock)).start();
		new Thread (new Worker("B", lock)).start();
		new Thread (new Worker("C", lock)).start();
		new Thread (new Worker("D", lock)).start();
		new Thread (new Worker("E", lock)).start();
		new Thread (new Worker("F", lock)).start();
		new Thread (new Worker("G", lock)).start();
		
		
		
	}

}
