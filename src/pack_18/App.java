package pack_18;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {

	public static void main(String[] args) {
		System.out.println("Inicio del programa");

		Deposit deposit = new Deposit();

		Producer producer = new Producer("Productor", deposit);
		Consumer consumer = new Consumer("Consumidor", deposit);

		// Usamos ExecutorService
		ExecutorService executorService = Executors.newCachedThreadPool();
		// Guardamos el future
		Future<Integer> futureResult = executorService.submit(consumer);
		executorService.submit(producer);

		try {
			// get() Hace esperar al hilo que lo llama hasta obtener el resultado futuro
			System.out.println(futureResult.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		System.out.println("Fin del main");
	}

}
