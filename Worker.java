package bank;


public class Worker extends Thread {
	private Bank b; // bank reference to access queue and accounts array

	public Worker(Bank b) {
		this.b = b;
	}

	@Override
	public void run() {
		try {	
			Transaction t;
			
			while (true) {
				t = b.getTransactions().take(); // gets transaction from queue
				if (t.equals(Transaction.exitThread)) {
					break; // if null process break from loop
				}
				t.process(b); // process transaction									
				System.out.println(Thread.currentThread().getName() + " Processing Transaction - " + t);
				Thread.sleep(b.getRandom().nextInt(1));
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		b.getLatch().countDown(); // notifies main thread that worker is finish
	}
}