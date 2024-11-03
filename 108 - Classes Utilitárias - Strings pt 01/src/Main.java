public class Main {
/*	String no java sao imutaveis.
 * */
	public static void main(String[] args) {
		
		String s1 = "Olá"; // Referencia uma string no pool
		String s2 = "Olá"; // Referencia a mesma string no pool
		String s3 = new String("Olá"); // Cria um novo objeto string
		String s4 = s1 + " Mundo"; // Cria um novo objeto string com a concatenação
		
	  /*s1 e s2 referenciam a mesma string no pool.
		s3 referencia um objeto string diferente, mesmo tendo o mesmo valor.
		s4 referencia um novo objeto string criado pela concatenação.
	  */
			
			//esta comparaçao compara espaço na memoria
		System.out.println(s1==s2);
		System.out.println(s1==s3);
			//esta comparaçao compara comteudo 
		System.out.println(s1.equals(s3));
		
	}

}
/*
Alocação na Memória:
Ao criar uma string, o Java aloca um espaço na memória para armazenar a sequência de caracteres.

Referência Única:
Se duas variáveis de tipo string possuem o mesmo valor literal, elas referenciam o mesmo espaço 
na memória, ou seja, apontam para o mesmo objeto string.
Criação de Novos Objetos: A sintaxe String s1 = new String("conteúdo") força a criação de um novo 
objeto string, mesmo que já exista outro com o mesmo valor, ocupando assim um novo espaço na memória.

Imutabilidade:
Strings em Java são imutáveis, o que significa que o valor de uma string não pode ser alterado após sua criação.

Concatenção:
Quando você concatena duas strings, sempre é criado um novo objeto string para armazenar o resultado 
da concatenação. Isso ocorre mesmo que você não atribua o resultado a uma nova variável. O Java realiza 
essa otimização para garantir a imutabilidade das strings originais.

Coletores de Lixo: 
Strings que não são mais referenciadas por nenhuma variável são automaticamente coletadas pelo garbage 
collector do Java, liberando o espaço de memória ocupado. No entanto, se você continua referenciando a 
string original e a nova string criada pela concatenação, ambas permanecerão na memória.

String Pool: 
O Java utiliza uma área especial da memória chamada "string pool" para armazenar strings literais. 
Quando você declara uma string com um valor literal, o Java verifica se essa string já existe no pool. 
Se existir, a nova variável irá referenciar a string existente no pool, evitando a criação de um novo objeto.


Resumo e Exemplos:
String s1 = "Olá"; // Referencia uma string no pool
String s2 = "Olá"; // Referencia a mesma string no pool
String s3 = new String("Olá"); // Cria um novo objeto string
String s4 = s1 + " Mundo"; // Cria um novo objeto string com a concatenação

s1 e s2 referenciam a mesma string no pool.
s3 referencia um objeto string diferente, mesmo tendo o mesmo valor.
s4 referencia um novo objeto string criado pela concatenação.

Por que a Imutabilidade?

Segurança: 
Evita modificações acidentais em strings que são compartilhadas por diferentes partes do código.

Eficiência: 
Permite otimizações como o string pool e facilita a implementação de estruturas de dados imutáveis.

Concorrência: 
Strings imutáveis são thread-safe, o que significa que podem ser usadas em ambientes multi-thread 
sem a necessidade de sincronização adicional.
 */






