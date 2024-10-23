


public class Main {
	private String name="icaro";
	
	static class Nestd{
		void print() {
			System.out.println(new Main().name);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Nestd nestd = new Nestd();
		nestd.print();
		/*ou*/
		new Nestd().print();
		
		
		
		
		/*firula minha*/
		/*ou anonima e estatica*/
		new Nestd() {
			@Override
			void print() {
			System.out.println("cuss");
			}
		}.print();
		
	}
	

}
