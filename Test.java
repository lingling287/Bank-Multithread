package bank;
import java.io.File;

public class Test {

	public static void main(String[] args) {
		Bank b = new Bank(new File("src/bank/100k.txt"), 3);
		b.start();
		System.out.println("End of main method");
	}
}
