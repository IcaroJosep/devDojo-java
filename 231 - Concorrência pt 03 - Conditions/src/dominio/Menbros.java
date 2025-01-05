package dominio;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Menbros {
	private final Queue<String> emails = new ArrayBlockingQueue<>(10);
	private boolean open = true;
	//inplementaçao do lock
	private final ReentrantLock lock=new ReentrantLock();
	//condition
	private final Condition condition=lock.newCondition();
	
	public boolean isOpem() {
		return open;
	}
	
	public int EmailsPendentes() {
		/*synchronized (emails) {
			return emails.size();
		}*/
		lock.lock();
		try {
			return emails.size();
		} finally {
			lock.unlock();
		}
	}
	
	public void addMenberEmail(String email) {
		/*synchronized (emails) {
			this.emails.add(email);
			System.out.printf("%s adicionou emeil a lista\n",Thread.currentThread().getName());			
			this.emails.notifyAll(); //envia sinal para comtinuar
		}*/
		lock.lock();
		try {
			this.emails.add(email);
			System.out.printf("%s adicionou emeil a lista\n",Thread.currentThread().getName());			
			condition.signalAll(); //envia sinal para comtinuar
		
		} finally {
			lock.unlock();
		}
		
	}
	
	public String recuperaEmail() throws InterruptedException {
		System.out.println(Thread.currentThread().getName()+" checar se ha emails");
		/*synchronized (emails) {
			while(this.emails.size()==0) {
				if(!open) {
					break;
				}
			 	this.emails.wait();//espera ate receber o sinal
			}
			return this.emails.poll();
		}*/
		lock.lock();
		try {
			while(this.emails.size()==0) {
				if(!open) {
					break;
				}
			 	condition.await();//espera ate receber o sinal
			}
			return this.emails.poll();
		} finally {
			lock.unlock();
		}
	
	}
	
	public void close() {
		open=false;
		/*synchronized (emails) {
			System.out.println(Thread.currentThread().getName()+" notificando todo mundo q nao estamaos mas pegando emails");
			
		}*/
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName()+" notificando todo mundo q nao estamaos mas pegando emails");
		} finally {
			lock.unlock();
		}
	}
	
	
	
	
	
}
