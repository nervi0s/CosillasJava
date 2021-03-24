package pack_12;

import java.util.HashMap;

public class Bank {

	private static Bank instance = new Bank();
	private HashMap<Integer, BankAccount> accountsNumbersAndBankAccounts;

	// Constructor privado ya que usaremos un patrón Singleton
	private Bank() {
		accountsNumbersAndBankAccounts = new HashMap<>();
		accountsNumbersAndBankAccounts.put(123456, new BankAccount(123456));
	}

	// Para obtener la instancia única
	public static Bank getInstance() {
		return instance;
	}

	// De un banco podemos obtener la cuenta bancaria asociada a un número de cuenta
	public BankAccount getBankAccount(int accountsNumber) {
		return accountsNumbersAndBankAccounts.get(accountsNumber);
	}

}
