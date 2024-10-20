package services;

import dominio.Barco;

import java.util.ArrayList;
import java.util.List;

public class BarcoRentavelServices {
	
	private List<Barco> barcosDisponiveis = new ArrayList<>(
			List.of(new Barco("yate"),new Barco("lancha"))
			);
 
	public Barco BuscarBarcoDisponivel () {
		System.out.println("Buscando barco disponivel.....");
		Barco barco = barcosDisponiveis.remove(0);
		System.out.println("Alugando barco"+barco);
		System.out.println("Barcos disponiveis");
		System.out.println(barcosDisponiveis);
		return barco;
	}
	
	public void retornarBarcoAlugado(Barco barco) {
		System.out.println("devolvendo barco"+barco);
		barcosDisponiveis.add(barco);
		System.out.println("Barcos diponiveis para alugar");
		System.out.println(barcosDisponiveis);
	}
	
	
}
