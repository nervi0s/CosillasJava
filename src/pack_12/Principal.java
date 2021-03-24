package pack_12;

public class Principal {

	public static void main(String[] args) {

		Bank bank = Bank.getInstance();

		Customer user1 = new Customer("Peter", bank);
		Customer user2 = new Customer("Homer", bank);

		user1.start();
		user2.start();

	}
}
