import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LargestProductInGrid {

	public static int[][] array= new int[20][20];
	
	public static void main(String[] args) {
		
		getFile();
		long maxProduct = Long.MIN_VALUE;
		
		for (int i = 0; i < 20; i++) {		//left to right
			for (int j = 3; j < 20; j++) {
				if (array[i][j] * array[i][j - 1] * array[i][j - 2] * array[i][j - 3] > maxProduct) {
					 maxProduct = array[i][j] * array[i][j - 1] * array[i][j - 2] * array[i][j - 3];
				}
			}
		}
		
		for (int i = 3; i < 20; i++) {		//top to bottom
			for (int j = 0; j < 20; j++) {
				if (array[i][j] * array[i - 1][j] * array[i - 2][j] * array[i - 3][j] > maxProduct) {
					 maxProduct = array[i][j] * array[i - 1][j] * array[i - 2][j] * array[i - 3][j];
				}
			}
		}
		
		for (int i = 3; i < 20; i++) {		//diagonal left to right
			for (int j = 3; j < 20; j++) {
				if (array[i - 3][j - 3] * array[i - 2][j - 2] * array[i - 1][j - 1] * array[i][j] > maxProduct) {
					 maxProduct = array[i - 3][j - 3] * array[i - 2][j - 2] * array[i - 1][j - 1] * array[i][j];
				}				
			}
		}
		
		
		for (int i = 3; i < 20; i++) {		//diagonal right to left
			for (int j = 19; j > 2; j--) {
				if (array[i - 3][j] * array[i - 2][j - 1] * array[i - 1][j - 2] * array[i][j - 3] > maxProduct) {
					maxProduct = (array[i - 3][j] * array[i - 2][j - 1] * array[i - 1][j - 2] * array[i][j - 3]);
				}				
			}
		}
		
		System.out.println(maxProduct);
	}
	
	public static void getFile() {
		Scanner readFile = null;
		String line;
		
		try {
			readFile = new Scanner(new FileInputStream("/home/allen/numList.txt"));
		} catch (Exception e){
			System.out.println("File was not found");
			e.printStackTrace();
		}
		
		int lineCount = 0;
		
		while(readFile.hasNext()) {
			line = readFile.nextLine();
			storeLine(line, lineCount);
			lineCount++;
		}
		
		readFile.close();
	}
	
	public static void storeLine(String line, int lineCount) {
		StringTokenizer string = new StringTokenizer(line, " ");
		
		for(int index = 0; string.hasMoreTokens() && index < 20; index ++) {
			array[lineCount][index] = Integer.parseInt(string.nextElement().toString());
		}
	}
}
