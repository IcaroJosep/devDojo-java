import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import services.StoreServices;

/*Future vs. CompletableFuture em Java: Uma Comparação Detalhada
Em Java, Future e CompletableFuture são interfaces que representam operações assíncronas, ou seja, tarefas que são iniciadas e podem ser concluídas em algum momento no futuro. Embora ambas sirvam para lidar com a programação assíncrona, elas oferecem funcionalidades e níveis de abstração diferentes.

Future: A Base da Programação Assíncrona em Java
	Representa uma promessa: 
		Um objeto Future representa uma promessa de que um resultado estará disponível em algum momento no futuro.
	Verificação de conclusão: 
		Você pode verificar se a tarefa foi concluída, obter o resultado ou verificar se ocorreu algum erro usando métodos como isDone(), get() e isCancelled().
	Limitação: 
		A interface Future oferece funcionalidades básicas para lidar com resultados futuros, mas não fornece mecanismos avançados para combinar, encadear ou reagir a múltiplos futuros.

CompletableFuture: Uma Evolução Poderosa
	Extensão de Future: 
	 	CompletableFuture é uma extensão de Future que adiciona uma API rica e fluente para trabalhar com operações assíncronas.
	Composição: 
	 	Permite criar pipelines de tarefas assíncronas complexos, combinando múltiplos futuros usando métodos como thenApply(), thenCompose(), thenCombine() e outros.
	 	Tratamento de exceções: Oferece mecanismos para lidar com exceções de forma mais elegante, como handle(), exceptionally() e recover().
	Callbacks: 
	 	Permite registrar callbacks que são executados quando a tarefa é concluída, seja com sucesso ou com falha.
	Completação manual: 
	 	Você pode completar um CompletableFuture manualmente, o que é útil em cenários onde você deseja controlar explicitamente o resultado da tarefa.
	 	Em resumo:

Future é uma interface mais simples e básica para lidar com operações assíncronas.
CompletableFuture oferece uma API mais rica e flexível, permitindo criar fluxos de trabalho 
assíncronos mais complexos e expressivos.Quando usar cada um?

Future: 
	Ideal para tarefas simples onde você precisa apenas verificar se uma tarefa foi concluída e obter o resultado.
CompletableFuture: 
	Ideal para cenários mais complexos, como:
	Combinar múltiplas tarefas assíncronas.
	Criar pipelines de processamento assíncronos.
	Lidar com erros de forma elegante.
	Reagir a eventos assíncronos.
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
