package dominio;

public class Accout {
	private int saldo = 50;

	public void saque(int valor) {
		this.saldo=this.saldo-valor;
	}
	
	public int getSaldo() {
		return saldo;
	}

		
}
