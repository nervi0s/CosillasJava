package pack_16;

public class Consumer extends Thread {

	private Deposit deposit;

	public Consumer(String name, Deposit deposit) {
		super(name);
		this.deposit = deposit;
	}

	@Override
	public void run() {
		for (;;) {
			try {
				sleep(5000); // Tiempo demora para consumir
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			consumeFirstItem();
		}
	}

	public Integer consumeFirstItem() {
		int consumedItem = deposit.getItem(0); // Consumimos siempre el elemento de la primera posición de la lista
		return consumedItem;
	}

}
