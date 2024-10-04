import java.io.FileNotFoundException;

public class Main {
/*	na classe pessoa instanciada diretamente
 * 	o metodo ssalvar pode lan�ar execoes (LoginInvalidoException,FileNotFoundException)
 * 	
 * 	ja na sobre escrita do metodo salvar na classe funcionario
 * 	pode ser feita sem pos vc esta sobre escrevendo o metodo e como sobre escria o metodo poder 
 * 	agir de modo diferente da clase pai
 * 
 * 	
 * 	obs:porem se vc for lan�ar execoes tbm no metodo da classe filho
 * 	temos algumas regras:
 * 	1.na sobre escriata nao � nesesario lan�ar exe�ao
 * 	2.vc pode lan�ar uma ou todas as execoes dometodo original
 * 	3.vc pode add qualquer exe�ao do tipo unchecked filhas de runtime
 * 	4.as execoes na clase filho nao podem ser mais genericas q as do metodo na classa pai ou do tipo checked
 * 
 * */
	
	public static void main(String[] args) {
	
		Pessoa pessoa = new Pessoa();
		Funcionario funcionaria = new Funcionario();
		
		
		
		funcionaria.salvar();
		
		
		try {
			pessoa.salvar();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LoginInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
