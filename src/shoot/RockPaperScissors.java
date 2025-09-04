package shoot;

import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {
		
		System.out.println("Welcome to Rock Paper Scissors!");
		
		Scanner scan = new Scanner(System.in);
		
		int NumOfGame = 3;
		int userNumOfWin = 0;
		int GameNum = 1;
		int computerNumOfWin = 0;
		
		while(NumOfGame != 0) {
			
		
			String[] choices = {"rock", "paper", "scissors"};
			
			System.out.println("Game # " + (GameNum) + " out of 3");
		
			System.out.println("Input Choice (rock, paper, scissors): ");
		
			String UserChoice = scan.next().toLowerCase();
		
			// To validate user input is within parameters
			while(!isValidChoice(UserChoice, choices)) {
				System.out.println("Invalid Choice! Choose again!");
				UserChoice = scan.nextLine().toLowerCase();
			}
		
			String computerChoice = generateComputerChoice(choices);
		
			System.out.println("Computer's Choice: " + computerChoice);
		
			String result = determineWinner(UserChoice, computerChoice);
		
			System.out.println(result);
		
			NumOfGame--;
			GameNum++;
		
			if(result.equals("You Win!")) {
				userNumOfWin++;
			}
			else if(result.equals("Computer Wins!")) {
				computerNumOfWin++;
			}
			else if(result.equals("Its a Tie!")) {
				userNumOfWin++;
				computerNumOfWin++;
			}
				
		}
		
		scan.close();
		
		if(userNumOfWin > computerNumOfWin) {
			System.out.println("You WON!");
		}
		else if (userNumOfWin < computerNumOfWin) {
			System.out.println("You LOSE");
		}
		else if (userNumOfWin == computerNumOfWin) {
			System.out.println("Its A TIE!");
		}
		
		
	}
	
	private static String determineWinner(String userChoice, String computerChoice) {
		String result = "";
		
		if(userChoice.equals(computerChoice)) {
			return "Its a Tie!";
		}
		else if((userChoice.equals("rock") && computerChoice.equals("scissors")) ||
				(userChoice.equals("scissors") && computerChoice.equals("paper")) ||
				(userChoice.equals("paper") && computerChoice.equals("rock"))) {
			return "You Win!";
		}
		else
			return "Computer Wins!";
	}

	private static String generateComputerChoice(String[] choices) {
		int randomIndex = (int) (Math.random() * choices.length);
		
		return choices[randomIndex];
	}

	private static boolean isValidChoice(String userChoice, String[] validChoices) {
		for(String validChoice : validChoices) {
			if(userChoice.equals(validChoice)) {
				return true;
			}
		}
		
		return false;
	}

}
