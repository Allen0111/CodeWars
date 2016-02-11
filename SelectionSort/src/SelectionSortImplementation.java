
public class SelectionSortImplementation {


	public static int A[] = {52,26,7,58,564,68,97,45,6648,29};
	
	public static void main(String[] args) {
		
		for (int i = 0; i < A.length;i++) {
			int min = A[i];
			int minIndex = i;
			int minCount = 0;
			for (int j = i; j < A.length; j++) {
				if (A[j] < min) {
					min = A[j];
					minIndex = j;
					minCount++;
				}
			}
			if (minCount > 0) {
				int temp = A[minIndex];
				A[minIndex] = A[i];
				A[i] = temp;
			}
		}
		
		for (int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
		}

	}

}
