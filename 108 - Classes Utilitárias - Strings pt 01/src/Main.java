public class Main {
/*	String no java sao imutaveis.
 * */
	public static void main(String[] args) {
		
		String s1 = "Ol�"; // Referencia uma string no pool
		String s2 = "Ol�"; // Referencia a mesma string no pool
		String s3 = new String("Ol�"); // Cria um novo objeto string
		String s4 = s1 + " Mundo"; // Cria um novo objeto string com a concatena��o
		
	  /*s1 e s2 referenciam a mesma string no pool.
		s3 referencia um objeto string diferente, mesmo tendo o mesmo valor.
		s4 referencia um novo objeto string criado pela concatena��o.
	  */
			
			//esta compara�ao compara espa�o na memoria
		System.out.println(s1==s2);
		System.out.println(s1==s3);
			//esta compara�ao compara comteudo 
		System.out.println(s1.equals(s3));
		
	}

}
/*
Aloca��o na Mem�ria:
Ao criar uma string, o Java aloca um espa�o na mem�ria para armazenar a sequ�ncia de caracteres.

Refer�ncia �nica:
Se duas vari�veis de tipo string possuem o mesmo valor literal, elas referenciam o mesmo espa�o 
na mem�ria, ou seja, apontam para o mesmo objeto string.
Cria��o de Novos Objetos: A sintaxe String s1 = new String("conte�do") for�a a cria��o de um novo 
objeto string, mesmo que j� exista outro com o mesmo valor, ocupando assim um novo espa�o na mem�ria.

Imutabilidade:
Strings em Java s�o imut�veis, o que significa que o valor de uma string n�o pode ser alterado ap�s sua cria��o.

Concaten��o:
Quando voc� concatena duas strings, sempre � criado um novo objeto string para armazenar o resultado 
da concatena��o. Isso ocorre mesmo que voc� n�o atribua o resultado a uma nova vari�vel. O Java realiza 
essa otimiza��o para garantir a imutabilidade das strings originais.

Coletores de Lixo: 
Strings que n�o s�o mais referenciadas por nenhuma vari�vel s�o automaticamente coletadas pelo garbage 
collector do Java, liberando o espa�o de mem�ria ocupado. No entanto, se voc� continua referenciando a 
string original e a nova string criada pela concatena��o, ambas permanecer�o na mem�ria.

String Pool: 
O Java utiliza uma �rea especial da mem�ria chamada "string pool" para armazenar strings literais. 
Quando voc� declara uma string com um valor literal, o Java verifica se essa string j� existe no pool. 
Se existir, a nova vari�vel ir� referenciar a string existente no pool, evitando a cria��o de um novo objeto.


Resumo e Exemplos:
String s1 = "Ol�"; // Referencia uma string no pool
String s2 = "Ol�"; // Referencia a mesma string no pool
String s3 = new String("Ol�"); // Cria um novo objeto string
String s4 = s1 + " Mundo"; // Cria um novo objeto string com a concatena��o

s1 e s2 referenciam a mesma string no pool.
s3 referencia um objeto string diferente, mesmo tendo o mesmo valor.
s4 referencia um novo objeto string criado pela concatena��o.

Por que a Imutabilidade?

Seguran�a: 
Evita modifica��es acidentais em strings que s�o compartilhadas por diferentes partes do c�digo.

Efici�ncia: 
Permite otimiza��es como o string pool e facilita a implementa��o de estruturas de dados imut�veis.

Concorr�ncia: 
Strings imut�veis s�o thread-safe, o que significa que podem ser usadas em ambientes multi-thread 
sem a necessidade de sincroniza��o adicional.
 */






