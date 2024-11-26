import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {


	public static void main(String[] args) {
		File arq = new File("Aquivo-texte-01.txt");
		try {
			 
			if(arq.createNewFile()) {
				System.out.println("arquivo criado com sucesso:"+arq.toString());
			}else {
				System.out.println("arquivo existent");
			}
			
		
			
		}catch (Exception e) {
			System.err.println("erro na criaçao de arquivo");
			e.printStackTrace();
		}
		
		
	/*	try {
			FileWriter a = new FileWriter(arq);
			a.write("Icaro\n");
			a.write("Josep\n");		
			a.close();
		} catch (Exception e) {
			System.err.println("erro na escrita de arquivo");
			e.printStackTrace();
		}
	*/	
		
		try {
			FileWriter a = new FileWriter(arq,true);
			a.write("rocha\n");
			a.write("machado\n");		
			a.close();
		} catch (Exception e) {
			System.err.println("erro na escrita de arquivo");
			e.printStackTrace();
		}
		
		
		try {
			Scanner a = new Scanner(arq);
			while (a.hasNextLine()) {
				System.out.println(a.nextLine());				
			}
			a.close();
		} catch (Exception e) {
			System.err.println("erro na leitura de arquivo");
			e.printStackTrace();
		}
		
		
		
	}
	
}
