package pack_12;

import java.util.HashMap;

public class Bank {

	private static Bank instance = new Bank();
	private HashMap<Integer, BankAccount> accountsNumbersAndBankAccounts;

	private Bank() {
		accountsNumbersAndBankAccounts = new HashMap<>();
		accountsNumbersAndBankAccounts.put(123456, new BankAccount(123456));
	}

	public static Bank getInstance() {
		return instance;
	}

	public HashMap<Integer, BankAccount> getAccountsNumbersAndBankAccounts() {
		return accountsNumbersAndBankAccounts;
	}
}
