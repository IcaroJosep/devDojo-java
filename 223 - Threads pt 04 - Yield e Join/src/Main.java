/*yield :
 * da uma indicaçao de q vc quer que a tred volte para runnable ,
 * ou seja pare de rodar e volte para rodavel assim ando espaço
 * para q outras threads executem.
 * obs: nao a garantia disso ,fica a merce da jvm assim como funciona a prioridade
 * 
 *join nao permite q o codigo comtinue ate a thread ser encerada
 * 
 * 
 * */

class  threadExemple implements Runnable{
	private final String c;
	
	public threadExemple (String c) {this.c=c;}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		for (int i = 0; i < 200; i++) {
			System.out.print(c);
			if (i%100==0) {
				System.out.println();
			}
	//	Thread.yield();
		}
	}
}



public class Main {

	public static void main(String[] args) {
	 Thread t1 = new Thread(new threadExemple("ku"));
	 Thread t2 = new Thread(new threadExemple("me"));
	 	t1.start();
	 	try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	 	
	 	t2.start();

	}
}






