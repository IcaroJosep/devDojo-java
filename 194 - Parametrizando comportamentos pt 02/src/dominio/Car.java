package dominio;

public class Car {
	public String nome = "Audi";
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

	public void setYear(int year) {
		this.year = year;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Car{"+
				"name="+nome+"color="+color+"ano="+year;
	}
	
}
