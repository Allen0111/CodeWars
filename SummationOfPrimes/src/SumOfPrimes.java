import java.math.*;
import java.util.ArrayList;

public class SumOfPrimes {

	/**
	 * @param args
	 */
	public static long twoMillion = 2000000;
	
	public static void main(String[] args) {
		ArrayList<Long> primes = new ArrayList<Long>();
		
		primes.add((long)2);
		primes.add((long)3);
		primes.add((long)5);
		primes.add((long)7);
	
		for (long index = 9; index < twoMillion; index ++) {
			boolean prime = true;

			for (int primeSearch = 0; (prime && (primes.get(primeSearch) <= Math.sqrt(index))); primeSearch++) {
				if (index % primes.get(primeSearch) == 0) {
					prime = false;
				}
			}

			if (prime) primes.add(index);
		}

		primes.trimToSize();

		long sumOfPrimes = 0;

		for (int index = 0; index < primes.size(); index++) {
			sumOfPrimes += primes.get(index);
		}
		
		System.out.println(sumOfPrimes);
	}

}
