import java.util.ArrayList;
import java.util.List;


public class Main {

	public static void main(String[] args) {
		List lista = new ArrayList();
		
		lista.add("midiriya");
		lista.add(123l);
		lista.add(new Comsumidor("goku"));
		
		for(Object o:lista) {
			if(o instanceof String) {
				System.out.println(o);
			}
			if(o instanceof Long) {
				System.out.println(o);
			}
			if(o instanceof Comsumidor) {
				System.out.println( ((Comsumidor) o).nome);
			}
		}
		
	
		
		
		
		
	}
}
