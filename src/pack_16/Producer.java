package pack_16;

public class Producer extends Thread {

	private Deposit deposit;

	public Producer(String name, Deposit deposit) {
		super(name);
		this.deposit = deposit;
	}

	@Override
	public void run() {

		for (;;) {
			try {
				sleep(1000); // Tiempo demora para producir
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			produceItem();
		}

	}

	public void produceItem() {
		int randomItem = (int) (Math.random() * 21); // Se produce un número random entre 0 y 20
		deposit.putItem(randomItem);
	}

}
