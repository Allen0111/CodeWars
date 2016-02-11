
public class InsertionSort {

	public static int[] A = {31,41,59,26,41,58};
	
	public static void main(String[] args) {
		increasingOrder();
		
		for( int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
		}
		
		System.out.println();
		System.out.println();
		
		decreasingOrder();
		
		for( int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
		}

	}

	public static void increasingOrder() {
		int key = 0;
		
		for (int j = 1; j  < A.length; j++) {
			key = A[j];
			int i = j - 1;
			while ( i >= 0 && A[i] > key) {
				A[i+1] = A[i];
				i--;
			}
			A[i+1] = key;
		}
	}
	
	public static void decreasingOrder() {

		int key = 0;
		for (int j = A.length - 2; j >= 0; j--) {
			key = A[j];
			int i = j+1;
			while ((i < (A.length)) && A[i] > key) {
				A[i - 1] = A[i];
				i++;
			}
			A[i-1] =key;
		}
	}
}
