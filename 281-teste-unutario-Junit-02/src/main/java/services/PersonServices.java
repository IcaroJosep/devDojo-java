package services;

import java.util.Objects;

import dominio.Person;

public class PersonServices {
	public boolean isAdult(Person person) {
		
		if(!Objects.nonNull(person)) {
			throw new IllegalArgumentException();
		}
		
		return person.getAge()>=18;
	}
	
}
