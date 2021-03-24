package pack_12;

public class Customer extends Thread {

	private String name;
	private Bank bank;
	private Integer accountNumber = 123456;

	public Customer(String name, Bank bank) {
		super(name);
		this.name = name;
		this.bank = bank;
	}

	@Override
	public void run() {
		depositInBankAccount(100);
		/// Demora de 1 sec para hacer el otro procedimiento
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		/// Fin de la demora
		withdrawFromBankAccount(200);
	}

	public String getCustomerName() {
		return name;
	}

	public void depositInBankAccount(int amount) {
		getBankAccount().deposit(amount);
	}

	public Integer withdrawFromBankAccount(int amount) {
		return getBankAccount().withdraw(amount);
	}

	public BankAccount getBankAccount() {
		return bank.getBankAccount(accountNumber);
	}

}
