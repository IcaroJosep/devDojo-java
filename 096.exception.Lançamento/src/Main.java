import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean op = true;
		Scanner in = new Scanner(System.in);
		int f, e,i=0;

		while (op) {
			System.out.println("digite o primeiro n");
			f = in.nextInt();
			System.out.println("digite o seguintdo n");
			e = in.nextInt();
			try {
				//i = f/e;
				i = divisao(f, e);
				op = false;
			} catch (RuntimeException ex) {
				ex.printStackTrace();
				System.out.println("erro tente novamente");
			}finally {
				if(!op) {
					System.out.printf("fim : i = %d\n",i);
				}
			}
			System.out.println("======================");
		}
		in.close();

	}

		
	private static int divisao(int a, int b) {
		if (b == 0) {
			throw new RuntimeException("argumento invalido");
			// lançamento manual nada abaixo deste lançamento sera executado
		}

		try {
			return a / b;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return 0;
	}

}
