      package services;

import java.sql.Savepoint;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import dominio.Producer;
import repository.ProducerRepository;

public class ProducerServices {
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
		ProducerRepository.findByName(name)
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
			ProducerRepository.delet(id);
		}
	}
	
	
	private static void save() {
		System.out.println("digite o nome do producer a ser salvo:");
		ProducerRepository.save(Producer.builder().name(SCANNER.nextLine()).build());
	}
	
	private static void update() {
		System.out.println("difite o id do producer a ser atualizado");
		
		Optional<Producer> producerOptional = ProducerRepository.findByIdToUpdate(Integer.parseInt(SCANNER.nextLine()));
		if(producerOptional.isEmpty()) {
			System.out.println("producer nao encomtrado");
			return;
		}
		
		Producer producerFromBd = producerOptional.get();
		System.out.println("producer encomtrado : "+producerFromBd);
		System.out.println("digite um novo nome para ");
		String name = SCANNER.nextLine();
		name = name.isEmpty()?producerFromBd.getName():name;
		
		ProducerRepository.update(Producer.builder()
				.id(producerFromBd.getId())
				.name(name)
				.build());
		
	}
	

	
}
