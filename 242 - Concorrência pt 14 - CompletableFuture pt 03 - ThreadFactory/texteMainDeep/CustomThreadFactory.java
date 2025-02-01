/*
 A interface ThreadFactory tem um �nico m�todo que voc� precisa implementar:

	public interface ThreadFactory {
	    Thread newThread(Runnable r);
	    }
  */
import java.util.concurrent.ThreadFactory;
/*Neste exemplo, a CustomThreadFactory cria 
 *threads com nomes personalizados (CustomThread-1, CustomThread-2, etc.), 
 *define a prioridade como NORM_PRIORITY e garante que as threads n�o sejam daemon.
 **/
public class CustomThreadFactory implements ThreadFactory {
    private int threadCount = 0;

    @Override
    public Thread newThread(Runnable r) {
        threadCount++;
        Thread thread = new Thread(r, "CustomThread-" + threadCount);
        thread.setPriority(Thread.NORM_PRIORITY);
        thread.setDaemon(false); // Define a thread como n�o-daemon
        return thread;
    }
}