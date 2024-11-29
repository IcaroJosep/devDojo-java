/*Caracter�stica	|	Thread	                                    |Runnable
Heran�a     	 	|Extende a classe Thread.	      				|Implementa a interface Runnable.
--------------------|-----------------------------------------------|---------------------------------------------------------------------
Cria��o de Threads	|Ao instanciar um objeto da classe,				|Requer a cria��o de um objeto Thread para iniciar a execu��o.
 					|uma nova thread � criada.						|
--------------------|-----------------------------------------------|---------------------------------------------------------------------
Flexibilidade		|Menos flex�vel, pois limita a 					|Mais flex�vel, permitindo a implementa��o de m�ltiplas interfaces.
					|heran�a de outras classes.						|
--------------------|-----------------------------------------------|---------------------------------------------------------------------
Uso					|Ideal quando voc� precisa de um novo tipo de 	|Ideal quando voc� precisa definir uma tarefa que pode ser executada por 
					|thread com comportamentos personalizados.		|v�rias threads ou por outros mecanismos de execu��o	
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
        System.out.println("MinhaTarefa est� rodando");
    }
}




/*opcao de inplementa�ao de treds com lambdas :
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