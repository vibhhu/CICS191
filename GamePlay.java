import java.util.Scanner;

// The game class
public class GamePlay {
	
	// Stores the number of coins left on the table
	int numberOfCoins;
	
	// Class constructor
	public GamePlay() {
		numberOfCoins = 48;
	}
	
	// Reduces the number of coins on the table by the given number
	// Throws an exception if the passed value is neither 1 nor 2
	public void pickUpCoins(int coinsToBePicked) {
		if (coinsToBePicked != 1 && coinsToBePicked != 2) {
			throw new IllegalArgumentException("Cheating shall not be tolerated!");
		}
		else {
			numberOfCoins -= coinsToBePicked;
		}
	}
	
	// Makes the optimal move. The strategy is to have the opponent pick up a coin when the number of coins is a multiple of 3.
	public int professorPicks() {
		
		if ((numberOfCoins - 1) % 3 == 0) {
			pickUpCoins(1);
			return 1;
		}
		
		else if ((numberOfCoins - 2) % 3 == 0) {
			pickUpCoins(2);
			return 2;
		}
		
		return 0;
	}
	
	// Returns the number of coins on the table
	public int getNumberOfCoins() {
		return numberOfCoins;
	}
	
	// Displays the rules of the game
	public void introduction() {
		System.out.println("WELCOME TO THE EVIL PROFESSOR'S DUNGEON.");
		System.out.println("1. There are 48 coins on a table. You and an evil Professor take turns picking up either one or two coins. You move first.");
		System.out.println("2. You can’t skip your turn, or pick up more than two coins. The final total value of the coins you’ve picked up doesn’t matter.");
		System.out.println("3. The object of the game is to pick up the last coin. You can assume, always, that the evil Professor plays optimally.");
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		GamePlay gamePlay = new GamePlay();
		gamePlay.introduction();
		
		// This is the game loop that runs until there are no more coins left
		while (gamePlay.getNumberOfCoins() != 0) {
			System.out.println("There are " + gamePlay.getNumberOfCoins() + " coins on the table.");
			System.out.println("How many coins would you like to pick up?");
			Scanner scanner = new Scanner(System.in);
			int coinsPickedUp = scanner.nextInt();
			gamePlay.pickUpCoins(coinsPickedUp);
			System.out.println("There are " + gamePlay.getNumberOfCoins() + " coins on the table.");
			System.out.println("The evil professor picked up " + gamePlay.professorPicks());	
		}
		// As the game is mathematically rigged, we can hard code some victory bragging
		System.out.println("HA HA HA. YOU LOSE AND THE EVIL PROFESSOR WINS.");
		System.out.println("NEXT TIME, PAY MORE ATTENTION TO WHAT RIK SAYS IN THE CICS 191 SEMINAR.");
		
	}
}

