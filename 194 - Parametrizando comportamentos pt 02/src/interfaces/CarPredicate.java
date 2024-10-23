package interfaces;
/*obs:
 *ja existe uma interface chamada predicate em java
 *e ela faz a msm coisa q esta
 *esta no entanto é apenas uma demostracao*/


import dominio.Car;

public interface CarPredicate {

	 boolean test(Car car);	
		
}

