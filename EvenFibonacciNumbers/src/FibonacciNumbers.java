
public class FibonacciNumbers {

	/**
	 * @param args
	 */
	
	public static int sum = 0;
	
	public static void main(String[] args) {
		sum = 0;
		
		fibCount(1,2);
		System.out.println(sum);
		
	}

	public static void fibCount(int n, int m) {
		
		int temp = n + m;
		
		if (m < 4000000) {
			if (n%2 == 0) {
				sum += n;
			}
			if (m < 4000000) {
				if (m%2 == 0) {
					sum += m;
				}
			}
			fibCount(temp, m+temp);
		}
	}
}