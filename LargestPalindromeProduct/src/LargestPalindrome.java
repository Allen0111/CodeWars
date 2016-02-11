import java.util.ArrayList;

public class LargestPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (int i = 999; i >= 100; i--) {
			for (int j = 999; j >= 100; j--){
				if(findPalindrome(i*j)) {
					list.add(i*j);
				}
			}
		}
		list.trimToSize();
		long max = Integer.MIN_VALUE;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) > max) {
				max = list.get(i);
			}
		}
		
		System.out.println(max);
	}
	
	public static boolean findPalindrome(int testCase) {
		String test = Integer.toString(testCase);
		int length = test.length();
		char[] newString = new char[length];
		newString = test.toCharArray();
		
		for (int i = 0, j = (length-1); i < length/2; i++, j--) {
			if (newString[i] != newString[j]){
				return false;
			}
		}
		return true;
	}
}
