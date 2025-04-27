      package services;

import java.util.List;

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
	 
	public static List<Producer> findAll() {
		return ProducerRepository.findAll();
	}
	public static List<Producer> findByName(String name) {
		return ProducerRepository.findByName(name);
	}
	
	public static void showProducerMetadata() {
		ProducerRepository.showProducerMetadata();
	}
	
	public static void showDriverMetadata() {
			ProducerRepository.showDriverMetadata();
	}
	
	public static void showTipeScrollWorcking(){
		ProducerRepository.showTipeScrollWorcking(null);		
	}
	public static void findByNameAndUpdateUpperLowCase(String name,boolean up) {
		System.out.println(ProducerRepository.findByNameAndUpdateUpperLowCase(name,up));
		
		
	}
	
	
}
