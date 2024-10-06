import java.util.ArrayList;
import java.util.List;


public class Main {

	public static void main(String[] args) {
		
//como era feito nas versoes antes do generics	
		List lista = new ArrayList();
		
		lista.add("midiriya");
		lista.add(123l);
		lista.add(new Comsumidor("goku"));
		
		/*como a lista aceita qualquer tipo
		 *seria nescessario fazer a verificasao de tipo 
		 *em iteraçoes.*/
		for(Object o:lista) {
			if(o instanceof String) {
				System.out.println(o);
			}
			if(o instanceof Long) {
				System.out.println(o);
			}
			if(o instanceof Comsumidor) {
				System.out.println(((Comsumidor) o).nome);
			}	
		}

															System.out.println("\n==============\n");
															
//como é feito com generics : 
		/*a generics foi criado devido a necesidade de definir o tipo da 
		 *lista e manter a compatibilidade com as versoas anteriores
		 *
		 *a definiçao de tipo para lista é feita somente em tempo de compilaçao
		 *ou seja depos de compilado o codigo nao tem tipo*/
		List<String> lista2=new ArrayList<>();
	
		lista2.add("midiriya");
		//lista2.add(123l);					 //nao aceita pos lista2 so aceitara strings
		//lista2.add(new Comsumidor("goku"));//nao aceita pos lista2 so aceitara strings
		
		for(String o:lista2) {
			System.out.println(o);
		}
																	System.out.println("\n==========\nintroducao forcada de um obj atraves do metodo:\n");
		add(lista2,new Comsumidor("icaro"));/*atraves dometodo add estamos add um obj
											assim demostrando a aceitando todo tipo de elemento
											pos o metodo chamadado nao trata a lista com generics*/
												
	/*	for(String o:lista2) {			//erro pos apos o metodo add 
			System.out.println(o);		//nem todos os elementos da lista sao Strings
		}
	*/
		
		//iteracao sem generics sobre a lista generics
		for(Object o:lista2) {
			if(o instanceof String) {
				System.out.println(o);
			}
			if(o instanceof Comsumidor) {
				System.out.println(o);
			}	
		}
	
	
	
	}
	
	/*este metodo trata a lista sem generics assim posibilitando
	 *a inclusao de qualquer tipo dentro da lista mesmo
	 *q ela tenha sua instancia como generics 
	 *obs: mertodo criado apenas para demostra q 
	 *o generics apenas funciona em tempo de compilacao para inpedir a inclusao de 
	 *qualquer tipo . mas q na memoria tanto a lista com generics quanto a sem 
	 *sao tratadas da mesma forma */
	private static void add(List l,Comsumidor c) {
		l.add(c);
		
	}
	
	

}
