//import java.util.StringTokenizer;

public class GhostBusters {
	private static String Autograph = "You just wanted my autograph didn't you?";
	
	public static String ghostBusters(String building) {
		int strlen = building.length();
		char[] temp = new char[strlen];
		temp = building.toCharArray();
		char[] newString = new char[strlen];
		int index = 0;
		int spaces = 0;
		for (int i = 0; i < strlen; i++) {
			if (Character.isSpaceChar(temp[i])) {
				spaces++;
			} else {
				newString[index] = temp[i];
				index++;
			}
		}
		
		String noGhost = new String(newString);
		if (spaces > 0) {
			return noGhost.trim();
		} else {
			return Autograph;
		}
	}
	
  /*public static String ghostBusters(String building) {
      StringTokenizer str = new StringTokenizer(building," ");
      
      if (str.countTokens() == 1) return("You just wanted my autograph didn't you?");
      
      String temp = "";
      
      while(str.hasMoreTokens()) {
    	  temp = temp + (str.nextToken());
      }
      
	  return (temp);
  }*/
}