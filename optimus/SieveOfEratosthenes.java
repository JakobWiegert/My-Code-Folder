package programming.set7.optimus;

import acm.program.ConsoleProgram;

/**
 * in mathematics, the sieve of Eratosthenes is a simple, ancient algorithm for.
 * finding all prime numbers up to any given limit.
 * 
 * It does so by iteratively marking as composite (i.e., not prime) the
 * multiples of each prime, starting with the first prime number, 2. The
 * multiples of a given prime are generated as a sequence of numbers starting
 * from that prime, with constant difference between them that is equal to that
 * prime.[1] This is the sieve's key distinction from using trial division to
 * sequentially test each candidate number for divisibility by each prime.[2]
 * 
 * 
 * One of a number of prime number sieves, it is one of the most efficient ways
 * to find all of the smaller primes. It may be used to find primes in
 * arithmetic progressions.[4]
 * 
 * -Wikipedia
 * 
 * @author Jakob Wiegert
 *
 */
public class SieveOfEratosthenes extends ConsoleProgram {

	/**
	 * thats the program.
	 */
	public void run() {
		int in = readInt("enter a number");
		while (in < 2) {
			in = readInt("wrong, try again, idiot :");
		}
		int n = in - 1;
		int[] numbers = new int[n];
		boolean[] killed = new boolean[n];
		numbers[0] = 2;
		for (int i = 0; i < n; i++) {

			if (i != 0) {
				numbers[i] = numbers[i - 1] + 1;
			}
		}

		for (int j = 0; j < n; j++) {
			if (killed[j] == false) {
				println(numbers[j]);
				for (int k = 0; k < n; k++) {
					if (numbers[k] % numbers[j] == 0) {
						killed[k] = true;
					}
				}
			}
		}

	}
}
