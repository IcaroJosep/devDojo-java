package dominio;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Menbros {
	private final Queue<String> emails = new ArrayBlockingQueue<>(10);
	private boolean open = true;
	
	public boolean isOpem() {
		return open;
	}
	
	public int EmailsPendentes() {
		synchronized (emails) {
			return emails.size();
		}
	}
	
	public void addMenberEmail(String email) {
		synchronized (emails) {
			this.emails.add(email);
			System.out.printf("%s adicionou emeil a lista\n",Thread.currentThread().getName());			
			this.emails.notifyAll(); //envia sinal para comtinuar
		}
	}
	
	public String recuperaEmail() throws InterruptedException {
		System.out.println(Thread.currentThread().getName()+" checar se ha emails");
		synchronized (emails) {
			while(this.emails.size()==0) {
				if(!open) {
					break;
				}
			 	this.emails.wait();//espera ate receber o sinal
			}
			return this.emails.poll();
		}
	}
	
	public void close() {
		open=false;
		synchronized (emails) {
			System.out.println(Thread.currentThread().getName()+" notificando todo mundo q nao estamaos mas pegando emails");
			
		}
	}
	
	
	
	
	
}
