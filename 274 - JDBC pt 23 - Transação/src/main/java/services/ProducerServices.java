      package services;

import java.util.List;
import repository.ProducerRepository;

import dominio.Producer;
import repository.ProducerRepository;

public class ProducerServices {
	
	
	public static void saveTA(List<Producer> producers) {
		ProducerRepository.saveTransaction(producers);

	}
	
}
