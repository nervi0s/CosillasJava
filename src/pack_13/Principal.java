package pack_13;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Principal {

	public static void main(String[] args) {
		// Usatemos este objeto como ayuda para saber si hemos obtenido el futuro o no
		boolean[] completed = { false };

		ExecutorService es = Executors.newFixedThreadPool(4);

		Future<Integer> futuro = es.submit(() -> {// Funcion lambda para crear un Callable
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + " hola " + i);
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return 65; // Retornamos algo de prueba para ver como funciona el retorno de un Future
		});

		completed[0] = futuro.isDone();

		if (!completed[0]) {
			es.submit(() -> {
				while (!completed[0]) {
					System.out.println(Thread.currentThread().getName() + " esperando");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}

		try {
			System.out.println(futuro.get()); // El método get() espera y pausa si es necesrio el hilo al que lo llama
												// hasta obtener el valor del futuro
			completed[0] = true; // Se cambia a true para que el hilo que mostraba es mensaje esperando deje de
									// hacerlo
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		System.out.println(futuro.isDone());

		es.shutdown();

		System.out.println(Thread.currentThread().getName() + " : fin del programa");

	}

}
