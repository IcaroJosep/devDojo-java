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
		ThreadExemple t1= new ThreadExemple('a');
		ThreadExemple t2= new ThreadExemple('b');
		ThreadExemple t3= new ThreadExemple('c');
		ThreadExemple t4= new ThreadExemple('d');
		
	/*	t1.run();
		t2.run();
		t3.run();
		t4.run();
	*/	
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		
	}

}



class ThreadExemple extends Thread{
	public char c;
	
	public ThreadExemple(char c) {
		this.c=c;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		for (int i = 0; i < 400; i++) {
			System.out.print(c);System.out.println(i);
			if (i%100==0) {
				System.out.println("=====================================");
			}
		}
		super.run();
	}
	
}