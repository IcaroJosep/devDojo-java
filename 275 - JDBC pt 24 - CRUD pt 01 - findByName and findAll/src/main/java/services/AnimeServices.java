package services;

import java.util.Optional;
import java.util.Scanner;

import dominio.Anime;
import dominio.Producer;
import repository.AnimeRepository;
import repository.ProducerRepository;

public class AnimeServices {
private static final Scanner SCANNER = new Scanner(System.in);
	
	public static void menu(int op) {
		switch (op) {
		case 1:
			findByName();
			break;
		case 2 :
			delete();
			break;
		case 3 :
			save();
			break;
		case 4 :
			update();
			break;
		case 0 :
			break;
			

		default:
			throw new IllegalArgumentException("not a valid option");
			
		}
		
	}

	

	private static void findByName() {
		System.out.println("type the name or empty to all:");
		String name = SCANNER.nextLine();
		AnimeRepository.findByName(name)
				.forEach(
						p->System.out.printf("id: %d - %s %n", p.getId(),p.getName())
				);
	}
	
	private static void delete() {
		findByName();
		System.out.println("selecione o id a ser excluido");
		int id =Integer.parseInt(SCANNER.nextLine());
		System.out.println("comfirmar a deleçao s / n");
		String choice = SCANNER.nextLine();
		if("s".equalsIgnoreCase(choice)) {
			AnimeRepository.delet(id);
		}
	}
	
	
	private static void save() {
		System.out.println("digite o nome do anime a ser salvo:");
		String name= SCANNER.nextLine();
		System.out.println("digite o numero de epsodioas");
		int epsodios =Integer.parseInt(SCANNER.nextLine());
		System.out.println("digite id do producer");
		int producer =Integer.parseInt(SCANNER.nextLine());
		
		AnimeRepository.save(Anime.builder().name(name)
				.episodes(epsodios)
				.producer(ProducerRepository.findByIdToUpdate(producer).orElseGet(null))
				.build());
	}
	
	private static void update() {
		System.out.println("difite o id do anime a ser atualizado");
		
		Optional<Anime> animeOptional = AnimeRepository.findByIdToUpdate(Integer.parseInt(SCANNER.nextLine()));
		if(animeOptional.isEmpty()) {
			System.out.println("anime nao encomtrado");
			return;
		}
		
		Anime animeFromBd = animeOptional.get();
		System.out.println("anime encomtrado : "+animeFromBd);
		
		int numero =0;
		while (true) {
			System.out.println("digite um novo numero de epsodios ");
			String in = SCANNER.nextLine();
			try {
			    numero = Integer.parseInt(in);
			    if (numero >0) {
					break;
				}else {
					System.out.println("o numero deve ser maior q zero!");
				}
			} catch (NumberFormatException e) {
			    System.out.println("O usuário não digitou um número inteiro");
			}
		}
				
		AnimeRepository.update(Anime.builder()
				.id(animeFromBd.getId())
				.episodes(numero)
				.build());
		
	}
}
