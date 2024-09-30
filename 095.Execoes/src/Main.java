import java.io.File;
import java.io.IOException;

public class Main {
	/*
	 * 
	 * */
	public static void main(String[] args) {
															System.out.println("\n\n////////////////////RuntimeExepition /////////////////\n");
//RuntimeExepition 
	 /*ArrayIndexOutOfBoundsException
	 *esta tentando acessar posicao inesistemte*/	
		int[] a = {4,5};
		
		try {//posivel tratar mas nao indicado
			System.out.println(a[2]);
		} catch (Exception e) {
			System.out.println("local fora do array");
		}

															System.out.println("\n\n////////////////////exception/////////////////\n");
//exexoes chacket filhas diretas de exception
		
		/*com fluxo normal a a criacao do arquibo dente da pasta 095.Execoes*/

		/*apos a primeira execuçao lançara o erro
		 *devido ao retorno false de createNewFile()*/
															System.out.println("\n\n=========================criacao de arquivo=============\n");

		File file=new File("a\\arquivo"); 
		//obs: se tu tirar o a\\ elepara de lançar a exceçao
		
		try {
			 
			if (file.createNewFile()) {//o erro é lançado devido a nao existir o caminho(pasta a)
                System.out.println("ARQV criado");
            } else {
                System.out.println("ARQV ja existe");
            }
		}catch (IOException e) {
			System.out.println("erro");
			e.printStackTrace();			
		}finally{
			System.out.println("fim");
		}
		
			
															System.out.println("\n\n=========================criacao de diretorio=============\n");
	
		/*com fluxo normal a a criacao do diretorio dente da pasta 095.Execoes*/
		
		File diretorio = new File("meu_novo_diretorio"); // Nome do diretório
		
        try {
            if (diretorio.mkdirs()) {
                System.out.println("Diretório criado com sucesso!");
            } else {
                System.out.println("O diretório já existe ou ocorreu um erro ao criá-lo.");
            }
        } catch (SecurityException e) {
            System.err.println("Você não tem permissão para criar o diretório.");
        }
    
		
	
		
		
		
		
	}
}
