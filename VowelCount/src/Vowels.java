public class Vowels {
  
  public static int getCount(String str) {
      
    int vowelsCount = 0;    //counting var
    str = str.toUpperCase();    //to ensure input remains the same
    
    //loop for the entire string, calling on util function to return true if vowel
    for ( int i = 0; i < str.length(); i++) {    
        if(seekVowel(str.charAt(i))) vowelsCount++;    //increment if vowel is detected
    }
    return vowelsCount;
  }

   private static boolean seekVowel(char suspect) {
     boolean verdict;    //necessary because we want we want a single entry and exit 
                         //point instead of multiple returns in the switch statement
     switch (suspect) {
         case 'A':
         case 'E':
         case 'I':
         case 'O':
         case 'U': verdict = true;       //fallthrough
                   break;
         default: verdict = false;      //if no vowels found then default here
       }
       return verdict;                  //return the verdict
     }
}