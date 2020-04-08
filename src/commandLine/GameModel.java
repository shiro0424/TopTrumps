package commandLine;

import java.util.ArrayList;
import java.util.Random;

public class GameModel {
	private ArrayList<Player> players;
	private ArrayList<Card> commonPile;
	private int playerNum = 0;
	private int round = 1;
	private int category;
	private int currentActive;
	private boolean isDraw = false;
	private boolean gameOver = false;
	private boolean humanWin = false;
	private String winner = "";
	private Card winnerCard;
	private Deck deck;
	
	public GameModel(int num) {
		deck = new Deck();
		playerNum = num;
		players = new ArrayList<Player>();
		commonPile = new ArrayList<Card>();
	}
	
	public void initPlayers() {
		Player human = new Player("You");
		players.add(human);
		for(int i = 1; i < playerNum; i++) {
			String name = "AI Player " + i;
			Player aIPlayer = new Player(name);
			players.add(aIPlayer);
		}
	}
	
	public void dealCards() {
		deck.shuffleCards();
		int deckCount = deck.getCards().size();
		int cardDivide = deckCount / playerNum;
		
		for(int i = 0; i < cardDivide; i++) {
			for(int j = 0; j < playerNum; j++) {
				Card nextCard = deck.getNextCard();
				players.get(j).addCard(nextCard);
			}
		}
	}
	
	public void setCat(int category) {
		this.category = category;
	}
	
	public int getCategory() {
		return category;
	}
	
	public int getRound() {
		return round;
	}
	
	public int getCurrentActive() {
		if(round == 1) {
			Random random = new Random();
			currentActive = random.nextInt(playerNum);
		}
		
		return currentActive;
	}
	
	public Card getCurrentCard() {
		Card currentCard = players.get(0).getCurrentCard();
		return currentCard;
	}
	
	public Card getWinnerCard() {
		return winnerCard;
	}
	
	public int getRemainCards() {
		int remainCards = players.get(0).getCards().size() - 1;
		return remainCards;
	}
	
	public boolean getIsDraw() {
		return isDraw;
	}
	
	public boolean getGameOver() {
		checkStatus();
		return gameOver;
	}
	
	public boolean getHumanWin() {
		return humanWin;
	}
	
	public int getCommonPileNum() {
		int num = commonPile.size();
		return num;
	}
	
	public String getWinner() {
		return winner;
	}
	
	public void aIPlay() {
		Player active = players.get(currentActive);
		Card card = active.getCurrentCard();
		int max = 0;
		int selection = 0;
		for(int i = 1; i < 6; i++) {
			if(card.getAttribute(i) > max) {
				max = card.getAttribute(i);
				selection = i;
			}
		}
		setCat(selection);
	}
	
	public void checkWinner() {
		int max = 0;
		ArrayList<Card> temp = new ArrayList<Card>();
		Player winner = new Player("");
		
		for(Player p : players) {
			int attribute = p.getCurrentCard().getAttribute(category);
			if(attribute > max) {
				max = attribute;
				this.winnerCard = p.getCurrentCard();
				isDraw = false;
			}else if(attribute == max) {
				isDraw = true;
			}
		}
		
		if(isDraw) {
			for(Player p : players) {
				Card currentCard = p.getCurrentCard();
				commonPile.add(currentCard);
				p.subCard(currentCard);
			}
		}else {
			int count = 0;
			for(Player p : players) {
				int attribute = p.getCurrentCard().getAttribute(category);
				if(attribute == max) {
					p.setWin(true);
					p.increaseWin();
					winner = p;
					currentActive = count;
				}else {
					temp.add(p.getCurrentCard());
					p.subCard(p.getCurrentCard());
				}
				count++;
			}
			for(Card c : temp) {
				winner.addCard(c);
			}
			for(Card c : commonPile) {
				winner.addCard(c);
			}
			commonPile = new ArrayList<Card>();
			this.winner = winner.getName(); 
		}
		round++;
		isDraw = false;
	}
	
	public void checkStatus() {
		if(getRemainCards() == 0) {
			gameOver = true;
		}else {
			players.get(0).setDraw(false);
			players.get(0).setWin(false);
		}
		for(int i = 1; i < playerNum; i++) {
			if(players.get(i).getCards().size() == 0) {
				players.remove(i);
				playerNum--;
			}else {
				players.get(i).setDraw(false);
				players.get(i).setWin(false);
			}
		}
		
		if(!gameOver && players.size() == 1) {
			gameOver = true;
			humanWin = true;
		}
	}
}
