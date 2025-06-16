package services;

import java.util.ArrayList;
import java.util.List;

import dominio.Producer;
import repository.ProducerRepository;
import teste.list;

public class ProducerServices {
	
	public static List<Producer> findByNameJdbcRowSet (String name) {
		return ProducerRepository.findByName(name);
	}
	
	public static void update(Producer producer,String newName) {
		ProducerRepository.Update(producer, newName);
	}
	
	public static Producer PreUp (String name) {
		List<Producer> producers = findByNameJdbcRowSet (name);
		Producer p = producers.getFirst();
		return p;
	}
	
	
	
}
