import java.util.Hashtable;
import java.util.ArrayList;

public class Kata {
	
  public static int findEvenIndex(int[] arr) {
    
    int index = -1;
    
    int len = arr.length;
    Hashtable d = new Hashtable();
    int sumRightToLeft = 0;
    for (int i = 0; i < len; i++) {
        sumRightToLeft += arr[i];
    }
    
    int sumLeftToRight = 0;
    
    for (int i = 0; i < len; i++) {
        ArrayList storage = new ArrayList();
        sumRightToLeft -= arr[i];
        if(i > 0) {
            storage.add(sumLeftToRight);
            storage.add(sumRightToLeft);
        } else {
            storage.add(0);
            storage.add(sumRightToLeft);
        }
        
        d.put(i,storage);
        
        sumLeftToRight += arr[i];
        
    }
    
    for (int i = 1; i < (len - 1); i++) {
       int left = (int) ((ArrayList) (d.get(i))).get(0);
       int right = (int) ((ArrayList) (d.get(i))).get(1);
        
       if (left == right) {
           index = i;
           break;
       }
    }
    
    return index;
  }
}