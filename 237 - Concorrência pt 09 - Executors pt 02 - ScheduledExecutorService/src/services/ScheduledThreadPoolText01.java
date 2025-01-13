package services;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class  ScheduledThreadPoolText01 {
	public static final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

	public static void beeper() {
		Runnable r=()->{
			System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss"))+" beep ");
		};
		//executor.schedule(r,5,TimeUnit.SECONDS);
		//executor.scheduleWithFixedDelay(r, 1, 3, TimeUnit.SECONDS);
		ScheduledFuture<?> schundeledFuture =executor.scheduleWithFixedDelay(r, 1, 3, TimeUnit.SECONDS);
		executor.schedule(()->{
			System.out.println("fim");
			schundeledFuture.cancel(false);
			executor.shutdown();
		},15,TimeUnit.SECONDS);
	}
}



	

