/*qundo se tem uma classe 
 *dentro de um metodo
 * */


public class Main {
	private String nome ="icaro";
	
	void print() {
		class LocalClass{
			public void printLocal() {
				System.out.println(nome);
			}
		}
		LocalClass localClass = new LocalClass();
		localClass.printLocal();
	}
	

	public static void main(String[] args) {
		Main main = new Main();
		main.print();

	}

}
