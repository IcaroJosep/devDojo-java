import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<String> words = List.of("goku","gomu","no","mi");
		
		char[] b =  words.get(0).toCharArray();
		
		System.out.println(b[0]);
			
		List<String[]> colec = words.stream().map(w->w.split("")).collect(Collectors.toList());
		
		colec.forEach(c -> {
		    // Iterar sobre cada array de caracteres
		    for (String character : c) {
		        System.out.println(character);
		    }
		});
	}
	
}
