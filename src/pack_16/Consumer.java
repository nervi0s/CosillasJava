package pack_16;

public class Consumer extends Thread {

	private Deposit deposit;
	private String name;

	public Consumer(String name, Deposit deposit) {
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
			consumeFirstItem();
		}
	}

	public Integer consumeFirstItem() {
		int consumedItem = deposit.getItem(0);

		return consumedItem;
	}
}
