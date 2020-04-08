package commandLine;

import java.util.Random;
import java.util.Scanner;

public class GameController {
	private GameModel gm;
	private GameView gv;
	
	public GameController() {
		selectPNum();
	}
	
	public void selectPNum() {
		int playerNum = 0;
		while(playerNum != 2 && playerNum != 3 && playerNum != 4 && playerNum != 5) {
			Scanner input = new Scanner(System.in);
			System.out.println("Please enter number of players in total (2-5).");
			playerNum = input.nextInt();
		}
		gm = new GameModel(playerNum);
		gv = new GameView(gm);
		gm.initPlayers();
		gm.dealCards();
		System.out.println("Game Start");
		
		boolean gameOver = false;
		while(!gameOver) {
			gv.showRoundInfo();
			
			int activePlayer = gm.getCurrentActive();
			if(activePlayer == 0) {
				selectCat();
			}else {
				gm.aIPlay();
			}
			
			gm.checkWinner();
			
			gameOver = gm.getGameOver();
		}
		
		gv.showGameResult();
	}
	
	public void selectCat() {
		Scanner input = new Scanner(System.in);
		gv.showCatSel();
		int category = input.nextInt();
		gm.setCat(category);
	}
	
	public static void main(String[] args) {
		new GameController();
	}
}
