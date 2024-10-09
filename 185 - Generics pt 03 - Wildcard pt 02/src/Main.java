import java.util.ArrayList;
import java.util.List;
/*
	Análise detalhada do código e dos conceitos utilizados

Conceitos-chave
Herança:
 	A classe Animal é a classe base para Cachorro e Gato, estabelecendo uma hierarquia de classes.
Polimorfismo:
 	O método comsulta() é sobreposto nas classes filhas, demonstrando o polimorfismo.
Generics:
 	A utilização de List<T> permite criar listas de tipos específicos, 
 	aumentando a segurança do tipo.
Wildcards:
 	Os wildcards ? extends e ? super fornecem flexibilidade na criação de 
 	métodos genéricos, permitindo lidar com listas de tipos relacionados.
Listas imutáveis:
 	A utilização de List.of() cria listas que não podem ser modificadas após a criação.

***************************************************************************************************************


Explicação dos métodos (print)


	print(List<? extends Animal> animals):

Wildcard ? extends Animal: 
	Indica que a lista pode conter qualquer tipo que 
	seja um subtipo de Animal (ou Animal em si).
Restrição: 
	Não é possível adicionar elementos à lista, pois o compilador não tem garantia 
	de que a lista possa armazenar qualquer tipo de Animal.
Leitura: 
	Permite iterar sobre a lista e chamar o método comsulta() para cada elemento, 
	aproveitando o polimorfismo.
	

print2(List<? super Cachorro> animals):

Wildcard ? super Cachorro:
 	Indica que a lista pode conter qualquer tipo que seja um supertipo de 
 	Cachorro (ou Cachorro em si).
Flexibilidade: 
	Permite adicionar elementos do tipo Cachorro ou de seus subtipos à lista.
Verificação de tipo: 
	É necessário realizar um instanceof para cada elemento para determinar o 
	tipo exato e chamar o método comsulta() apropriado.


print3(List<? super Animal> animals):

Wildcard ? super Animal: 
	Indica que a lista pode conter qualquer tipo que seja um supertipo de Animal.
Maior flexibilidade: 
	Permite adicionar elementos de qualquer tipo que seja um subtipo de Animal à lista.
Verificação de tipo: 
	Similar ao print2, é necessário verificar o tipo de cada elemento para chamar o método correto.


******************************************************************************************************************
Análise do código
A criação das listas caes e gatos demonstra a utilização de listas imutáveis.

A lista animals é criada como uma ArrayList para permitir a adição de elementos.

Os métodos print, print2 e print3 demonstram diferentes formas de utilizar wildcards 
para trabalhar com listas de tipos relacionados.

O comentário sobre a flexibilidade e restrição do wildcard ? extends está correto.

*********************************************************************************************************************

Considerações adicionais

Escolha do wildcard: 
	A escolha do wildcard depende do que se deseja fazer com a lista. Se a 
	intenção for apenas ler os elementos, ? extends é adequado. Se for necessário 
	adicionar elementos, ? super é mais flexível.
Verificação de tipo: 
	Ao utilizar ? super, é comum ter que realizar verificações de tipo para chamar 
	os métodos específicos de cada classe.
Generics e segurança de tipos: 
	Os generics ajudam a evitar erros de tempo de execução relacionados 
	a tipos incompatíveis.
Listas imutáveis: 
	As listas imutáveis são úteis para evitar modificações não intencionais e 
	podem melhorar a segurança do código.



Possíveis melhorias
Utilizar instanceof de forma mais eficiente: 
	Em alguns casos, pode ser possível utilizar uma estrutura switch ou um mapa 
	para evitar múltiplos instanceof.
Considerar interfaces: 
	Se Cachorro e Gato tiverem um comportamento comum além de comsulta(), pode ser 
	interessante criar uma interface para representar esse comportamento e utilizar 
	essa interface no wildcard.

Conclusão
	O código apresentado demonstra de forma clara os conceitos de herança, 
	polimorfismo, generics e wildcards em Java. A utilização de wildcards permite 
	criar métodos genéricos que podem trabalhar com listas de tipos relacionados, 
	oferecendo flexibilidade e segurança de tipo. A compreensão desses conceitos é 
	fundamental para o desenvolvimento de código Java mais eficiente e robusto.*/


/*Obs: o list.of cria a lista imutavel
 * ou seja so para leitura isso inclui os paramentros 
 * dentro de obj nesta lista */


public class Main {

	public static void main(String[] args) {
		
	List<Cachorro> caes = List.of(new Cachorro(),new Cachorro());
	List<Gato> gatos = List.of(new Gato(),new Gato());
	print(gatos);	
	print(caes);
	
	
						System.out.println("\n======================\n");
	List<Animal> animals = new ArrayList<>();
	animals.addAll(caes);
	animals.addAll(gatos);
	//print2(caes);
	print2(animals);
						System.out.println("\n======================\n");

	print3(animals);
						System.out.println("\n======================\n");
						
	print4(animals);
	
	
	}
	
	/*Flexibilidade: Esse wildcard permite que o método print
	 * aceite qualquer lista de objetos que sejam subtipos de Animal.
	 * Isso confere flexibilidade, permitindo passar listas de Gato, 
	 * Cachorro ou qualquer outra classe que herde de Animal.
	 *
	 *Restrição: Por outro lado, essa flexibilidade impõe uma limitação:
	 * a lista recebida pode ser apenas lida, mas não modificada. A 
	 * adição de novos elementos não é permitida, pois o compilador não 
	 * tem garantia de que a lista seja capaz de armazenar qualquer tipo 
	 * de Animal.*/
						//wildcard = ?
	
	//permite com tipo indicado ou seus subs //nao permite gravaçao
	private static void print(List<? extends Animal> animals) {
		//animals.add(new Gato()); // nao possivel devido a restriçao 
		for(Animal animal:animals){
			animal.comsulta();
		}
	}
	
	//permite com tipo indicado ou seus super //tbm permite gravaçao 
	private static void print2(List<? super Cachorro> animals) {
		for(Object o:animals){
			if(o instanceof Cachorro) {
				((Cachorro) o).comsulta();
			}
			if(o instanceof Gato) {
				((Gato) o).comsulta();
			}
		}
	}	
		
		//permite com tipo indicado ou seus super //tbm permite gravaçao 
	private static void print3(List<? super Animal> animals) {
		animals.add(new Gato());
		for(Object o:animals){
			if(o instanceof Cachorro) {
					((Cachorro) o).comsulta();
			}
			if(o instanceof Gato) {
					((Gato) o).comsulta();
			}
		}
		
	}
	
	//permite sem especificar o tipo
	private static void print4(List<?> animals) {
		for(Object o:animals) {
			((Animal)o).comsulta();
		}
		
	}
		
}
