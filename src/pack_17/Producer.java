package pack_17;

public class Producer implements Runnable {

	private Deposit deposit;
	private String name;

	public Producer(String name, Deposit deposit) {
		this.deposit = deposit;
		this.name = name;
	}

	@Override
	public void run() {
		// Damos un nombre al hilo cuando este m�todo sea llamado por el executor
		Thread.currentThread().setName(name);

		while (true) {

			try {
				Thread.sleep(1000); // Tiempo demora para producir
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// Sincronizamos usando el objeto compartido
			synchronized (deposit) {

				if (deposit.deposit.size() < 5) {
					produceItem();
					deposit.notifyAll();
				} else {
					System.out.println("El dep�sito est� lleno, el hilo: " + Thread.currentThread().getName()
							+ " est� esperando, tama�o actual dep�sito: " + deposit.deposit);
					try {
						deposit.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}

	}

	public void produceItem() {
		int randomItem = (int) (Math.random() * 21); // Se produce un n�mero random entre 0 y 20
		deposit.putItem(randomItem);
		System.out.println("El hilo: " + Thread.currentThread().getName() + " ha producido: " + randomItem
				+ ", estado deposito: " + deposit.deposit);
	}

}
