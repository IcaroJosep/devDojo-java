package services;

import dominio.Anime;

public class AnimeConparators {
	public static int comparaByTitle(Anime a1, Anime a2) {
		return a1.getTitle().compareTo(a2.getTitle());
	}
	public static int comparaByEpsodes(Anime a1, Anime a2) {
		return Integer.compare(a1.getEpisodes(), a2.getEpisodes());
	}
	/*metodo nao estatico sendo chamado pela referencia*/
	public  int comparaByEpsodesNoStatic(Anime a1, Anime a2) {
		return Integer.compare(a1.getEpisodes(), a2.getEpisodes());
	}
}
