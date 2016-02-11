
public class SumSquareDiff {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		long sumOfSquares = 0;
		long squareOfSum = 0;
		
		for (int i = 1; i < 101; i++) {
			sumOfSquares = sumOfSquares + (i*i);
			squareOfSum += i;
		}
		squareOfSum *= squareOfSum;
		System.out.println(sumOfSquares);
		System.out.println(squareOfSum);
		System.out.println(squareOfSum - sumOfSquares);
	}

}
