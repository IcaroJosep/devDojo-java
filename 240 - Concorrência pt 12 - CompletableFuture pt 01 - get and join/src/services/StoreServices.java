package services;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class StoreServices {
	private static final ExecutorService x = Executors.newCachedThreadPool();
	
	public double getPriceSync(String storName) {
		System.out.println(storName);
		return priceGenerator();
	}
	
	public Future<Double> getPriceAsyncFuture(String storName){
		System.out.println(storName);
		return x.submit(this::priceGenerator);
	}
	public static void shotdow() {
		x.shutdown();
	}
	
	private double priceGenerator() {
		System.out.println("gerando preços");
		delay();
		return ThreadLocalRandom.current().nextInt(1,200)*7;
	}
	
	private void delay() {
		try {
			TimeUnit.MILLISECONDS.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
