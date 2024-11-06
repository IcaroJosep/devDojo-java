import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Cachorro[] caes = {new Cachorro(),new Cachorro()};
		Gato[] gatos = {new Gato(),new Gato()};		
		print(caes);
		print(gatos);		
	
		
		
		List<Cachorro> cachorro = List.of(new Cachorro(),new Cachorro());
		List<Gato> cats = List.of(new Gato(),new Gato());		
System.out.println("=========================================================");		
//	quanado pasado por parametro	 uma lista tem de ser do tipo especificado 
//  neste caso seria nescessario q fosse do tipo Animal		
	
	  //printList(cachorro);
		
		List<Animal> ani=new ArrayList<>();
		ani.addAll(cats);
		ani.addAll(cachorro);
		printList(ani);
		
	}
	
	private static void print(Animal[] animals) {
		for(Animal animal: animals) {
		animal.comsulta();	
		}
	}
	
	private static void printList(List<Animal> ani) {
		
		for(Animal animal: ani) {
			animal.comsulta();	
			}
		
	}
	
	

}
