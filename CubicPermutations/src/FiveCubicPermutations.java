import java.util.*;

/*
 * 
 * The cube, 41063625 (345^3), can be permuted to produce two other cubes: 56623104 (384^3) and 66430125 (405^3). 
 * In fact, 41063625 is the smallest cube which has exactly three permutations of its digits which are also cube.
 *
 * Find the smallest cube for which exactly five permutations of its digits are cube.
 */

public class FiveCubicPermutations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map permutations = new HashMap();
		
		for (long i = 22; i < Long.MAX_VALUE; i++) {
			long value = i * i * i;
			char[] key = {0,0,0,0,0,0,0,0,0,0};
			String stringValue = Long.toString(value);

			for (int loopCount = 0; loopCount < stringValue.length(); loopCount++) {
				char num = stringValue.charAt(loopCount);
				key[charToNum(num)]++;
			}
			
		}
	}
	
	private static int charToNum(char num) {
		switch (num) {
			case '0': 	return 0;
			case '1':	return 1;
			case '2': 	return 2;
			case '3':	return 3;
			case '4': 	return 4;
			case '5':	return 5;
			case '6': 	return 6;
			case '7':	return 7;
			case '8': 	return 8;
			case '9':	return 9;
			default:	System.out.println("error reading number")
		}

	}

}
