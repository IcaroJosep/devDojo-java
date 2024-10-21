
import java.util.List;

public class Main {

	public static void main(String[] args) {
	
		List<?> a =criarArrayComUmObjeto(new Barco("lancha"));	
		if(a.get(0) instanceof Barco) {
			Barco b = (Barco) a.get(0);
			System.out.println(b.nome);
		}
	
	}
	
	private static <T> List<T> criarArrayComUmObjeto(T t) {
		List<T> list = List.of(t);
		return list;	
	}
	
	
	
}
