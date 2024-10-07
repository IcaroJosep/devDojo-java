
public class Main {

	public static void main(String[] args) {
		Cachorro[] caes = {new Cachorro(),new Cachorro()};
		Gato[] gatos = {new Gato(),new Gato()};		
		print(caes);
		print(gatos);		
	}
	private static void print(Animal[] animals) {
		for(Animal animal: animals) {
		animal.comsulta();	
		}
	}

}
