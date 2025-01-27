import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import services.StoreServices;

/*
 * */
public class Main {

	public static void main(String[] args) {
		StoreServices storeServices = new StoreServices();
		searchPricesAsyncFuture(storeServices);
	}
	
	private static void searchPricesAsyncFuture(StoreServices storeServices) {
		long start =System.currentTimeMillis();
		
		List<String> stores= List.of("carrefur","americanas","casas baia", "magalu");
		
		List<CompletableFuture<Double>> completableFutures = stores.stream()
				.map(storeServices::getPriceAsyncCompletableFuture)
				.collect(Collectors.toList());
		
		List<Double> prices = completableFutures.stream()
					.map(CompletableFuture::join)
					.collect(Collectors.toList());
		
		System.out.println(prices);
	
		
	/*	CompletableFuture<Double> priceAsincFuture1 = storeServices.getPriceAsyncCompletableFuture("carrefur");
		CompletableFuture<Double> priceAsincFuture2 = storeServices.getPriceAsyncCompletableFuture("americanas");
		CompletableFuture<Double> priceAsincFuture3 = storeServices.getPriceAsyncCompletableFuture("casas baia");
		CompletableFuture<Double> priceAsincFuture4 = storeServices.getPriceAsyncCompletableFuture("magalu");
		
		System.out.println(priceAsincFuture1.join()); 
		System.out.println(priceAsincFuture2.join()); 
		System.out.println(priceAsincFuture3.join()); 
		System.out.println(priceAsincFuture4.join()); 
		*/
		long end =System.currentTimeMillis();
		System.out.printf("time passed to search %d",(end-start)/180);
		
	}
}
