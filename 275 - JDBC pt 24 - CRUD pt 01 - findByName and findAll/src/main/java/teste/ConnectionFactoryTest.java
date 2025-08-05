package teste;


import java.util.Scanner;

import repository.AnimeRepository;
import services.ProducerServices;



public class ConnectionFactoryTest {
	private static final Scanner SCANNER= new Scanner(System.in);
			
	public static void main(String[] args) {	
	System.out.println(AnimeRepository.findByName("clove"));
		
		
/*			int op ;
		while(true) {
			menu();
			op = Integer.parseInt(SCANNER.nextLine());
			if(op==0)break;
			ProducerServices.menu(op);
			
		}
		
*/
	}
	private static void menu() {
		System.out.println("digite o numero para sua operaçao");
		System.out.println("1 . procurar por producer");
		System.out.println("2 . delete producer");
		System.out.println("3 . salvar producer");
		System.out.println("4 . atualizar producer");
		System.out.println("0 . exit");
	}
}
