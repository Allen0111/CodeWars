
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = {2,3,4,5,6,1,8};
		System.out.println(findMIn(a));

	}
	
	public static int findMIn(int[] a) {
		
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < a.length; i++) {
			if (a[i] < min) min = a[i];
		}
		
		return min;
	}

}
