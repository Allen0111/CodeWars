/**
 * 
 * The goal of this exercise is to convert a string to a new string where each character 
 * in the new string is '(' if that character appears only once in the original string, or ')' 
 * if that character appears more than once in the original string. Ignore capitalization 
 * when determining if a character is a duplicate.
 * 
 * Examples:
 * "din" => "((("
 * "recede" => "()()()"
 * "Success" => ")())())"
 * "(( @" => "))(("
 *
 *
 *
 * hash map with key equal to the alphabet and 
 * value is an integer whose count will increase as the 
 * number of occurrences increases.
 * 
 */

import java.util.*;

public class DuplicateEncoder {
	
	static String encode(String word){

		@SuppressWarnings("rawtypes")
		HashMap characterCount = new HashMap();
		
		for (int i = 0; i < word.length();i++) {
			if(characterCount.containsKey(word.charAt(i))) {
				characterCount.put(word.charAt(i), (Integer) 1);
			} else {
				int temp = (Integer) characterCount.get(word.charAt(i));
				temp++;
				characterCount.put((Character)word.charAt(i),(Integer) temp);
			}
		}
		
		return word;
	}
	
}
