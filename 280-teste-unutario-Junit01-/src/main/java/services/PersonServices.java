package services;

import java.util.Objects;

import dominio.Person;

public class PersonServices {
	public boolean isAdult(Person person) {
		Objects.requireNonNull(person,"pessoa nao pode ser nulo");
		return person.getAge()>=18;
	}
	
}
