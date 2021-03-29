package pack_18;

import java.util.concurrent.Callable;

// En esta ocasi�n usaremos la interfaz Callable para obtener un resultado a trav�s de un Future
// Obtendremos 1990 cuando el consumidor haya consumido 100 elementos

public class Consumer implements Callable<Integer> {

	private Deposit deposit;
	private String name;
	private int maxConsumptions = 100;

	public Consumer(String name, Deposit deposit) {
		this.deposit = deposit;
		this.name = name;
	}

	// Implementamos el m�todo de esta interfaz funcional
	@Override
	public Integer call() throws Exception {
		// Damos un nombre al hilo cuando este m�todo sea llamado por el executor
		Thread.currentThread().setName(name);
		int consumption = 0;

		while (consumption < maxConsumptions) {
			consumption++; // Aumentamos la variable de condici�n

			try {
				Thread.sleep(1000); // Tiempo demora para consumir
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// Sincronizamos usando el objeto compartido
			synchronized (deposit) {

				while (deposit.deposit.isEmpty()) {
					System.out.println("El dep�sito est� vac�o, el hilo: " + Thread.currentThread().getName()
							+ " est� esperando, tama�o actual dep�sito: " + deposit.deposit);
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
		int consumedItem = deposit.getItem(0); // Consumimos siempre el elemento de la primera posici�n de la lista
		return consumedItem;
	}

}
