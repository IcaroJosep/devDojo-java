import java.util.List;

public class Main {

/* .Reduce():
 * opera�ao final de strems que posibilita o retorno
 * unico apartir de um cole�ao de elementos
 * "aplica uma opera�ao aos elemantos e no final
 * retorna uma resultado."
 *  
 * */
	public static void main(String[] args) {
	  
		List<Integer> integers = List.of(1,2,3,4,5,6);
		
		integers.stream().reduce((x,y)->x+y).ifPresent(System.out::println);
		
		
		
	}

}
