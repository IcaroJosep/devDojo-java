package services;

import dominio.Carro;

import java.util.ArrayList;
import java.util.List;

public class CarroRentavelServices {
	
	private List<Carro> carrosDisponiveis = new ArrayList<>(List.of(new Carro("BMW"),new Carro("Fusca")));
 
	public Carro BuscarCarroDisponivel () {
		System.out.println("Buscando carro disponivel.....");
		Carro carro = carrosDisponiveis.remove(0);
		System.out.println("Alugando carro"+carro);
		System.out.println("Carros disponiveis");
		System.out.println(carrosDisponiveis);
		return carro;
	}
	
	public void retornarCarroAlugado(Carro carro) {
		System.out.println("devolvendo carro"+carro);
		carrosDisponiveis.add(carro);
		System.out.println("Carros diponiveis para alugar");
		System.out.println(carrosDisponiveis);
	}
	
	
}
