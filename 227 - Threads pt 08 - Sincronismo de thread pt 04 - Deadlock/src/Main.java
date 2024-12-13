
/*Um dead lock é:
quando uma thread espera segurando um lock e necessita do lock de outra thread 
para encerar, esta outra thread necessita do lock que está sendo segurado 
pela primeira para encerar. 
Assim, causando uma espera infinita.
 * */

public class Main {

	public static void main(String[] args) {
		Object lock1 = new Object();
		Object lock2 = new Object();
		
		Runnable r1=()->{
			synchronized (lock1) {
				System.out.println("thread 1 segurando lock1");
				System.out.println("thread 1 esperando lock2");
				synchronized (lock2) {
					System.out.println("thread 1 segurando lock2");
				}
			}
			System.out.println("fim thread 1");
		};
		
		Runnable r2=()->{
			synchronized (lock2) {
				System.out.println("thread 2 segurando lock2");
				System.out.println("thread 2 esperando lock1");
				synchronized (lock1) {
					System.out.println("thread  segurando lock1");
				}
			}
			System.out.println("fim thread 2");	
		};
		
		new Thread(r1).start();
		new Thread(r2).start();
	
	
	}

}
