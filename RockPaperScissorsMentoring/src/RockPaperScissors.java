import java.util.Scanner;
import java.util.Enumeration;
import java.util.Random;

public class RockPaperScissors {

	
	public static final String[] rockPaperScissors =  {"rock","paper","scissors"};
	public static final String win = "You Win! ";
	public static final String lose = "You Lose! ";
	public static final String draw = "Tie! ";
		
	public static void main(String[] args) {
		
		
		Scanner readInput = new Scanner(System.in);
		String userInput = null;
		int input = 0; 
		boolean done = false;
		
		while(!done) {
			
			System.out.println("Rock, Paper, or Scissors? (r/p/s)?");
			
			userInput = readInput.nextLine();
			input = evaluateInput(userInput);
			if (input == 0) {
				continue;
			} else {
				input--;
			}
			
			Random randomGenerator = new Random();
			int random = randomGenerator.nextInt(3);
			
			evaluateResult(input, random);
			
			System.out.println("Would you like to continue? (y/n)");
			userInput = readInput.nextLine();
			if (userInput.charAt(0) == 'N' || userInput.charAt(0) == 'n') {
				done = true;
			}
			
		}
		System.out.println("Thanks for playing!");
		readInput.close();
	}
	
	public static void printResult(String result, int user, int computer) {

		if (result.equals(draw)) {
			System.out.println(result + rockPaperScissors[user] + " = " + rockPaperScissors[computer]); 
		} else if (result.equals(win)){
			System.out.println(result + rockPaperScissors[user] + " beats " + rockPaperScissors[computer]); 
		} else {
			System.out.println(result + rockPaperScissors[computer] + " beats " + rockPaperScissors[user]); 
		}
	}
	
	public static void evaluateResult(int user, int computer) {
		
		switch (user) {
			case(0):	if (computer == 0) {
			/*ROCK*/		printResult(draw, user, computer); 
						} else if (computer == 1) {
							printResult(lose, user, computer); 
						} else {
							printResult(win, user, computer);
						}
						break;
						
			case(1):	if (computer == 0) {
			/*PAPER*/		printResult(win, user, computer); 
						} else if (computer == 1) {
							printResult(draw, user, computer); 
						} else {
							printResult(lose, user, computer);
						}
						break;	
						
			case(2): 	if (computer == 0) {
			/*SCISSORS*/	printResult(lose, user, computer); 
						} else if (computer == 1) {
							printResult(win, user, computer); 
						} else {
							printResult(draw, user, computer);
						}
						break;
		}
		
	}
	
	public static int evaluateInput(String userInput) {
		int input = 0;
		
		if (userInput.charAt(0) == 'r' || userInput.charAt(0) == 'R') {
			input = 1;
		} else if (userInput.charAt(0) == 'p' || userInput.charAt(0) == 'P') {
			input = 2;
		} else if (userInput.charAt(0) == 's' || userInput.charAt(0) == 'S') {
			input = 3;
		} else {
			System.out.println("sorry, i dont understand the input. Try Again");
		}
		
		return input;
	}

}
