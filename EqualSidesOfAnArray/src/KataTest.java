public class KataTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("3, " + Kata.findEvenIndex(new int[] {1,2,3,4,3,2,1})); // 3
		System.out.println("1, " + Kata.findEvenIndex(new int[] {1,100,50,-51,1,1})); // 1
	    System.out.println("-1, " + Kata.findEvenIndex(new int[] {1,2,3,4,5,6}));  //-1
	    System.out.println("3, " + Kata.findEvenIndex(new int[] {20,10,30,10,10,15,35})); // 3
	    System.out.println(" -1, " + Kata.findEvenIndex(new int[] {-8505, -5130, 1926, -9026}));	//-1
	    System.out.println("1, " + Kata.findEvenIndex(new int[] {2824, 1774, -1490, -9084, -9696, 23094})); //1
	    System.out.println("6, " + Kata.findEvenIndex(new int[] {4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4})); //6
	}
}