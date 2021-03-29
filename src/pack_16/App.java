package pack_16;

public class App {

	public static void main(String[] args) {

		Deposit deposit = new Deposit();

		Producer producer = new Producer("Productor", deposit);
		Consumer consumer = new Consumer("Consumidor", deposit);

		producer.start();
		consumer.start();
	}

}
