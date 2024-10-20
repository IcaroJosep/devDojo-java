package teste;
/* esta aula retira duas clases do pacote services 
 * e as subustitue por uma clase generica 
 * chamada "rentavelservices" 
 * rentavelservices se trata de uma classe generica
 * */

import java.util.ArrayList;
import java.util.List;

import dominio.Barco;
import dominio.Carro;
import services.RentavelServices;

public class Main {

	public static void main(String[] args) {
		List<Carro> carrosDisponiveis = new ArrayList<>(List.of(new Carro("BMW"),new Carro("Fusca")));
		List<Barco> barcosDisponiveis = new ArrayList<>(List.of(new Barco("yate"),new Barco("lancha")));
	
		
System.out.println("\n\n\n========*com generic*========\n");

		RentavelServices<Barco> rentavelservices = new RentavelServices<>(barcosDisponiveis);
		Barco barco2 = rentavelservices.BuscarVeiculosDisponivel();
		
		System.out.println("\nussando o veiculo por um mes ...");
		
		rentavelservices.retornarVeiculoAlugado(barco2);
		
		
	}
} 
