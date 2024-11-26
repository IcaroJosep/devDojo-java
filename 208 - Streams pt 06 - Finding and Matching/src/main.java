import java.util.ArrayList;
import java.util.List;

import dominio.LightNoval;

public class main {
	private static List<LightNoval> lightNovals =new ArrayList<>(List.of(
			new LightNoval("tensei shittara",8.99),
			new LightNoval("OverLord", 3.99),
			new LightNoval("Violet", 5.99),
			new LightNoval("No Game no life", 2.99),
			new LightNoval("Fullmetal Alchemist", 5.99),
			new LightNoval("Kumo desuga", 1.99),
			new LightNoval("Monogatari", 5.99)
					));
	
	public static void main(String[] args) {
			/*existe algum elemento com preço mainr q 8*/
		System.out.println(
					lightNovals.stream()
				   .anyMatch(ln->ln.getPrice()>8)//retorno booleano
				);
		
			/*todo elemento da lista tem preço maior q 0*/
		System.out.println(
					lightNovals.stream()
					.allMatch(ln->ln.getPrice()>0)//retorno booleano
				);
		
			/*nem um elemento da lista tem preço menor doque 0*/
		System.out.println(
				lightNovals.stream()
				.noneMatch(ln->ln.getPrice()<0)//retorno booleano
			);

			/*retorna qualquer elemento q seja maior q 3*/
		lightNovals.stream()
					.filter(ln->ln.getPrice()>3)
					.findAny()//retorna qualquer elemento ,e nao ouver nem um retorna nada
					.ifPresent(System.out::println);//se o elemento estver presente
		
			/*retorna o primerio elemento q for maior q 3 */
		lightNovals.stream()
					.filter(ln->ln.getPrice()>3)
					.findFirst()
					.ifPresent(System.out::println);//se o elemento estver presente

	
	}

}
