import acm.program.*;

public class Fibonacci extends ConsoleProgram {
	public void run() {

		int n = readInt("Enter a Number:");
		int x = 1;
		int y = 1;
		int z = 1;

		if (n < 1) {
			println("Error");
			
		} else if (n == 1) {
			println(z);

		} else if (n == 2) {
			println(z);

		} else if (n > 2) {
			for (int i = 3; i <= n; i++) {

				y = x;
				x = z;
				z = x + y;
			}
			println(z);
		}
	}
}
