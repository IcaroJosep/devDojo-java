import dominio.Accout;

/*	aplicando sinconismo de threads 
 * para resolver o problema da aula passada
 * 
 * synchronized: especifica q o metodo so pode 
 * ser acessado por uma thred de cada vez
 * 
 */
public class Main {
	
	private static Accout comta = new Accout();

	public static void main(String[] args) {
	
		Runnable r =()->{
			for (int i = 0; i < 6; i++) {
				saque(10);
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
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(comta.getSaldo());
	}
	
		//metodo synchronized: sincronismo ,inpede acesos simutaneos
/*	private synchronized static void saque(int valor) {
		if (comta.getSaldo()>=valor) {
			System.out.println(Thread.currentThread().getName()+" esta indo sacar dinheiro");
			comta.saque(valor);
			System.out.println(Thread.currentThread().getName()+" completou o saque valor atual da comta:"+comta.getSaldo());
		}else {
			System.out.println(Thread.currentThread().getName()+" sem dinherio");
		}
	}
*/
	
		
	private static void saque(int valor) {
			System.out.println(Thread.currentThread().getName()+" esta fora da do bloco ");
		/* opcao 2 sincronisando o bloco:
		 * embora todas eleas entrem no 
		 * metodo  apenas uma thread executa 
		 * o bloco synchronized de cada ves*/
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
	/*obs: se tufiser um outro metodo onde uma outra thread
	 *acessa o valor da comta e tbm ussar o synchronized
	 *ela so executara o trexo quando o lock for liberado
	 *
	 *POREM so neste outro metodo vc nao utilisr o bloco
	 *synchronized vc tera o msm problema de comcorrencia
	 **/
	
}
