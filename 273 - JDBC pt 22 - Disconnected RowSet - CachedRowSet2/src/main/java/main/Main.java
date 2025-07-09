// Main.java
package main;

import service.ProducerService;

public class Main {
    
    public static void main(String[] args) {
        ProducerService producerService = new ProducerService();
        
        // Listar producers antes da atualização
        System.out.println("ANTES DA ATUALIZAÇÃO:");
        producerService.listAllProducers();
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Atualizar o producer com ID 1 para o nome "Studio Ghibli Updated"
        producerService.producerServicesUpdate(2, "asd");
        
       
    }
}
