package dominio;

public class Car {
	private String nome = "Audi";
	private String color ;
	private int year ;
	
	public Car(String color, int year) {
		this.color=color;
		this.year=year;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getYear() {
		return year;
	}

	@Override
	public String toString() {
		
		   return String.format("Nome: %s, Cor: %s, Ano: %d", nome,color, year);
	}
	
	
	
}
