package bank;


public class Transaction {

	private int send;
	private int recieve;
	private int amount;

	public final static Transaction exitThread = new Transaction(-1, 0, 0);

	public Transaction(int send, int recieve, int amount) {
		this.send = send;
		this.recieve = recieve;
		this.amount = amount;
	}

	public void process(Bank b) {
		b.getAccounts()[send].debit(amount);
		b.getAccounts()[recieve].credit(amount);
	}

	public String toString() {
		return "Trasnfer $" + amount + " from " + send + " to " + recieve;
	}

	public boolean equals(Object o) {
		Transaction that = (Transaction) o;

		if (this.send != that.send) {
			return false;
		}

		if (this.recieve != that.recieve) {
			return false;
		}

		if (this.amount != that.amount) {
			return false;
		}

		return true;
	}

}
