import java.util.ArrayList;
import java.util.List;
/*
	An�lise detalhada do c�digo e dos conceitos utilizados

Conceitos-chave
Heran�a:
 	A classe Animal � a classe base para Cachorro e Gato, estabelecendo uma hierarquia de classes.
Polimorfismo:
 	O m�todo comsulta() � sobreposto nas classes filhas, demonstrando o polimorfismo.
Generics:
 	A utiliza��o de List<T> permite criar listas de tipos espec�ficos, 
 	aumentando a seguran�a do tipo.
Wildcards:
 	Os wildcards ? extends e ? super fornecem flexibilidade na cria��o de 
 	m�todos gen�ricos, permitindo lidar com listas de tipos relacionados.
Listas imut�veis:
 	A utiliza��o de List.of() cria listas que n�o podem ser modificadas ap�s a cria��o.

***************************************************************************************************************


Explica��o dos m�todos (print)


	print(List<? extends Animal> animals):

Wildcard ? extends Animal: 
	Indica que a lista pode conter qualquer tipo que 
	seja um subtipo de Animal (ou Animal em si).
Restri��o: 
	N�o � poss�vel adicionar elementos � lista, pois o compilador n�o tem garantia 
	de que a lista possa armazenar qualquer tipo de Animal.
Leitura: 
	Permite iterar sobre a lista e chamar o m�todo comsulta() para cada elemento, 
	aproveitando o polimorfismo.
	

print2(List<? super Cachorro> animals):

Wildcard ? super Cachorro:
 	Indica que a lista pode conter qualquer tipo que seja um supertipo de 
 	Cachorro (ou Cachorro em si).
Flexibilidade: 
	Permite adicionar elementos do tipo Cachorro ou de seus subtipos � lista.
Verifica��o de tipo: 
	� necess�rio realizar um instanceof para cada elemento para determinar o 
	tipo exato e chamar o m�todo comsulta() apropriado.


print3(List<? super Animal> animals):

Wildcard ? super Animal: 
	Indica que a lista pode conter qualquer tipo que seja um supertipo de Animal.
Maior flexibilidade: 
	Permite adicionar elementos de qualquer tipo que seja um subtipo de Animal � lista.
Verifica��o de tipo: 
	Similar ao print2, � necess�rio verificar o tipo de cada elemento para chamar o m�todo correto.


******************************************************************************************************************
An�lise do c�digo
A cria��o das listas caes e gatos demonstra a utiliza��o de listas imut�veis.

A lista animals � criada como uma ArrayList para permitir a adi��o de elementos.

Os m�todos print, print2 e print3 demonstram diferentes formas de utilizar wildcards 
para trabalhar com listas de tipos relacionados.

O coment�rio sobre a flexibilidade e restri��o do wildcard ? extends est� correto.

*********************************************************************************************************************

Considera��es adicionais

Escolha do wildcard: 
	A escolha do wildcard depende do que se deseja fazer com a lista. Se a 
	inten��o for apenas ler os elementos, ? extends � adequado. Se for necess�rio 
	adicionar elementos, ? super � mais flex�vel.
Verifica��o de tipo: 
	Ao utilizar ? super, � comum ter que realizar verifica��es de tipo para chamar 
	os m�todos espec�ficos de cada classe.
Generics e seguran�a de tipos: 
	Os generics ajudam a evitar erros de tempo de execu��o relacionados 
	a tipos incompat�veis.
Listas imut�veis: 
	As listas imut�veis s�o �teis para evitar modifica��es n�o intencionais e 
	podem melhorar a seguran�a do c�digo.



Poss�veis melhorias
Utilizar instanceof de forma mais eficiente: 
	Em alguns casos, pode ser poss�vel utilizar uma estrutura switch ou um mapa 
	para evitar m�ltiplos instanceof.
Considerar interfaces: 
	Se Cachorro e Gato tiverem um comportamento comum al�m de comsulta(), pode ser 
	interessante criar uma interface para representar esse comportamento e utilizar 
	essa interface no wildcard.

Conclus�o
	O c�digo apresentado demonstra de forma clara os conceitos de heran�a, 
	polimorfismo, generics e wildcards em Java. A utiliza��o de wildcards permite 
	criar m�todos gen�ricos que podem trabalhar com listas de tipos relacionados, 
	oferecendo flexibilidade e seguran�a de tipo. A compreens�o desses conceitos � 
	fundamental para o desenvolvimento de c�digo Java mais eficiente e robusto.*/


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
	
	/*Flexibilidade: Esse wildcard permite que o m�todo print
	 * aceite qualquer lista de objetos que sejam subtipos de Animal.
	 * Isso confere flexibilidade, permitindo passar listas de Gato, 
	 * Cachorro ou qualquer outra classe que herde de Animal.
	 *
	 *Restri��o: Por outro lado, essa flexibilidade imp�e uma limita��o:
	 * a lista recebida pode ser apenas lida, mas n�o modificada. A 
	 * adi��o de novos elementos n�o � permitida, pois o compilador n�o 
	 * tem garantia de que a lista seja capaz de armazenar qualquer tipo 
	 * de Animal.*/
						//wildcard = ?
	
	//permite com tipo indicado ou seus subs //nao permite grava�ao
	private static void print(List<? extends Animal> animals) {
		//animals.add(new Gato()); // nao possivel devido a restri�ao 
		for(Animal animal:animals){
			animal.comsulta();
		}
	}
	
	//permite com tipo indicado ou seus super //tbm permite grava�ao 
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
		
		//permite com tipo indicado ou seus super //tbm permite grava�ao 
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
