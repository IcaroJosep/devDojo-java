import java.util.ArrayList;
import java.util.List;
import dominio.LightNoval;

public class Main {
	private static List<LightNoval> lightNovals =new ArrayList<>(List.of(
			new LightNoval("tensei shittara",8.99),
			new LightNoval("OverLord", 3.99),
			new LightNoval("Violet", 5.99),
			new LightNoval("No Game no life", 2.99),
			new LightNoval("Fullmetal Alchemist", 5.99),
			new LightNoval("Kumo desuga", 1.99),
			new LightNoval("Monogatari", 5.99),
			new LightNoval("Monogatari", 5.99)
					));
	
	public static void main(String[] args) {
		List<String> filter = new ArrayList<>();
		/*	Este Stream faz a iteraçao atraves do forEach
		 *adicionado apenas o titulo a lista filter.
		 *	Emquanto ao trexo comentado faz a inpreçao de cada obj da lista mae*/
		lightNovals.stream()
			//.forEach(System.out::println);
			.forEach(
					ln->{
						filter.add(ln.getTitle());
					}
			);
		
		
		for (String string : filter) {
			System.out.println(string);
		}
		 
		
///////////////////////////////////////////////////////////////////
		/*este stream filtra os obj com preço <=4 e comta quantos sao 
		 * devolvendo um valor long
		 * (int) força o retorno em uma variavel int
		 * */
	/*	System.out.println(
				(int)lightNovals.stream()
				.filter(ln->ln.getPrice()<=4)
				.count()
				);
	*/
		
		
//////////////////////////////////////////////////////////////////		
		
		/*.distinct()
		 * faz a retirada de de ites duplicados
		 * o fato de aqui estarmos tratando de objts criados
		 * faz nescesario a sobre escrita dos metodos equals() e hashCode() 
		 * na class para q posamos atribuir oq é comsiderado igual.
		 * Caso comtrario ele compararia a referencia de memoria */
	/*	for (Object a :lightNovals.stream().distinct().toArray()) {
			System.out.println(a);
		}
	*/	
		

		
	}

}
