/*Característica	|	Thread	                                    |Runnable
Herança     	 	|Extende a classe Thread.	      				|Implementa a interface Runnable.
--------------------|-----------------------------------------------|---------------------------------------------------------------------
Criação de Threads	|Ao instanciar um objeto da classe,				|Requer a criação de um objeto Thread para iniciar a execução.
 					|uma nova thread é criada.						|
--------------------|-----------------------------------------------|---------------------------------------------------------------------
Flexibilidade		|Menos flexível, pois limita a 					|Mais flexível, permitindo a implementação de múltiplas interfaces.
					|herança de outras classes.						|
--------------------|-----------------------------------------------|---------------------------------------------------------------------
Uso					|Ideal quando você precisa de um novo tipo de 	|Ideal quando você precisa definir uma tarefa que pode ser executada por 
					|thread com comportamentos personalizados.		|várias threads ou por outros mecanismos de execução	
 */
public class Main {
	public static void main(String[] args) {
	/*	Thread t1 = new Thread(new threadsExampleRunnable('a'));
		Thread t2 = new Thread(new threadsExampleRunnable('b'));
		Thread t3 = new Thread(new threadsExampleRunnable('c'));
		Thread t4 = new Thread(new threadsExampleRunnable('d'));
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	*/	
		
		
/*exeplo 2 :chamando entreds diferentes a mesma tarefa*/
		MinhaTarefa tarefa = new MinhaTarefa();
		/*Thread t = new Thread(tarefa);
		t.start();*/
		new Thread(tarefa).start();
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
		for (int i = 0; i < 400; i++) {
			System.out.printf("%s %d\n",c,i);
			if (i%100==0) {
				System.out.println("==========================");
			}
		}
		
	}
}

/*exeplo 2 :chamando entreds diferentes a mesma tarefa*/
class MinhaTarefa implements Runnable {
    public void run() {
        System.out.println("MinhaTarefa está rodando");
    }
}




/*opcao de inplementaçao de treds com lambdas :
	new Thread(()->{
		for (int i = 0; i < 20; i++) {
			System.out.println("teu cu");
		}
	}).start();	


	Runnable ex=()->{for (int i = 0; i < 20 ; i++) {
			System.out.println("icaro");
		}};
		
	new Thread(ex).start();
*/