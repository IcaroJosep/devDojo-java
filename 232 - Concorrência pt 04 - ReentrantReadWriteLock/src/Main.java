import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/*	ReentrantReadWriteLock :
 * Trabalha com lock de leitura e de escrita.
 * 
 * Suponha um thread fazendo escrita e cinco threas 
 * fazendo leitura ; Quando vc esta escrevendo nao 
 * quer q ninguem faxça leitura
 * 
 * Este lock faz isso quando vc esta escrevendo 
 * nao comsegue loc de leitura e vice versa
 * */


 class MapReadWrite{
	private final Map<String, String> map = new LinkedHashMap<>();
	private final ReentrantReadWriteLock rwl;
	
 	public MapReadWrite(ReentrantReadWriteLock rwl) {
		this.rwl=rwl;
	}
 	
	
	public void put(String key, String value) {
		rwl.writeLock().lock();
		try {
			if(rwl.isWriteLocked()) {
				System.out.printf("\n%s obteve o Write lock \n",Thread.currentThread().getName());
			}
			map.put(key, value);
			Thread.sleep(200);
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			rwl.writeLock().unlock();
		}		
	}				
	
	public Set<String> allKays(){
		rwl.readLock().lock();
		try {
			return map.keySet();
		} finally {
			rwl.readLock().unlock();
		}
	}
	
}


public class Main {

	public static void main(String[] args) {
		ReentrantReadWriteLock  rwl = new ReentrantReadWriteLock();
		MapReadWrite mapReadWrite = new MapReadWrite(rwl);
		
		Runnable write=()->{
			for(int i = 0; i<20; i++) {
				mapReadWrite.put(String.valueOf(i),String.valueOf(i));
			}
		};
		
		Runnable reader = ()->{
			if(rwl.isWriteLocked()) {
				System.out.println("write LOCKED!");
			}
			rwl.readLock().lock();
			System.out.println("FINALY I GOT THE DAMN LOCK");
			try {
				System.out.println(Thread.currentThread().getClass()+" "+mapReadWrite.allKays());
			} finally {
				rwl.readLock().unlock();
			}
		};
		
		Thread t1 = new Thread(write);
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread t2 = new Thread(reader);
		Thread t3 = new Thread(reader);
		
		t1.start();
		t2.start();
		t3.start();
		
		
	}
}
