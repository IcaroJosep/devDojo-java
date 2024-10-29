import java.util.List;
import java.util.Optional;

public class Main {
/*	optional:
 * tenta evitar o nullPointExeption
 * */
	public static void main(String[] args) {
		Optional<String> o1 = Optional.ofNullable("icaro");
		System.out.println(o1);
		
		
	//	String name=findName("icaro");
	//	System.out.println(name.toUpperCase());
		
		
	}
	private static String findName (String name) {
		List<String> list = List.of("icaro","josep");
		int i =list.indexOf(name);
		if(i<0) {
			return list.get(i);
		}
		return null;
	}

}

/*
Optional é uma classe introduzida no Java 8 para lidar de forma mais elegante com valores que podem ou não existir. 
Em vez de retornar null e correr o risco de NullPointerExceptions, você encapsula um valor opcional em um objeto Optional. 
Isso torna o código mais seguro e expressivo.

Para que serve?

Evitar NullPointerExceptions: Ao invés de retornar null, você retorna um Optional.empty(). Ao tentar acessar o valor, 
você precisa verificar explicitamente se ele está presente usando métodos como isPresent().
Melhorar a legibilidade do código: O uso de Optional torna o código mais claro, indicando explicitamente que um valor 
pode estar ausente.
Simplificar o tratamento de valores opcionais: O Optional fornece diversos métodos úteis para manipular valores opcionais, 
como map, flatMap, orElse, orElseGet, etc.

Modos de Uso Comuns
Criando um Optional:

Com um valor presente:

Optional<String> optionalString = Optional.of("Hello");


Vazio:

Optional<String> emptyOptional = Optional.empty();


De um valor que pode ser nulo:

String nullableString = null;
Optional<String> optionalNullable = Optional.ofNullable(nullableString);


Verificando se um valor está presente:

if (optionalString.isPresent()) {
    String value = optionalString.get();
    System.out.println(value);
}

Obtendo o valor ou um valor padrão:

String defaultValue = "World";
String value = optionalString.orElse(defaultValue);


Executando uma ação se o valor estiver presente:

optionalString.ifPresent(s -> System.out.println(s.length()));


Mapeando o valor:

Optional<Integer> optionalLength = optionalString.map(String::length);


Achatando Optional dentro de Optional:

Optional<Optional<String>> nested = Optional.of(Optional.of("Hello"));
Optional<String> flattened = nested.flatMap(Optional::get);
Use o código com cuidado.

Exemplo Completo:

public class OptionalExample {
    public static void main(String[] args) {
        Optional<String> name = Optional.ofNullable(null);

        name.ifPresent(n -> System.out.println("Hello,   
 " + n + "!"));

        String greeting = name.orElse("Stranger");
        System.out.println(greeting);

        Optional<Integer> length = name.map(String::length);
        length.ifPresent(l -> System.out.println("The name has " + l + " characters."));
    }
}


Quando Usar Optional?
Retornos de métodos: Quando um método pode não ter um valor a retornar, use Optional para indicar isso explicitamente.
Dados opcionais em objetos: Utilize Optional para representar atributos que podem não estar presentes em um objeto.
Tratamento de erros: Embora Optional não seja um mecanismo de tratamento de erros, ele pode ser usado para indicar a 
ausência de um resultado esperado, complementando as exceções.*/
