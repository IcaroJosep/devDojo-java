


class Animal{
				  /*andar*/
		public void Walk() {
			System.out.println("Animal Walking");
		}
	}


public class Main {
	
	public static void main(String[] args) {
		Animal animal = new Animal();
		animal.Walk();	
		
	/*o tipo de instanciaçao cria uma classe herdeira de 
	 * animals na qual pode sobre escrever os metodos */
		Animal animal2 = new Animal() { 
			/*criaçao de class nonima q sobre escreve o comportamento do metodo
			 *walk
			 * */
			@Override
			public void Walk() {
				System.out.println("walking in the shadows");
				/*chamamento do metodo pular*/
				junp();
			}
			/*enboara possa ser criado um metodo ele nao podera ser chamdado 
			 * diretamente pos nao existe na classe pai (animals) 
			 * mas pode ser incluso em um metodo erdado com sobre escrita*/
			public void junp() {
				System.out.println("animal jumping");
			}
			
		};
		animal2.Walk();
		
		
	}

}
