/*codigo base da aula 228 
 * alteracoes para utilizacao direta do lock com condition
 * na classe menbros*/


package texte;

import javax.swing.JOptionPane;

import dominio.Menbros;
import servace.EmailsDeliveryServices;

public class EmailDeliveryTexte01 {

	public static void main(String[] args) {
		Menbros menbros = new Menbros();
		
		Thread icaro = new Thread(new EmailsDeliveryServices(menbros),"icaro");
		Thread josep = new Thread(new EmailsDeliveryServices(menbros),"josep");
		
		icaro.start();
		josep.start();
	
		while(true) {
			String email = JOptionPane.showInputDialog("Entre com email");
			if(email==null||email.isEmpty()) {
				menbros.close();
				break;
			}
			menbros.addMenberEmail(email);
		}
	
	}

}
