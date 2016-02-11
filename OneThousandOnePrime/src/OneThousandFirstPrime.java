import java.util.ArrayList;
import java.math.*;

public class OneThousandFirstPrime {

	public static ArrayList<Integer> prime;
	public static void main(String[] args) {
		prime = new ArrayList<Integer>();
		prime.add(2);
		prime.add(3);
		prime.add(5);
		prime.add(7);	
		prime.add(11);
		prime.add(13);
		
		for(int i = 13; i < Integer.MAX_VALUE && (prime.size()) < 10002; i++) {
			boolean isPrime = true;
			for (int j = 0; ((prime.get(j) <= Math.sqrt(i)) && (j < prime.size()) && (isPrime)); j++) {
				if (i % prime.get(j) == 0) {
					isPrime = false;
				}
				
			}
			if (isPrime == true) prime.add(i);
			prime.trimToSize();
		}
		
		System.out.println(prime.get(10001));
	}
}
