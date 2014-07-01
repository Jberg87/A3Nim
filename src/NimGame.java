import java.util.InputMismatchException;
import java.util.Scanner;

public class NimGame {

	private int players;
    private int matches;
    private int matchesGrabbed;
    private int turn = 0;
    private boolean matchesRemaining = true;

	public int startup() {
		System.out.println("Let's play a game of Nim");
		boolean validAmount = false;
		Scanner input = new Scanner(System.in);
		do {
			System.out.print("How many players are playing?: ");
			players = input.nextInt();
			if (players == 2 | players == 3) {
				System.out.println();
				System.out.println("The game is played with " + players
						+ " players. Let's begin!");
				System.out
						.println("You and the PC may grab between 1 and 4 matches");
				System.out.println();
				validAmount = true;
			} else {
				try {} // Voor het invullen van een string krijg ik de
					// InputMismatchExeption niet gecatched...
				catch (InputMismatchException e) {
					System.out
							.println("This is an invalid amount. Enter 2 or 3: ");
				}
			}
		} while (!validAmount);
		return players;
	}

	public void game(int n, int m) {
		Player user = new Player();
		int matches = m;

		while (matchesRemaining) {
			int grabMax;
			if (matches < 4) {
				grabMax = matches;
			} else {
				grabMax = 4;
			}

				matchesGrabbed = user.grabMatches(turn, matches, grabMax);
				matches = matches - matchesGrabbed;
				if (matches == 0) {
					turnLoses(turn);
					break;
				}
				turn = turnDecide(players, turn);
		}
	}

	private int turnDecide(int players2, int turn2) {
		System.out.println("");

		if (turn == 0) {
			turn = 1;
		} else if (turn == 1) {
			if (players2 == 2) {
				turn = 0;
			} else {
				turn = 2;
			}
		} else {
			turn = 0;
		}
		return turn;
	}

	private void turnLoses(int turnLast) {
		System.out.println("");
		System.out.println("End of the game. No more matches remaining.");
		if (turnLast == 0) {
			System.out.println("You lose!");
		} else if (turnLast == 1) {
			System.out.println("PC loses, you win!");
		} else if (turnLast == 2) {
			System.out.println("PC2 loses, you win!");

		}

	}
}