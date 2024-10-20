package services;

import java.util.List;

public class RentavelServices<T> {
	private List<T> veiculosDisponiveis;
	
	public RentavelServices(List<T> veculosDisp) {
		this.veiculosDisponiveis=veculosDisp;
	}
	
	public T BuscarVeiculosDisponivel () {
		System.out.println("buscando veiculos diponiveis");
		T t = veiculosDisponiveis.remove(0);
		System.out.println("alugando veiculo "+t);
		System.out.println("veiculos diponiveis para alugar..");
		System.out.println(veiculosDisponiveis);
		return t ;
	}
	
	public void retornarVeiculoAlugado(T t) {
		System.out.println("Devolvendo veiculo "+t);
		veiculosDisponiveis.add(t);
		System.out.println("Veiculos disponiveis para alugar");
		System.out.println(veiculosDisponiveis);
	}
	
	
	
	
	
}
