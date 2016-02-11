import java.io.*;
import java.util.*;


public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        
        String result = "yes";

        for(int i = 0; i < (A.length()/2); i++) {
        	if (A.charAt(i) != A.charAt(A.length() - i - 1)) {
        		result = "no";
        		break;
        	}
        }
        
        System.out.println(result);
	}

}
