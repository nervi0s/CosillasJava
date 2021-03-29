package pack_19;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//Se pretende simular 100 peticiones HTTP haciendo uso de la concurrencia de Java

public class App {

	public static void main(String[] args) {

		long start = System.currentTimeMillis(); // Para medir el tiempo de ejecución

		// Creamos una lista de futuros ya que iremos creando 100 peticiones con sus
		// respectivos futuros asociados

		List<Future<String>> listaFuturos = new ArrayList<>();

		ExecutorService executorService = Executors.newCachedThreadPool();

		for (int i = 0; i < 100; i++) {
			listaFuturos.add(executorService.submit(new Request("https://jsonplaceholder.typicode.com/todos/1")));
		}

		// Incia la orden de apagado del ExecutorService
		executorService.shutdown();

		for (Future<String> future : listaFuturos) {
			try {
				// El método get detiene al hilo hasta que se obtenga el valor del futuro
				System.out.println(future.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}

		long end = System.currentTimeMillis() - start; // Para medir el tiempo de ejecución

		System.out.println(end); // Para medir el tiempo de ejecución, se obtienen milisegundos
	}

}
