import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dominio.Person;
import services.PersonServices;


public class persomserviceText {
	
	@Test
	@DisplayName("verifica se -18 nao sao adutos")
	void isAdult() {
		Person person = new Person(17);
		PersonServices personServices = new PersonServices();
		Assertions.assertEquals(false,personServices.isAdult(person));
	};
	@Test	
	@DisplayName("verifica se 18+  sao adutos")
	void isAdult2() {
		Person person = new Person(18);
		PersonServices personServices = new PersonServices();
		Assertions.assertEquals(true,personServices.isAdult(person));
	};
}
