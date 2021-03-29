package pack_17;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

	public static void main(String[] args) {
		System.out.println("Inicio del programa");

		Deposit deposit = new Deposit();

		Producer producer = new Producer("Productor", deposit);
		Consumer consumer = new Consumer("Consumidor", deposit);

		// Usamos ExecutorService
		ExecutorService executorService = Executors.newCachedThreadPool();

		executorService.submit(consumer);
		executorService.submit(producer);

		System.out.println("Fin del main");
	}

}
