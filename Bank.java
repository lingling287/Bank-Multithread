package bank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

public class Bank extends Thread {

	private Account[] accounts; // array of accounts
	private BlockingQueue<Transaction> transactions; // blocking queue
	private File file; // input file
	private Random random; // random object for thread sleeping
	private CountDownLatch latch; // count down latch
	private int threadCount; // number of threads wanted

	public Bank(File file, int threadCount) {
		accounts = new Account[20];
		transactions = new ArrayBlockingQueue<>(20);
		latch = new CountDownLatch(threadCount);
		random = new Random();
		this.file = file;
		this.threadCount = threadCount;

		for (int i = 0; i < 20; i++) {
			accounts[i] = new Account(i); // initializes each account
		}
	}

	private void readFile() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file)); // file
																			// reader

			String s = br.readLine(); // read each lines

			while (s != null) { // parses the string to create a transaction

				int first = 0;
				int second = 0;
				boolean b = false;

				for (int i = 0; i < s.length(); i++) {
					if (s.charAt(i) == ' ') {
						if (!b) {
							first = i;
							b = true;
						}

						else {
							second = i;
							break;
						}
					}
				}

				// creates new transaction
				Transaction t = new Transaction(Integer.parseInt(s.substring(0, first)),
						Integer.parseInt(s.substring(first + 1, second)), Integer.parseInt(s.substring(second + 1)));

				transactions.put(t); // adds to queue
				System.out.println(Thread.currentThread().getName() + " Producing Transaction  - " + t);
				Thread.sleep(random.nextInt(1));

				s = br.readLine(); // reads next line
			}

			br.close(); // closes reader

			// puts null transactions for each thread at end of file read
			for (int i = 0; i < threadCount; i++) {
				transactions.put(Transaction.exitThread);
			}

			System.out.println("Exit File Read");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void run() {

		// starts worker threads
		for (int i = 0; i < threadCount; i++) {
			new Worker(this).start();
		}

		// starts reading file
		readFile();

		// waits for all working threads to finish
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println();

		// prints out the final account balances and transaction count
		for (Account a : accounts) {
			System.out.println(a);
		}
	}

	// getters
	public Account[] getAccounts() {
		return accounts;
	}

	public BlockingQueue<Transaction> getTransactions() {
		return transactions;
	}

	public CountDownLatch getLatch() {
		return latch;
	}

	public Random getRandom() {
		return random;
	}

	public static void main(String[] args) {
		
		if (args.length == 0) {
			System.out.println("Arguments Empty");

		}

		else {
			Bank b = new Bank(new File(args[0]), Integer.parseInt(args[1]));
			b.start();
			System.out.println("End of main method");
		}

	}
}
