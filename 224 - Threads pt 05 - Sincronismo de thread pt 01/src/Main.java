import dominio.Accout;

/*para demostrar a o problema de nao sincronizar threads 
 *sera utilizado o exemplo de um saque em comta
 *
 */
public class Main {
	
	private static Accout comta = new Accout();

	public static void main(String[] args) {
	
		Runnable r =()->{
			for (int i = 0; i < 6; i++) {
				saque(50);
			}
			
		};
		new Thread(r).start();
		new Thread(r).start();
		new Thread(r).start();	
		new Thread(r).start();	
		new Thread(r).start();
		new Thread(r).start();
		new Thread(r).start();
		new Thread(r).start();	
		new Thread(r).start();	
		new Thread(r).start();
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(comta.getSaldo());
	}
	
	
	private static void saque(int valor) {
		if (comta.getSaldo()>=valor) {
			System.out.println(Thread.currentThread().getName()+" esta indo sacar dinheiro");
			comta.saque(valor);
			System.out.println(Thread.currentThread().getName()+" completou o saque valor atual da comta:"+comta.getSaldo());
		}else {
			System.out.println(Thread.currentThread().getName()+" sem dinherio");
		}
	}
	
	
}
