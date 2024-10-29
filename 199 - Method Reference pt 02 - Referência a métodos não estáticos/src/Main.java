import java.util.ArrayList;

import java.util.List;
import dominio.Anime;
import services.AnimeConparators;

public class Main {

	public static void main(String[] args) {
		
		
		List<Anime> animeList= new ArrayList<Anime>(
				List.of(
						new Anime("naruto",480),
						new Anime("Berserk", 43),
						new Anime("One piece", 900)
						)
				);
		
		/*para a referencia aum metodo nao estatico é necesario a instanciaçao*/
		AnimeConparators animeConparators = new AnimeConparators();
		/*lambda de mothod reference*/
	//	animeList.sort(animeConparators::comparaByEpsodesNoStatic);
		animeList.sort((a1,a2)->animeConparators.comparaByEpsodesNoStatic(a1, a2));
		
		System.out.println(animeList);
		
	}
}
