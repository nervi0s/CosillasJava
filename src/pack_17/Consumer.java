package pack_17;

public class Consumer implements Runnable {

	private Deposit deposit;
	private String name;

	public Consumer(String name, Deposit deposit) {
		this.deposit = deposit;
		this.name = name;
	}

	@Override
	public void run() {
		// Damos un nombre al hilo cuando este m�todo sea llamado por el executor
		Thread.currentThread().setName(name);

		while (true) {

			try {
				Thread.sleep(5000); // Tiempo demora para consumir
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
						+ ", estado deposito: " + deposit.deposit);

				deposit.notifyAll();

			}
		}
	}

	public Integer consumeFirstItem() {
		int consumedItem = deposit.getItem(0); // Consumimos siempre el elemento de la primera posici�n de la lista
		return consumedItem;
	}

}
