import java.util.ArrayList;
import java.util.List;

import dominio.Car;

/*demostrativo de como é sem! á parametrizaçao
 * procima aula sera feito a parametrizacao*/

public class Main {

	static List<Car> cars = List.of(new Car("green",2011),new Car("black",1998),new Car("red",2019));
	
	public static void main(String[] args) {
		System.out.println("\nfiltra por cor verde");
		inp(filterGreenCar(cars));
		System.out.println("\nfiltra por cor especificada no metodo:");
		inp(filterColor(cars,"black"));
System.out.println("\n=====================================================");
		System.out.println("filtra por ano:");
		inp(filterAnoCar(cars,2015));
		
	}
	
/*metodo de impreçao*////////////////////////////////////////////////////////////////////////////////////////
	private static void inp (List<Car> cars ) {
		for(Car car:cars) {
			System.out.printf("nome : %s  cor: %s ano: %s",car.getNome(),car.getColor(),car.getYear() );
		}
	}
	
/*metodos de filtragem*//////////////////////////////////////////////////////////////////////////////////////////	
	//filtra green
	private static List<Car> filterGreenCar(List<Car> cars){
		List<Car> greenCars = new ArrayList<>();
		for(Car car:cars) {
			if(car.getColor().equals("green")) {
				greenCars.add(car);
			}
		}
		return greenCars;
	}
	//filtra color especificada
	private static List<Car> filterColor(List<Car> cars,String color){
		List<Car> greenCars = new ArrayList<>();
		for(Car car:cars) {
			if(car.getColor().equals(color)) {
				greenCars.add(car);
			}
		}
		return greenCars;
	}
	//filtara ano
	private static List<Car> filterAnoCar(List<Car> cars,int ano){
		List<Car> greenCars = new ArrayList<>();
		for(Car car:cars) {
			if(car.getYear()<=ano) {
				greenCars.add(car);
			}
		}
		return greenCars;
	}
	
	

	
	

}
