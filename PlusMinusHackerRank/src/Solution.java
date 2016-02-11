import java.io.*;
import java.util.*;
/**
 * 
 * @author allen
 *
 *Given an array of integers, calculate which fraction of the elements are positive, negative, and zeroes, respectively. Print the decimal value of each fraction.
 *
 * Input Format
 *
 * The first line, N, is the size of the array.
 * The second line contains N space-separated integers describing the array of numbers (A1,A2,A3,⋯,AN).
 * 
 * Output Format
 * 
 * Print each value on its own line with the fraction of positive numbers first, negative numbers second, and zeroes third.
 */
public class Solution {

    public static void main(String[] args) {
    	
    	int positive, negative, zero = 0;
    	
    	positive = negative = zero;
    	
    	Scanner inputStream = new Scanner(System.in);
    	
    	String userInput = inputStream.nextLine();
    	int n = 0;
    	try {
    		 n = Integer.parseInt(userInput);
    	} catch(NumberFormatException nfe) {
    		System.out.println("bad input");
    		System.out.println(nfe);
    	}
    	int[] array = new int[n];
    	
    	userInput = inputStream.nextLine();
    	
    	String[] stringArray = userInput.split(" ");
    	
    	for(int i = 0; i < stringArray.length; i++) {
    		try {
    			array[i] = Integer.parseInt(stringArray[i]);
    		} catch(NumberFormatException nfe) {
    			System.out.println("your input contained invalid characters");
    			System.out.println("nfe");
    		}
    	}
    	
    	inputStream.close();
    	
    	for(int i = 0; i < n; i++) {
    		if (array[i] < 0) {
    			negative++;
    		} else if (array[i] > 0) {
    			positive++;
    		} else {
    			zero++;
    		}
    	}
    	
    	System.out.printf("%.6f\n",(double) positive / n);
    	System.out.printf("%.6f\n",(double) negative / n);
    	System.out.printf("%.6f\n",(double) zero / n);
    }
}