import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Pokemon main plays a game of pokemon mind reader where the player and
 * computer choose a a pokemon element and the winner gets a point and the
 * percentage is shown. This program has a file reader and writer
 * 
 * @author Jesus vargas
 *
 */
public class PokeTester {

	public static void main(String[] args) {
		menu();
	}

	/**
	 * ReadFile method The file is read in
	 * 
	 * @param game object game is read in
	 *           
	 * @return the computer object
	 */
	public static Computer readFile(int game) {
		boolean file = false;
		Computer c = null;

		File f = new File("Pokemon.Dat");

		if (f.exists() && game == 2) {
			try {
				ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
				c = (Computer) in.readObject();
				in.close();
			} catch (IOException e) {
				System.out.println("Error processing file.");
			} catch (ClassNotFoundException e) {
				System.out.println("Could not find class.");
			}
			System.out.println("Welcome to Veteran Pokemon Mind reader");

		} else {
			c = new Computer();
			System.out.println("Welcome to Beginner");
		}

		return c;

	}

	/**
	 * Menu method has a repeating menu to choose pokemon. for the first 4
	 * rounds, the computer sends a random number. After the four rounds the
	 * computer predicts pattern based on the three strings.
	 * 
	 */
	public static void menu() {
		boolean done = false;

		int pWins = 0;
		int cWins = 0;
		int round = 0;

		int computer = 0;
		String write = "";
		// reads in saved file
		System.out.println("Welcome to Pokemon Mind Reader");
		System.out.println("Choose Difficulty");
		System.out.println("1. Beginner");
		System.out.println("2. Veteran");

		int choose = CheckInput.checkInt(1, 2);
		Computer c = readFile(choose);

		String pattern = "";

		try {
			pattern = c.getPattern();

		} catch (NullPointerException e) {
			pattern = "";

		}

		while (!done) {// beginner

			if (pattern.length() == 4) {

				System.out.println(pattern);
				computer = c.makePrediction(pattern);
				c.storePattern(new Pattern(pattern));
				pattern = pattern.substring(1);
			} else {
				int randChoice = (int) (Math.random() * 3) + 1;
				System.out.println("rand" + randChoice);
				computer = randChoice;
			}
			System.out.println("Choose Pokemon");
			System.out.println("1. Fire");
			System.out.println("2. Water");
			System.out.println("3. Grass");
			System.out.println("4. quit");

			// player chooses
			int player = CheckInput.checkInt(1, 4);

			if (player == 4) {

				System.out.println("Would you like to save: ");
				System.out.println("1.yes ");
				System.out.println("2.no ");
				choose = CheckInput.checkInt(1, 2);

				if (choose == 1) {
					System.out.println("Saving.........");
					writeGame(c);
				} else {
					System.out.println("Goodbye");
				}

				done = true;
			} else {
				pattern = playGame(player, pattern, computer);// plays game and
																// returens
																// pattern
				int win = winner(player, c, pattern, computer);// chooses winner
																// and returns
																// value

				if (win == 1) {// player wins
					pWins++;
					round++;

				} else if (win == -1) {// computer wins
					cWins++;
					round++;
				} else {
					round++;
				}

				showPercentage(cWins, pWins, round);// shows percentage

				writeGame(c);// save game every round
			}

		}
	}

	/**
	 * Play game displays what player and computer is chooseing then increments
	 * pattern.
	 * 
	 * @param player passes in player int choice
	 *           
	 * @param pattern passes in string patter
	 *           
	 * @param computer passes in computer int choice
	 *             
	 * @return pattern string pattern
	 */
	public static String playGame(int player, String pattern, int computer) {

		if (player == 1) {
			System.out.println("Player chose fire");
			pattern += "f";
		} else if (player == 2) {
			System.out.println("Player chose water");
			pattern += "w";
		} else if (player == 3) {
			System.out.println("Player chose grass");
			pattern += "g";
		}

		if (computer == 1) {
			System.out.println("Computer chose fire");
		} else if (computer == 2) {
			System.out.println("Computer chose water");
		} else if (computer == 3) {
			System.out.println("Computer chose grass");
		}

		System.out.println();

		return pattern;
	}

	/**
	 * Winner method checks determines the winner
	 * 
	 * 
	 * @param player object is passed in
	 *            
	 * @param c computer object is passed in t
	 *            
	 * @param pattern string pattern is passed in
	 *           
	 * @param computer computer integer is passed in
	 *           
	 * @return win integer win choise is returned
	 */
	public static int winner(int player, Computer c, String pattern, int computer) {

		int win = 0;
		// 1.fire beats 3.grass
		// 3.grass beats 2.water
		// 2.water beats 1.fire

		if ((player == 1 && computer == 3) || (player == 3 && computer == 2) || (player == 2 && computer == 1)) {// player
																													// wins
			System.out.println("player wins");
			win = 1;
		} else if ((computer == 1 && player == 3) || (computer == 3 && player == 2) || (computer == 2 && player == 1)) {// computer
																														// wins
			System.out.println("Computer wins");
			win = -1;
		} else if ((player == 1 && computer == 1) || (player == 2 && computer == 2) || (player == 3 && computer == 3)) {// ti3
			System.out.println("tie");
		}
		System.out.println();
		return win;
	}

	/**
	 * Show percentage method shows the percentage.
	 * 
	 * @param computer integer computer choice is passed in
	 *           
	 * @param player integer player choice is passed in
	 *           
	 * @param round integer player choice is passed in
	 *            
	 */
	public static void showPercentage(int computer, int player, int round) {
		int total = round;
		double percentage = 0.0;

		System.out.println("total" + total);
		System.out.println("Player   score:" + player);
		System.out.println("Computer score:" + computer);

		if (total == 0) {
			System.out.println("Percentage of computer: 0 %");
		} else {

			percentage = ((double) computer) / total;
			System.out.println("Percentage of computer:" + percentage * 100 + "%");

		}

		System.out.println();

	}

	/**
	 * Write game method writes the game and stores it in a file
	 * 
	 * @param c  passes in computer object
	 *          
	 */
	public static void writeGame(Computer c) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Pokemon.Dat"));
			out.writeObject(c);
			out.close();
		} catch (IOException e) {
			System.out.println("Error processing file.");
		}
	}

}
