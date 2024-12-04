import dominio.Accout;

public class Main {
	
	private static Accout comta = new Accout();

	public static void main(String[] args) {
	
		Runnable r =()->{
			for (int i = 0; i < 6; i++) {
				saque(10);
			}

		Runnable q =()->{
			for (int i = 0; i < 6; i++) {
				saque2(10);
			}
			
		};
		new Thread(r).start();
		new Thread(r).start();
		new Thread(r).start();	
		new Thread(r).start();	
		new Thread(q).start();
		new Thread(q).start();
		new Thread(q).start();
		new Thread(q).start();
		new Thread(q).start();
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(comta.getSaldo());
	}
	
	
	private static void saque(int valor) {
			System.out.println(Thread.currentThread().getName()+" esta fora da do bloco ");
			synchronized (comta) {
				System.out.println(Thread.currentThread().getName()+" esta DENTRO da do bloco ");
				if (comta.getSaldo()>=valor) {
					System.out.println(Thread.currentThread().getName()+" esta indo sacar dinheiro");
					comta.saque(valor);
					System.out.println(Thread.currentThread().getName()+" completou o saque valor atual da comta:"+comta.getSaldo());
				}else {
					System.out.println(Thread.currentThread().getName()+" sem dinherio");
				}	
			}

	}
	
	
	private static void saque2(int valor) {
			System.out.println(Thread.currentThread().getName()+" esta fora da do bloco ");
			synchronized (comta) {
			System.out.println(Thread.currentThread().getName()+" esta DENTRO da do bloco ");
			if (comta.getSaldo()>=valor) {
				System.out.println(Thread.currentThread().getName()+" esta indo sacar dinheiro");
				comta.saque(valor);
				System.out.println(Thread.currentThread().getName()+" completou o saque valor atual da comta:"+comta.getSaldo());
			}else {
				System.out.println(Thread.currentThread().getName()+" sem dinherio");
			}	
		}
	
	}
	
}
