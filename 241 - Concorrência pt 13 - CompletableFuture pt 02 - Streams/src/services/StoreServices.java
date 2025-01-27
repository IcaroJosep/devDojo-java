package services;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class StoreServices {
	
	
	public CompletableFuture<Double> getPriceAsyncCompletableFuture(String storName){
		System.out.println(storName);
		return CompletableFuture.supplyAsync(this::priceGenerator);
	}
	
	private double priceGenerator() {
		System.out.printf("thrad %s ",Thread.currentThread().getName());
		System.out.println("gerando preços");
		delay();
		return ThreadLocalRandom.current().nextInt(1,200)*7;
	}
	
	private void delay() {
		try {
			TimeUnit.MILLISECONDS.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
