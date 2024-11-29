
public class MAIN {

	public static void main(String[] args) {
		
				Thread t1 = new Thread(new threadsExampleRunnable('a'),"thread 00001");
				Thread t2 = new Thread(new threadsExampleRunnable('b'));
				Thread t3 = new Thread(new threadsExampleRunnable('c'));
				Thread t4 = new Thread(new threadsExampleRunnable('d'));
				
			/*mesmo indicando a prioridade como maxima nao a garantia de q a tred sera a 
			 *primeira a ser executada nem sera a primeira a terminar.
			 *serve apenas como sugestao pára a jdk*/	
				t4.setPriority(10);
				
				t1.start();
				t2.start();
				t3.start();
				t4.start();

	}
}
	
class threadsExampleRunnable implements Runnable{
			private char c;
			
			public threadsExampleRunnable(char c) {
				this.c=c;
			}
			
			@Override
			public void run() {
				System.out.printf("Start thread :%s ,%s\n",c,Thread.currentThread().getName());
				for (int i = 0; i < 40; i++) {
					System.out.printf("%s %d\n",c,i);
					if (i%100==0) {
						System.out.println("==========================");
					}
					if (i%2==0) {
						System.out.printf("thread %s dormindo\n",Thread.currentThread().getName());
					
///////////////////////	Thread.sleep(50); bota a tred para dormir por mile segundos 2000 = 2segundos					
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							System.out.println("erro:");
							e.printStackTrace();
						}
						
						
					}
				}
				
			}
}

		


