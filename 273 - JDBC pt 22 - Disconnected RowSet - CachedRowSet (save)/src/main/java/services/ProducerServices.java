package services;

import java.util.ArrayList;
import java.util.List;

import dominio.Producer;
import repository.ProducerRepository;


public class ProducerServices {
	
	public static List<Producer> findByNameJdbcRowSet (String name) {
		return ProducerRepository.findByName(name);
	}
	
	public static void update(String name,String newName) {               
		ProducerRepository.Update(findByNameJdbcRowSet (name).getFirst(), newName);
	}
	
	
}
