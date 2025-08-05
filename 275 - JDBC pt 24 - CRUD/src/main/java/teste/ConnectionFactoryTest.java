package teste;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import lombok.extern.log4j.Log4j2;
import services.ProducerServices;

/*implementaçao propria */


@Log4j2
public class ConnectionFactoryTest {
	public static void main(String[] args) {	
		 System.out.println("isso");
		boolean sair =false;
		Scanner scn = new Scanner(System.in);
		int op;
		while (!sair) {
		
			System.out.println("-----inicia-----\nOpcoes: \n1: conectar-se \n2: sair ");
			op = scn.nextInt();

			switch (op) {
				
			 case 1: 	
				try {
					System.out.println("usser:");
					scn.nextLine();
					String usser=scn.nextLine();
					System.out.println("senha:");
					String senha=scn.nextLine();
					Connection conn = ProducerServices.conecao(usser,senha);
					
					new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
					System.out.println("conecao com: suceso");
						
					
						while (!sair) {
							System.out.printf("---opcoes do usser---\n1:%s\n2:%s\n0:%s "
									,"listar producers","adicionar producer","voltar");
							op=scn.nextInt();
							switch (op) {
								case 1:
									 ProducerServices.listaProducer(conn,scn,op);
									break;
								case 2:
									ProducerServices.adicionaProducer(conn,scn);
									break;
								case 0:
									sair=true;
									break;	
								default:
									System.out.println("tente de novo");
									break;
							}
						
						}
					
                    
				} catch (SQLException e) {
					log.info("falha na coneçao");
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sair=false;
				break;
			 
			 case 2:
				sair=true;
				break;
				
			 default:
				 log.info("tente de novo");
				
				break;
			}
			
			
		}
		scn.close();
		
	}
}
