package repositorio;

import java.util.List;
import java.util.Optional;

import dominio.Manga;

public class MangaRepository {
	private static List<Manga> mangas = List.of(
			new Manga(1,"boku no hero", 50),
			new Manga(2, "Overlord", 25)
			);

	public static Optional<Manga> FindByTitle (String title){
		Manga found = null;
		for(Manga manga:mangas) {
			if(manga.getTitle().equals(title)) {
				found=manga;
			}
		}
		
		return Optional.ofNullable(found);
	}
	

}
