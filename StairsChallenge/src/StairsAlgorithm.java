import java.util.ArrayList;

public class StairsAlgorithm {
	  
	public static int NumberOfSteps(int numStairs, int multiple) {
	    
		//eliminate unnecessary calculations
		if (multiple > numStairs) return -1;
	    
		ArrayList<Integer> steps = new ArrayList<Integer>();
		
		int stairCount = numStairs;
		
		while (stairCount > 0) {
			if (stairCount > 1) {
				steps.add(2);
				stairCount = stairCount - 2;
			} else {
				steps.add(1);
				stairCount--;
			}
		}
		
		steps.trimToSize();
		
	    while ((steps.size() % multiple) != 0) {
	    	steps.set(steps.lastIndexOf(2),1);
	    	steps.add(1);
	    }
		
	    return steps.size();
	     
	}
}
