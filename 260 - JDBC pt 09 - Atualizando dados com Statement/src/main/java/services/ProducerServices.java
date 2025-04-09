package services;

import dominio.Producer;
import repository.ProducerRepository;

public class ProducerServices {
	
	public static void save(Producer producer) {
		ProducerRepository.save(producer);
	}
	
	public static void delet(int id) {
			if (id <=0) {
				throw new IllegalArgumentException("valor invalido para id.");
			}
		ProducerRepository.delet(id);
	}
	
	public static void update(int id, String name) {
		ProducerRepository.update(id,name);
	}
	
}
