package dominio;

public class Carro {
	private String nome;
	
	public Carro(String nome) {
		this.nome=nome;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Carro{"+"nome="+nome+'\''+'}';
	}


}
