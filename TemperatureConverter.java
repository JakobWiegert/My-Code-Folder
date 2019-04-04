import acm.program.*;

public class TemperatureConverter extends ConsoleProgram {
	public void run() {

		double c = 0;
		double f = 0;

		println("What do you want me to do? (1) Convert Celsius to Fahrenheit (2) Convert Fahrenheit to Celsius");
		int m = readInt("Mode:");

		if (m == 1) { // Mode 1
			while (c != -1337) {
				c = readDouble("Temperature:");
				if (c == -1337) {
					break;
				}
				f = c / (5.0 / 9) + 32;
				println(f);
			}
		} else if (m == 2) { // Mode 2
			while (f != -1337) {
				f = readDouble("Temperature:");
				if (f == -1337) {
					break;
				}
				c = (5.0 / 9) * (f - 32);
				println(c);
			}

		} else { // Eingabe fehler
			println("Ich hab gesagt 1 oder 2 ! Was is daran so schwer ??!");
		}

		println("Goodbye!");
	}
}