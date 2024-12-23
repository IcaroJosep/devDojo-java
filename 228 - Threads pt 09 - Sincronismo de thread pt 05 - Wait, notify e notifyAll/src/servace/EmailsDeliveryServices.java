package servace;

import dominio.Menbros;

public class EmailsDeliveryServices implements Runnable {
	private final Menbros menbros;
	
	public EmailsDeliveryServices (Menbros menbros) {
		this.menbros=menbros;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		while(menbros.isOpem()|| menbros.EmailsPendentes()>0) {
			try {
				String email = menbros.recuperaEmail();
				System.out.println(Thread.currentThread().getName()+" enviando email para "+email);
				Thread.sleep(2000);
				System.out.println(Thread.currentThread().getName()+" enviou email com sucesso para "+email);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("todos os emails foram enviados com sucesso!");
	}
	
}
