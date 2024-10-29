import java.util.function.BiFunction;
import java.util.function.Supplier;

import dominio.Pessoa;

public class Main {

	public static void main(String[] args) {
		//metodo comstrutor sem parametros
		Supplier<Pessoa> newPessoa=Pessoa::new;
		Pessoa p1=newPessoa.get();
		System.out.printf("nome : %s \nidade : %s ",p1.nome,(p1.idade<0)?"null":Integer.toString(p1.idade));

		
		
		BiFunction<String, Integer, Pessoa> newPessoa2 = Pessoa::new; 
		Pessoa p2=newPessoa2.apply("icaro", 27);
		System.out.printf("\nnome : %s \nidade : %s ",p2.nome,(p2.idade<0)?"null":Integer.toString(p2.idade));

		
	}

}
