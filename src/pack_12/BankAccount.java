package pack_12;

public class BankAccount {

	// Tenemos una cuenta bancaria determinada por una cantidad de dinero que tiene
	// y un n�mero de cuenta
	Integer balance;
	Integer accountNumber;

	// Podemos crear una cuenta con un n�mero y un balance incial
	public BankAccount(int accountNumber, int initialBalance) {
		this.accountNumber = accountNumber;
		this.balance = initialBalance;
	}

	// Tambi�n podemos crear una cuenta proporcionando solo el n�mero de esta, se
	// asignar� la balance incial 0
	public BankAccount(int accountNumber) {
		this(accountNumber, 0);
	}

	public Integer getBalance() {
		return balance;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	// En una cuenta se pueden hacer dep�sitos
	public void deposit(int amount) {
		balance += amount;
		System.out.println(Thread.currentThread().getName() + " est� ingresando en la cuenta: " + accountNumber
				+ ". La cantidad de " + amount + " �. El saldo actualizado de la cuenta es: " + balance + " �.");
	}

	// En una cuenta se pueden hacer retiradas de dinero
	public Integer withdraw(int amount) {
		System.out.println(Thread.currentThread().getName() + " est� intentado retirar de la cuenta: " + accountNumber
				+ ". La cantidad de: " + amount + " �.");
		// Si no tenemos saldo suficiente mostramos un error y retornamos 0 �.
		if (balance < amount) {
			System.out
					.println(Thread.currentThread().getName() + " NO HAY dinero suficiente para retirar de la cuenta. "
							+ "El saldo de la cuenta es: " + balance + " �.");
			return 0;
		}

		balance -= amount;
		System.out.println(Thread.currentThread().getName() + " ha retirado correctamente la cantidad de: " + amount
				+ " �. El saldo actualizado de la cuenta es: " + balance + " �.");

		return amount;
	}
}
