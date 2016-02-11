
public class SystemOfEq {
	
	public static int Solution(int n, int m) {
		
		int count = 0;
		int tempA, tempB;
    
		if (n > m) {
			for (int i = 0; i <= n; i++) {
				if ((Math.sqrt(n - i)) == (tempA = (int)Math.sqrt(n - 1))) {  // a = sqrt(n - i)
					if (Math.sqrt(m - tempA) == (int)Math.sqrt(m - tempA)) {    // b = sqrt(m - a)
						count++;                                                //if result is an int then increment
					}
				}
			}
		} else {
			for (int i = 0; i <= m; i++) {
				if ((Math.sqrt(m - i)) == (tempB = (int)Math.sqrt(m - 1))) {  // b = sqrt(m - i)
					if (Math.sqrt(n - tempB) == (int)Math.sqrt(n - tempB)) {    // a = sqrt(n - b)
						count++;                                                //if result is an int then increment
					}
				}
			}
		}
		
		return count;
	}
}
