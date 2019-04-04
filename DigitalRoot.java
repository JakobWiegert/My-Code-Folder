import acm.program.*;

public class DigitalRoot extends ConsoleProgram {
	public void run() {

		int n = readInt("Please enter a Integer:");

		if (n < 0) {
			for (int i = 1; i <= 100; i++) {
				println("Noob");
				println("Error");
			}
		} else {
			int dsum = 0;

			while (n > 9) {

				dsum = 0;
				while (n > 0) {

					dsum += n % 10;
					n /= 10;

				}

				n = dsum;
			}
			println(n);
		}
	}
}