/*utilizada principalmente em interfaces 
	 *graficas.
	 *
	 **/
public class Main {
	private String name = "monkey D. luffy";
	
	class Inner{
		public void printOuterClassAtributes() {
			System.out.println(name);
		}
	}
	
	public static void main(String[] args) {
		Main main =new Main();
		
		Main.Inner inner = main.new Inner();
		
		inner.printOuterClassAtributes();
	}

}
