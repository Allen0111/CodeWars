
public class SmallestMultiple {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 2520; i < Integer.MAX_VALUE; i++)  {
			for (int j = 1; j <= 100; j++){
				if (i%j !=0) break;
				if (j == 100) {
					System.out.println(i);
					return;
				}
			}
		}
	}

}
