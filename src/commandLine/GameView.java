package commandLine;

public class GameView {
	private GameModel gm;
	
	public GameView(GameModel gm) {
		this.gm = gm;
	}
	
	public void showRoundInfo() {
		System.out.println("Round " + gm.getRound());
		System.out.println("Round " + gm.getRound() + ":  Players have drawn their cards");
		Card currentCard = gm.getCurrentCard();
		String description = currentCard.getDescription();
		int size = currentCard.getAttribute(1);
		int speed = currentCard.getAttribute(2);
		int range = currentCard.getAttribute(3);
		int firepower = currentCard.getAttribute(4);
		int cargo = currentCard.getAttribute(5);
		System.out.println("You drew \'" + description + "\':");
		System.out.println("   > Size: " + size);
		System.out.println("   > Speed: " + speed);
		System.out.println("   > Range: " + range);
		System.out.println("   > Firepower: " + firepower);
		System.out.println("   > Cargo: " + cargo);
		int remainCards = gm.getRemainCards();
		System.out.println("There are " + remainCards + " cards in your deck");
	}
	
	public void showCatSel() {
		System.out.println("It is your turn to select a category, the categories are:");
		System.out.println("1: Size");
		System.out.println("2: Speed");
		System.out.println("3: Range");
		System.out.println("4: Firepower");
		System.out.println("5: Cargo");
		System.out.println("Enter the number for your attribute:");
	}
	
	public void showRoundResult() {
		if(gm.getIsDraw()) {
			System.out.println("Round " + gm.getRound() + 
					": This round was a Draw, common pile now has " + gm.getCommonPileNum() + " cards");
		}else {
			System.out.println("Round " + gm.getRound() + ": " + gm.getWinner() + " won this round");
		}
		
		Card winnerCard = gm.getWinnerCard();
		String description = winnerCard.getDescription();
		int size = winnerCard.getAttribute(1);
		int speed = winnerCard.getAttribute(2);
		int range = winnerCard.getAttribute(3);
		int firepower = winnerCard.getAttribute(4);
		int cargo = winnerCard.getAttribute(5);
		int category = gm.getCategory();
		System.out.println("The winning card was \'" + description + "\':");
		if(category == 1) {
			System.out.println("   > Size: " + size + " <--");
			System.out.println("   > Speed: " + speed);
			System.out.println("   > Range: " + range);
			System.out.println("   > Firepower: " + firepower);
			System.out.println("   > Cargo: " + cargo);
		}else if(category == 2) {
			System.out.println("   > Size: " + size);
			System.out.println("   > Speed: " + speed + " <--");
			System.out.println("   > Range: " + range);
			System.out.println("   > Firepower: " + firepower);
			System.out.println("   > Cargo: " + cargo);
		}else if(category == 3) {
			System.out.println("   > Size: " + size);
			System.out.println("   > Speed: " + speed);
			System.out.println("   > Range: " + range + " <--");
			System.out.println("   > Firepower: " + firepower);
			System.out.println("   > Cargo: " + cargo);
		}else if(category == 4) {
			System.out.println("   > Size: " + size);
			System.out.println("   > Speed: " + speed);
			System.out.println("   > Range: " + range);
			System.out.println("   > Firepower: " + firepower + " <--");
			System.out.println("   > Cargo: " + cargo);
		}else {
			System.out.println("   > Size: " + size);
			System.out.println("   > Speed: " + speed);
			System.out.println("   > Range: " + range);
			System.out.println("   > Firepower: " + firepower);
			System.out.println("   > Cargo: " + cargo + " <--");
		}
		
	}
	
	public void showGameResult() {
		System.out.println("Game End");
		System.out.println();
		if(gm.getHumanWin()) {
			System.out.println("You won the game");
		}else {
			System.out.println("You lost the game");
		}
	}
}
