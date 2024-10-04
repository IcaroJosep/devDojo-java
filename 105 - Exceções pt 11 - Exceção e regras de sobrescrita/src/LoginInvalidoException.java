/*esta classe foi reaproveitada da aula 104*/





								//define a clase como filha de exception
public class LoginInvalidoException extends Exception {

	

//costrutores q inicializao msg comtida na classe pai
	
	//padao caso nao seja adicionada nem uma mensagem na chamada
	public LoginInvalidoException() {
		super("login invalido");
	}
	//com msg personalisada na chamada
	public LoginInvalidoException(String menssage) {
		super(menssage);
	}

}
