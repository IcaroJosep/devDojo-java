package test;
import java.util.ArrayList;
import java.util.List;

import dominio.Car;
import interfaces.CarPredicate;

/*demostrativo de como é sem! á parametrizaçao
 * procima aula sera feito a parametrizacao*/

public class Main {

	static List<Car> cars = List.of(new Car("green",2011),new Car("black",1998),new Car("red",2019));
	
	public static void main(String[] args) {
			
		List<Car> carscolor =filter(cars, new CarPredicate() {
			@Override
			public boolean test(Car car) {
				return car.getColor().equals("green");
			}
		
		});
		
		System.out.println(carscolor.toString());//toString foi sobrescrito na classe
		/*outros tipos de impreçao para list*/
		System.out.println(carscolor.get(0).nome);
		
		for (Car car : carscolor) {
		    System.out.println(car.getNome());
		}
	
	
	}

	//filtra
	private static List<Car> filter(List<Car> cars,CarPredicate carPreticate){
		List<Car> filtercars = new ArrayList<>();
		for(Car car:cars) {
			if(carPreticate.test(car)) {
				filtercars.add(car);
			}
		}
		return filtercars;
	}
	
	

	
	

}
