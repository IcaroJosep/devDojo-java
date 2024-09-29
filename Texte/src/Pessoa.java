
import java.util.Iterator;
import java.util.LinkedList;

public class Pessoa {
	String nome;
	LinkedList<Carro> carros=new LinkedList<Carro>();
	
	public Pessoa(String n) {
		this.nome=n;
	}
	
	public void addCarros(Carro ...carros) {
		for(Carro i:carros) {
			this.carros.add(i);
		}
	}
	
	
	
	public void imp() {
		
		Iterator<Carro> it =  carros.iterator();
		
		while(it.hasNext()) {
			Carro c = it.next();
			System.out.println(c.nome);
			
		}
		
		
	}
	
}
