package pack_18;

import java.util.concurrent.Callable;

// En esta ocasión usaremos la interfaz Callable para obtener un resultado a través de un Future
// Obtendremos 1990 cuando el consumidor haya consumido 100 elementos

public class Consumer implements Callable<Integer> {

	private Deposit deposit;
	private String name;
	private int maxConsumptions = 100;

	public Consumer(String name, Deposit deposit) {
		this.deposit = deposit;
		this.name = name;
	}

	// Implementamos el método de esta interfaz funcional
	@Override
	public Integer call() throws Exception {
		// Damos un nombre al hilo cuando este método sea llamado por el executor
		Thread.currentThread().setName(name);
		int consumption = 0;

		while (consumption < maxConsumptions) {
			consumption++; // Aumentamos la variable de condición

			try {
				Thread.sleep(1000); // Tiempo demora para consumir
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// Sincronizamos usando el objeto compartido
			synchronized (deposit) {

				while (deposit.deposit.isEmpty()) {
					System.out.println("El depósito está vacío, el hilo: " + Thread.currentThread().getName()
							+ " está esperando, tamaño actual depósito: " + deposit.deposit);
					try {
						deposit.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				int consumido = consumeFirstItem();

				System.out.println("El hilo: " + Thread.currentThread().getName() + " ha consumido: " + consumido
						+ ", estado deposito: " + deposit.deposit + " ---> " + consumption);

				deposit.notifyAll();

			}
		}
		return 1990;
	}

	public Integer consumeFirstItem() {
		int consumedItem = deposit.getItem(0); // Consumimos siempre el elemento de la primera posición de la lista
		return consumedItem;
	}

}
