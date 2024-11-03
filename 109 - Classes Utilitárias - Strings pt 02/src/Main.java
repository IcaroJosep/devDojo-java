
public class Main {
	/*	
	 * PRINCIPAIS METODOS 
	 * */

	public static void main(String[] args) {
			String nome = "luffy";
			
			/*para pegar char no index 4*/
			System.out.printf("index [4] :%s \n",nome.charAt(0));
			
			/*terorna tamanho*/
			System.out.printf("retorna tamanho : %d \n",nome.length());
			
			/*subustitui uma letra por outra percorendo o array de char
			 *porem nao autera a string original a nao ser q seja usada para atruibuiçao */
			System.out.printf("subustitui as letras de f para g :%s",nome.replace("f", "g"));
			
			
	}

}
