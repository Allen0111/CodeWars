import java.util.ArrayList;
import java.util.Arrays;


public class Rotator {

	public Object[] rotate(Object[] data, int n) {

		if (data.length <= 1) {		// if array is <= 1, any shifting will result in same form
			return data;			
		}
		
		if (n == 0) {		//if no shifting needed, return
			return data;
		}
		
		if ((n % data.length) == 0) {		//if n shifting will result in same form, return
			return data;
		}
	
		ArrayList<Object> temp = new ArrayList<Object>(Arrays.asList(data));	//two temporary lists
		ArrayList<Object> tempN = new ArrayList<Object>();
		
		long  size = temp.size();		//long because we don't know the size of the input
		long newN = (n % size);			//reduce unnecessary shifting
		
		if (n > 0) {		//if its positive shifting, we shift right
			for (long i = (size - newN); i < (size); i++) {		//begin shifting right
				tempN.add(temp.get((int)i));
			}
			for (long i = (size - 1); i >= (size - newN); i--) {
				temp.remove((int)i);
			}
			tempN.addAll((int)newN, temp);	//concatenate the two arrays
			tempN.trimToSize();				//prep for return
			data = tempN.toArray();
		} else /*(n < 0)*/ {		// if its negative shifting, we shift left
			for (long i = 0; i < (Math.abs(newN)); i++) {	//begin shifting left
				tempN.add(temp.get((int) i));
			}
			for (long i = (Math.abs(newN) - 1); i >= 0; i--) {
				temp.remove((int)i);
			}
			temp.addAll(tempN);		//concatenate the two arrays
			temp.trimToSize();		//prep for return
			data = tempN.toArray();
		}
		return data;
	}

}
