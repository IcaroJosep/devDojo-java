import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import dominio.LightNoval;

public class Main {
	//1.odenar lightnovas por titulo
	//2.tragas os 3 primeiros com valor menor q 4
	
	
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
		
		/*com stream*/
		List<String> titles = lightNovals.stream()
			.sorted(Comparator.comparing(LightNoval::getTitle))//acao intermediaria.ordena
			.filter(ln->ln.getPrice()<=4)//acao intermediaria.filtra 
			.limit(3)//acao intermediaria.limita a quantidade
			.map(LightNoval::getTitle)//acao intermediaria.mapeia os titulos
			.collect(Collectors.toList());//acao final.coleta os titulos
		
		System.out.println(titles);
		
	}
}
