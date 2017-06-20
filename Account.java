package bank;


public class Account {

	private int accountNumber;
	private int balance;
	private int transactionCount;

	public Account(int accountNumber) {
		this.accountNumber = accountNumber;
		balance = 1000;
		transactionCount = 0;
	}

	public synchronized void debit(int amount) {
		balance = balance - amount;
		transactionCount++;
	}

	public synchronized void credit(int amount) {
		balance = balance + amount;
		transactionCount++;
	}

	public String toString() {
		return "Account: " + accountNumber + ", Balance: " + balance + " Transaction Count: " + transactionCount;
	}
}
