import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// tratamento da excepiton lan�ada
		try {
			Logar();
		} catch (LoginInvalidoException e) {
			e.printStackTrace();
		}

	}

	// o metodo lan�a uma exce�ao
	public static void Logar() throws LoginInvalidoException {
		Scanner in = new Scanner(System.in);
		String usernameDB = "goku", senhaDB = "ssj";

		System.out.println("Usuariao:");
		String userDigitado = in.nextLine();
		System.out.println("senha:");
		String senhaDigitado = in.nextLine();
		in.close();

		// lan�ando execao
		if (!usernameDB.equals(userDigitado) || (!senhaDB.equals(senhaDigitado))) {
			throw new LoginInvalidoException("login invalido");
		}

		System.out.println("usuario logado");

	}

}
