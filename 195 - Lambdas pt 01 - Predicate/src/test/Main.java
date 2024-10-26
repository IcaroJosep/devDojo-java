package test;


/*
 * para as lambidas funcionarem elas nessecitao q a
 * interface q tu esteja trabalhando seja funcioanal
 * 
 * INTERFACE FUNCIONAL?:
 * interface q comtem apenas um metodo abstrato 
 * 
 * EX:
 * interface criada e utilizada na ultima aula.
 * public interface carPredicate{
 * 		boolean test(car car);
 * }
 * 
 * regras:
 * 1.pode comter varios metodos; porem apenas um abstarato
 * */
public class Main {
	interface Soma{
			int adicao(int a);
		}
	
	public static void main(String[] args) {
		
		int a = 5;
	
	//lambda
		Soma soma= (e)->{return e*2;};
		int b =soma.adicao(a);
		
		System.out.println(b);
     
	//funcao anonima
        int c = new Soma() {
			
			@Override
			public int adicao(int a) {
				
				return a*2;
			}
		}.adicao(a);
		
		System.out.println(c);
	}

}
