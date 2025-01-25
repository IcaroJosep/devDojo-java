import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import services.*;
public class Main {

	public static void main(String[] args) {
		StoreServices storeServices=new StoreServices();
		//searchPricesSync(storeServices);
		searchPricesAsyncFuture(storeServices);

	}
	
	private static void searchPricesSync(StoreServices storeServices) {
		long start =System.currentTimeMillis();
		System.out.println(storeServices.getPriceSync("carrefur"));
		System.out.println(storeServices.getPriceSync("americanas"));
		System.out.println(storeServices.getPriceSync("casas baia"));
		System.out.println(storeServices.getPriceSync("magalu"));
		long end =System.currentTimeMillis();
		System.out.printf("time passed to search %d",(end-start)/180);
		
	}
	private static void searchPricesAsyncFuture(StoreServices storeServices) {
		long start =System.currentTimeMillis();
		Future<Double> priceAsincFuture1 = storeServices.getPriceAsyncFuture("carrefur");
		Future<Double> priceAsincFuture2 = storeServices.getPriceAsyncFuture("americanas");
		Future<Double> priceAsincFuture3 = storeServices.getPriceAsyncFuture("casas baia");
		Future<Double> priceAsincFuture4 = storeServices.getPriceAsyncFuture("magalu");
		
		try {
			System.out.println(priceAsincFuture1.get()); 
			System.out.println(priceAsincFuture2.get()); 
			System.out.println(priceAsincFuture3.get()); 
			System.out.println(priceAsincFuture4.get()); 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		long end =System.currentTimeMillis();
		System.out.printf("time passed to search %d",(end-start)/180);
		storeServices.shotdow();
	}

}
