package pack_12;

public class Principal {

	public static void main(String[] args) {

		Bank bank = Bank.getInstance();

		// Ambos clientes comparten el mismo objeto, en este caso es un banco, pero más
		// en el fondo el objeto compartido es un objeto del tipo BankAccount que hemos
		// sicronizado

		Customer user1 = new Customer("Peter", bank);
		Customer user2 = new Customer("Homer", bank);

		user1.start();
		user2.start();

	}
}
