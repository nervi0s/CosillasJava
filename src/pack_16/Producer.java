package pack_16;

public class Producer extends Thread {

	private Deposit deposit;
	private String name;

	public Producer(String name, Deposit deposit) {
		super(name);
		this.name = name;
		this.deposit = deposit;
	}

	@Override
	public void run() {

		for (;;) {
			try {
				sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			produceItem();
		}

	}

	public void produceItem() {
		int randomItem = (int) (Math.random() * 21);
		deposit.putItem(randomItem);

	}
}
