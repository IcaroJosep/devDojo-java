package services;

import java.util.List;

import dominio.Producer;
import repository.ProducerRepository;

public class ProducerServices {
	
	public static List<Producer> findByNameCallable (String name) {
		return ProducerRepository.findByNameCallable(name);
	}
	
	
}
