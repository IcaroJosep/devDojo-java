import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Main {

	public static void main(String[] args) {
		List<String> strings=List.of("icaro","josep");
/*com lambda*/
		List<Integer> inteiros = map(strings, (String s)->s.length());
		
		System.out.println(inteiros.get(0));
		System.out.println(inteiros.get(1));
		
/*com funçao anonima atraves do map*/
		List<Integer> inteiros2 = map(strings, new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        });
		System.out.println(inteiros2.get(0));
		System.out.println(inteiros2.get(1));
		
		
/*com funçao anonima sem utilizar o map*/
		List<Integer> inteiros3 = new ArrayList<>();

        // Iterando sobre a lista e adicionando os tamanhos à nova lista
        for (String s : strings) {
            inteiros3.add(new Function<String, Integer>() {
                @Override
                public Integer apply(String s) {
                    return s.length();
                }
            }.apply(s));
        }
        System.out.println(inteiros3.get(0));
		System.out.println(inteiros3.get(1));
		
		
	}
	private static <T,R> List<R> map(List<T> list,Function<T, R> function){
		List<R> result = new ArrayList<>();
		for(T e:list) {
			R r= function.apply(e);
			result.add(r);
		}
		return result;
	}

}
