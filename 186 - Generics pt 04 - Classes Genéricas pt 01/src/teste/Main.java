package teste;
/* toda a aula 186 é apenas a implementacao de um exeplo
 * que sera urilizado como base para a procima aula
 * 
 * aqui nao foi ussado generics é uma demostracao de duas clases diferetes
 * mas que tem sua programacao completamente igual*/

import dominio.Barco;
import dominio.Carro;
import services.BarcoRentavelServices;
import services.CarroRentavelServices;

public class Main {

	public static void main(String[] args) {
		
		CarroRentavelServices carroRentavelServices = new CarroRentavelServices();
		
		Carro carro = carroRentavelServices.BuscarCarroDisponivel();
		System.out.println("\nussando o carro por um mes ...");
		
		carroRentavelServices.retornarCarroAlugado(carro);
	
System.out.println("\n\n========*barcos*========\n\n");
		
		BarcoRentavelServices barcoRentavelServices = new BarcoRentavelServices();
		
		Barco barco = barcoRentavelServices.BuscarBarcoDisponivel();
		System.out.println("\nussando o barco por um mes ...");
		
		barcoRentavelServices.retornarBarcoAlugado(barco);
	
	}
} 
