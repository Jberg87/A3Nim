import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
	
	// Jesper is awesome   <-- moet er 100% in

	public int grabMatches(int manualOrAuto, int matchesRemaining, int grabMax) {

		System.out.println("The number of matches remaining is " + matchesRemaining);
		int grabbed = 0;
		
		// 0 is users turn, 1 or 2 is PC's turn
		if (manualOrAuto == 0) { 
			System.out.print("How many matches do you want to grab? Choose between 1 and " + grabMax + ": ");
			Scanner pick = new Scanner(System.in);
			boolean correctgrab = false;
			while (correctgrab == false) {
				grabbed = pick.nextInt();
				try {
					if (grabbed > grabMax || grabbed < 1) {
						System.out
								.print("This amount is not possible, choose between 1 and "
										+ grabMax + ": ");
					} else {
						correctgrab = true;
					}
				} catch (InputMismatchException e) {
					System.out.println("This is not a valid imput");
					System.out
							.print("How many matches do you want to grab? Choose between 1 and "
									+ grabMax + ": ");
				}
			}

		} else if (manualOrAuto == 1) {
			
			if (matchesRemaining - grabMax == 1){
				grabbed = grabMax;
			} else if (matchesRemaining - (grabMax - 1) == 1) {
				grabbed = grabMax - 1;
			} else if (matchesRemaining - (grabMax - 2) == 1) {
				grabbed = grabMax - 2;
			} else if (matchesRemaining - (grabMax - 3) == 1) {
				grabbed = grabMax - 3;
			} else {
				grabbed = (int) (Math.random() * (grabMax - 1)) + 1;
			}
			if (grabbed == 1) {
				System.out.println("PC has picked " + grabbed
						+ " match");
			} else {
				System.out.println("PC has picked " + grabbed
						+ " matches");
			}
		}
		
		else if (manualOrAuto == 2) {
			if (matchesRemaining - grabMax == 1){
				grabbed = grabMax;
			} else if (matchesRemaining - (grabMax - 1) == 1) {
				grabbed = grabMax - 1;
			} else if (matchesRemaining - (grabMax - 2) == 1) {
				grabbed = grabMax - 2;
			} else if (matchesRemaining - (grabMax - 3) == 1) {
				grabbed = grabMax - 3;
			} else {
				grabbed = (int) (Math.random() * (grabMax - 1)) + 1;
			}
			if (grabbed == 1) {
				System.out.println("PC2 has picked " + grabbed
						+ " match");
			} else {
				System.out.println("PC2 has picked " + grabbed
						+ " matches");
			}
		}
		return grabbed;
	}
}
