import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dominio.Anime;
import services.AnimeConparators;

/*Contexto de uma Express�o Lambda: 
 *Quando o compilador encontra a sintaxe Classe::m�todo 
 *dentro de um contexto onde uma express�o lambda � 
 *esperada (como um argumento para um m�todo funcional), 
 *ele automaticamente interpreta isso como uma refer�ncia a um m�todo.
 *
 *obs:
 *elas fazem referencias a metodos ja existentes de classe e assim podem oferecer
 *mais claresa.
 *emquato lambdas comus podem oferecer mais flexibilidade.
 *
 **/
public class Main {

	public static void main(String[] args) {
		List<Anime> animeList= new ArrayList<Anime>(
				List.of(
						new Anime("naruto",480),
						new Anime("Berserk", 43),
						new Anime("One piece", 900)
						)
				);
		
		System.out.println(animeList);
		
	/*	Collections.sort(
					animeList,
					(a1,a2)->a1.getTitle().compareTo(a2.getTitle())
				);
	*/
	
	//	Collections.sort(animeList,(a1,a2)->AnimeConparators.comparaByTitle(a1, a2));

	//	Collections.sort(animeList,AnimeConparators::comparaByTitle);
		
		Collections.sort(animeList,AnimeConparators::comparaByEpsodes);
		
		System.out.println(animeList);

		
	}

}
