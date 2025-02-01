import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import services.StoreServices;

/*Future vs. CompletableFuture em Java: Uma Compara��o Detalhada
Em Java, Future e CompletableFuture s�o interfaces que representam opera��es ass�ncronas, ou seja, tarefas que s�o iniciadas e podem ser conclu�das em algum momento no futuro. Embora ambas sirvam para lidar com a programa��o ass�ncrona, elas oferecem funcionalidades e n�veis de abstra��o diferentes.

Future: A Base da Programa��o Ass�ncrona em Java
	Representa uma promessa: 
		Um objeto Future representa uma promessa de que um resultado estar� dispon�vel em algum momento no futuro.
	Verifica��o de conclus�o: 
		Voc� pode verificar se a tarefa foi conclu�da, obter o resultado ou verificar se ocorreu algum erro usando m�todos como isDone(), get() e isCancelled().
	Limita��o: 
		A interface Future oferece funcionalidades b�sicas para lidar com resultados futuros, mas n�o fornece mecanismos avan�ados para combinar, encadear ou reagir a m�ltiplos futuros.

CompletableFuture: Uma Evolu��o Poderosa
	Extens�o de Future: 
	 	CompletableFuture � uma extens�o de Future que adiciona uma API rica e fluente para trabalhar com opera��es ass�ncronas.
	Composi��o: 
	 	Permite criar pipelines de tarefas ass�ncronas complexos, combinando m�ltiplos futuros usando m�todos como thenApply(), thenCompose(), thenCombine() e outros.
	 	Tratamento de exce��es: Oferece mecanismos para lidar com exce��es de forma mais elegante, como handle(), exceptionally() e recover().
	Callbacks: 
	 	Permite registrar callbacks que s�o executados quando a tarefa � conclu�da, seja com sucesso ou com falha.
	Completa��o manual: 
	 	Voc� pode completar um CompletableFuture manualmente, o que � �til em cen�rios onde voc� deseja controlar explicitamente o resultado da tarefa.
	 	Em resumo:

Future � uma interface mais simples e b�sica para lidar com opera��es ass�ncronas.
CompletableFuture oferece uma API mais rica e flex�vel, permitindo criar fluxos de trabalho 
ass�ncronos mais complexos e expressivos.Quando usar cada um?

Future: 
	Ideal para tarefas simples onde voc� precisa apenas verificar se uma tarefa foi conclu�da e obter o resultado.
CompletableFuture: 
	Ideal para cen�rios mais complexos, como:
	Combinar m�ltiplas tarefas ass�ncronas.
	Criar pipelines de processamento ass�ncronos.
	Lidar com erros de forma elegante.
	Reagir a eventos ass�ncronos.
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
