package test;
/*aqui sera reito o feito de forma mas generica*/

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main2 {

	public static void main(String[] args) {
	
		List<Integer> nums=List.of(1,2,3,4,5,6,7,8,9);
											
											/*nao emporta o nome , pos é uma referencia
											 * a cada elemento da lista (um for-each com if)*/
		List<Integer> numsPar= filter(nums, cus->cus%2!=0);
		
		List<Integer> numsPar2= filter(nums, new Predicate<Integer>() {
	            @Override
	            public boolean test(Integer cus) {
	                return cus % 2 == 0;
	            }
	      });
		
		System.out.println(numsPar);
		System.out.println(numsPar2);

	}
	
	/*metodo capas de filtrar por qual quer atributo*/
	private static <t, T> List<T> filter(List<T> list ,Predicate<T> predicate) {
		List<T> filterList = new ArrayList<>();
		for(T e: list) {
			if(predicate.test(e)) {
				filterList.add(e);
			}
		}
		
		return filterList;
	}

}
