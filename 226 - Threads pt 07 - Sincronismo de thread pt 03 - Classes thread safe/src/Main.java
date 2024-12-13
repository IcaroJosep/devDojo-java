import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*classes threads safe :
 * significa q os metodos para cesso desta classe sao metodos 
 *sincronizados
 *
 *
 *leve em comta q "Collections.synchronizedList(new ArrayList<>());" 
 *faz com q a chamda direta de metodos da lista sejao sincronizados
 *no caso "names.add" ,"names.size()" e "names.remove(0)".
 *porem nada inpede q duas treads entrem em public void removeFirst()
 *e as duas executem o teste comtido no if "names.size()>0" em sequencia 
 *antes de qualquer uma tenha executado o "names.remove(0)" .
 *gerando assim uma situaçao de comcorencia e fazendo nesse sario a 
 *sincronizacao tbm do metodo removeFirst().
 * */

class ThreadsSafeNames{               
									//sincronizacao dos metodos da list
	private final List<String> names = /*Collections.synchronizedList(*/new ArrayList<>()/*)*/;
	/*comos os metods a baixo estao sincronizados
	nao é necessario a sincronizaçao dos metodos da list*/
	
	public synchronized void add(String name) {
		names.add(name);
	}
	
	public synchronized void removeFirst() {
		if(names.size()>0) {
			System.out.println(Thread.currentThread().getName());
			System.out.println(names.remove(0));
		}
	}
}

public class Main {

	public static void main(String[] args) {
		ThreadsSafeNames threadsSafeNames = new ThreadsSafeNames();
		
		threadsSafeNames.add("junkrat");
		
		Runnable r =()->{threadsSafeNames.removeFirst();};

		new Thread(r).start();
		new Thread(r).start();
		
	}

}
