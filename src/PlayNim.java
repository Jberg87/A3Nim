
public class PlayNim {

	public static void main(String[] args) {
		
		NimGame spelletje = new NimGame();		
		int amountOfPlayers = spelletje.startup();
		spelletje.game(amountOfPlayers, 11);
	}
}