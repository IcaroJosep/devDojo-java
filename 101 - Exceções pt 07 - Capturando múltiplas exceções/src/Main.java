
public class Main {

	public static void main(String[] args) {
		try {
			throw new ArrayIndexOutOfBoundsException();
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException");
		}catch(IndexOutOfBoundsException e) {
			System.out.println("IndexOutOfBoundsException");
		}catch(IllegalArgumentException e) {
			System.out.println("IllegalArgumentException");
		}catch(ArithmeticException e) {
			System.out.println("ArithmeticException");
		}catch(RuntimeException e) {
			System.out.println("RuntimeException");
		}		
		/*as mutiplas execoes funcionao como ifs
		 *aparatir do momento q entra em um nao entra nos outros
		 *assim tem de se comesar pela mais especifica
		 *ate a mas generalizada.
		 *se for colocada a mas generalizada a cima
		 *ele sempre entrara nela*/
	
	
	
	
	
	}

}
