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
/*Em Java, streams representam uma abstra��o para sequ�ncias de dados. Ao inv�s de manipular 
elementos individualmente em uma cole��o, os streams permitem que voc� aplique opera��es de forma 
declarativa e funcional a esses elementos. � como criar uma "tubula��o" onde os dados fluem e s�o 
processados em etapas.

Por que utilizar Streams?

C�digo mais conciso e expressivo: 
As opera��es em streams s�o declarativas, o que significa que voc� especifica o qu� fazer com os dados, 
em vez de como fazer. Isso resulta em um c�digo mais limpo e f�cil de entender.
Paraleliza��o: 
Muitas opera��es em streams podem ser executadas em paralelo, aproveitando m�ltiplos n�cleos de processador 
e melhorando o desempenho, especialmente em grandes conjuntos de dados.
Laziness: 
As opera��es em streams s�o frequentemente "lazy", ou seja, s�o executadas apenas quando o resultado final � 
necess�rio. Isso pode otimizar o processamento, evitando c�lculos desnecess�rios.
Funcional: 
Streams se encaixam bem no paradigma de programa��o funcional, permitindo o uso de fun��es de alta ordem 
(como map, filter, reduce) para transformar e filtrar dados.

Opera��es Comuns em Streams:

map: Aplica uma fun��o a cada elemento do stream, transformando-o em um novo elemento.
filter: Filtra os elementos de um stream com base em uma condi��o.
reduce: Reduz um stream a um �nico valor, aplicando uma opera��o combinat�ria a cada elemento.
sorted: Ordena os elementos de um stream.
collect: Coleta os elementos de um stream em uma nova cole��o (lista, conjunto, etc.).

Exemplo:

Java
import java.util.Arrays;
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, � 
 5);

        // Encontrar a soma dos n�meros pares
        int sumOfEvenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n) // Elevar ao quadrado os n�meros pares
                .reduce(0, Integer::sum);

        System.out.println(sumOfEvenNumbers); // Imprime 20
    }
}

Quando usar Streams?

Streams s�o ideais para:

Processamento de cole��es: 
Filtrar, mapear, reduzir e transformar elementos de listas, conjuntos e outros tipos de cole��es.
Manipula��o de dados: 
Processar dados de arquivos, bancos de dados e outras fontes.
Opera��es paralelas: 
Explorar o poder de processamento de m�ltiplos n�cleos.


Em resumo:

Streams s�o uma ferramenta poderosa e moderna em Java que simplifica o trabalho com cole��es de dados. 
Ao entender os conceitos b�sicos e as opera��es comuns, voc� poder� escrever c�digo mais expressivo, 
eficiente e f�cil de manter.
*/
