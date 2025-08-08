package teste;


import java.util.Scanner;

import services.AnimeServices;
import services.ProducerServices;



public class ConnectionFactoryTest {
	private static final Scanner SCANNER= new Scanner(System.in);
			
	public static void main(String[] args) {	
	
		
		
			int op ;
		while(true) {
			menu();
			op = Integer.parseInt(SCANNER.nextLine());
			if(op==0)break;
			switch (op) {
				case 1:
					ProducerMenu();
					op = Integer.parseInt(SCANNER.nextLine());
					ProducerServices.menu(op);
					break;
				case 2:	
					animeMenu();
					op = Integer.parseInt(SCANNER.nextLine());
					AnimeServices.menu(op);
					break;
			}
				
		}
		

	}
	
	
	private static void menu() {
		System.out.println("1 . producer menu");
		System.out.println("2 . anime menu");
		System.out.println("0 .exit");
		
	}


	private static void ProducerMenu() {
		System.out.println("digite o numero para sua operaçao");
		System.out.println("1 . procurar por producer");
		System.out.println("2 . delete producer");
		System.out.println("3 . salvar producer");
		System.out.println("4 . atualizar producer");
		System.out.println("0 . exit");
	}
	private static void animeMenu() {
		System.out.println("digite o numero para sua operaçao");
		System.out.println("1 . procurar por anime");
		System.out.println("2 . delete anime");
		System.out.println("3 . salvar anime");
		System.out.println("4 . atualizar anime");
		System.out.println("0 . exit");
	}
}
