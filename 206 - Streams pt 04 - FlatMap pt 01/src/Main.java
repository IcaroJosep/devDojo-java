import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	/*o .map :
	 *transformar cada elemento de um stream em um novo elemento, 
	 *de acordo com uma função que você especifica. Em outras palavras, 
	 *ele aplica uma transformação a cada elemento do stream, gerando 
	 *um novo stream com os resultados dessas transformações.
	 *
	 *ex:
	 *	List<String> nomes = Arrays.asList("Ana", "Bruno", "Carla");
		List<String> nomesComPrefixo = nomes.stream()
                                    .map(nome -> "Sr(a). " + nome)
                                    .collect(Collectors.toList());
     **********************************************************************                                 
     *Ja o flatMap():
	 *o flatMap() vai além, permitindo que você achate estruturas aninhadas 
	 *e unifique múltiplos streams em um único stream.
	 *Achatar estruturas aninhadas: 
	 *Quando você tem uma lista de listas (ou outro tipo de coleção aninhada) 
	 *e deseja obter um único stream com todos os elementos dessas listas internas.
	  Transformar um elemento em múltiplos:
	  Quando uma transformação aplicada a um elemento resulta em múltiplos elementos,
	  e você deseja incluí-los todos no stream resultante
	 *
	 **/
	public static void main(String[] args) {
		List<List<String>> devdojo = new ArrayList<>();
		List<String> l1 = List.of("icaro","josep","rocha","machado");
		List<String> l2 = List.of("jonatam","frederico","gomes");
		List<String> l3 = List.of("vai","toma","no","cu");
	
		devdojo.add(l1);
		devdojo.add(l2);
		devdojo.add(l3);
	
		List<String> pessoas=new ArrayList<>();
				
		/*colocando tudo em uma lista só, 
		 * sem a utilizaçao de stream*/
		for(List<String> lista:devdojo) {
			for(String nome:lista) {
				pessoas.add(nome);
			}
		}
		
		
		
		pessoas.forEach(nome->System.out.println(nome));
		
		System.out.println("-------------------------------");
		
		
		/*colocando tudo em uma lista só, 
		 * com utilizaçao de stream*/	
		List<String> novaLista=devdojo.stream()
									  .flatMap(l->l.stream())
									  .collect(Collectors.toList());//finalizador coleta uma lista							  
		/*l -> l.stream(): 
		 * Para cada elemento l da lista original (que é outra lista), transforma esse
		 * elemento em um novo Stream. Ou seja, cada lista dentro de devdojo se torna um 
		 * Stream individual.
		  flatMap: 
		  Junta todos esses Streams individuais em um único Stream, 
		  "achatando" a estrutura. Em vez de termos uma lista de listas, temos uma única 
		  lista com todos os elementos.
		*/
		
		novaLista.forEach(nome->System.out.println(nome));
	
	}
}












