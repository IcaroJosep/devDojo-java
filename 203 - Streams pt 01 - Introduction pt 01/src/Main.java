import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import dominio.LightNoval;

public class Main {
//1.odenar lightnovas por titulo
//2.tragas os 3 primeiros com valor menor q 4
	
	private static List<LightNoval> lightNoval =new ArrayList<>(List.of(
			new LightNoval("tensei shittara",8.99),
			new LightNoval("OverLord", 3.99),
			new LightNoval("Violet", 5.99),
			new LightNoval("No Game no life", 2.99),
			new LightNoval("Fullmetal Alchemist", 5.99),
			new LightNoval("Kumo desuga", 1.99),
			new LightNoval("Monogatari", 5.99)
					));
	
	public static void main(String[] args) {
/*sem Streams*/
		lightNoval.sort(Comparator.comparing(LightNoval::getTitle));
		System.out.println(lightNoval);
		
		for(LightNoval a:lightNoval) {
			if(a.getPrice()<=4) {
				System.out.println(a.getTitle());
			}
		}
	
	}

}
/*Em Java, streams representam uma abstração para sequências de dados. Ao invés de manipular 
elementos individualmente em uma coleção, os streams permitem que você aplique operações de forma 
declarativa e funcional a esses elementos. É como criar uma "tubulação" onde os dados fluem e são 
processados em etapas.

Por que utilizar Streams?

Código mais conciso e expressivo: 
As operações em streams são declarativas, o que significa que você especifica o quê fazer com os dados, 
em vez de como fazer. Isso resulta em um código mais limpo e fácil de entender.
Paralelização: 
Muitas operações em streams podem ser executadas em paralelo, aproveitando múltiplos núcleos de processador 
e melhorando o desempenho, especialmente em grandes conjuntos de dados.
Laziness: 
As operações em streams são frequentemente "lazy", ou seja, são executadas apenas quando o resultado final é 
necessário. Isso pode otimizar o processamento, evitando cálculos desnecessários.
Funcional: 
Streams se encaixam bem no paradigma de programação funcional, permitindo o uso de funções de alta ordem 
(como map, filter, reduce) para transformar e filtrar dados.

Operações Comuns em Streams:

map: Aplica uma função a cada elemento do stream, transformando-o em um novo elemento.
filter: Filtra os elementos de um stream com base em uma condição.
reduce: Reduz um stream a um único valor, aplicando uma operação combinatória a cada elemento.
sorted: Ordena os elementos de um stream.
collect: Coleta os elementos de um stream em uma nova coleção (lista, conjunto, etc.).

Exemplo:

Java
import java.util.Arrays;
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4,   
 5);

        // Encontrar a soma dos números pares
        int sumOfEvenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n) // Elevar ao quadrado os números pares
                .reduce(0, Integer::sum);

        System.out.println(sumOfEvenNumbers); // Imprime 20
    }
}

Quando usar Streams?

Streams são ideais para:

Processamento de coleções: 
Filtrar, mapear, reduzir e transformar elementos de listas, conjuntos e outros tipos de coleções.
Manipulação de dados: 
Processar dados de arquivos, bancos de dados e outras fontes.
Operações paralelas: 
Explorar o poder de processamento de múltiplos núcleos.


Em resumo:

Streams são uma ferramenta poderosa e moderna em Java que simplifica o trabalho com coleções de dados. 
Ao entender os conceitos básicos e as operações comuns, você poderá escrever código mais expressivo, 
eficiente e fácil de manter.
*/
