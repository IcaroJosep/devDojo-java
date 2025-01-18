package services;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class  ScheduledThreadPoolText01 {
	public static final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
	
		/*metodo*/
	public static void beeper() {
		
		/*runnable que bipa o horario local*/
		Runnable r=()->{
			System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss"))+" beep ");
		};
		
		//executor.schedule(r,5,TimeUnit.SECONDS);
		//executor.scheduleWithFixedDelay(r, 1, 3, TimeUnit.SECONDS);
		
			/*executor q chama o runnable inblementado a uma variavel q é chamada para marcar o fim da execuçao*/
		ScheduledFuture<?> schundeledFuture =executor.scheduleWithFixedDelay(r, 1, 3, TimeUnit.SECONDS);
			/*executor q cansela a execuçao de ScheduledFuture(primeiro executor e depois e auto-desliga)*/
		executor.schedule(()->{
			System.out.println("fim");
			schundeledFuture.cancel(false);//cancela
			executor.shutdown();//desliga
		},15,TimeUnit.SECONDS);
	}
}



	

