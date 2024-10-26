import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
/* consumer assim como Predicate se trata de uma inter�ace funcional
 * q posui apenas um metodo ABSTRATO
 * porem sua diferen�a � que o metodo � void 
 * isto significa  sem retorno!
 * 
 * 
 * 
 * */
public class Main {

	public static void main(String[] args) {
		List<String> strings = List.of("william","suane","luffy","zoro");
		List<Integer> a =List.of(1,2,3,4); 
		/*com lambda*/
		forEach(strings, (String s)-> System.out.println(s));
		
		forEach(a , (Integer i) -> System.out.println(i));
		
		/*com fun�ao anonima*/
		forEach(strings,
			new Consumer<String>() {
				@Override
				public void accept(String E) {
					System.out.println(E);
					
				}
			}
		);
		
	}
	private static <T> void forEach(List<T> list,Consumer<T> comsumer) {
		for(T e:list) {
			comsumer.accept(e);
		}
		
	}
}
