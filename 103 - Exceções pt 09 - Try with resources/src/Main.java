import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/*O try-with-resources � uma sintaxe de a��car que simplifica
 *o uso do bloco finally para fechar recursos. Quando voc� declara
 *um recurso dentro dos par�nteses do try, o compilador insere 
 *automaticamente um bloco finally que chama o m�todo close() desse 
 *recurso.*/

//classes com este recurso
/*para criar uma clase q aceite o fe�amento automatico pelo try
 *� nesesario q ela tenha a interface Closeable ou AutoCloseable,
 *ao inplementar a inteface cria a nesesidade de inplemtar um metodo 
 *close na clase para q possa ser chamado automaticamente pelo try*/

public class Main {
/*try com recursos*/

	public static void main(String[] args) {
	
	lerArq("teste.txt");
	System.err.println("===================");
	lerArqCRecuso("teste.txt");
	
	}
	
	/*com recursos 
	 *ele fei�a o fluxo automaticamente apos a execu�ao do try
	 *OBS: ele faz o feixamento em ordem reversa a abertura por
	 *
	 *exemplo o usuario liga o combutador e se conecta  no site e o site se conecta ao banco de dados
	 *ofechamento ocorrera na ordem reverssa desconectara do banco depos do site e por fim do pc*/
	
	public static void lerArqCRecuso(String arq) {
		/*O BufferedReader � criado.
		*O bloco try � executado.	
		*Se ocorrer uma exce��o, o bloco catch � executado.
		*Independentemente de ocorrer uma exce��o ou n�o, o m�todo close() do BufferedReader � chamado automaticamente.*/
		try(BufferedReader reader = new BufferedReader(new FileReader(arq))){
			String linha;
			while ((linha = reader.readLine()) != null) {
		        System.out.println(linha);
		    }
		}catch(Exception e){
			e.printStackTrace();
		}
	
}


	/*sem recusos*/
	public static void lerArq(String arq) {
		
		BufferedReader reader=null;
		try{
			reader = new BufferedReader(new FileReader(arq));
			String linha;
			
		    while ((linha = reader.readLine()) != null) {
		        System.out.println(linha);
		    }
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
		    try {
		        if (reader != null) {
		            reader.close();
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}
		
	}
	
}
