package commandLine;

import java.util.ArrayList;

public class Player {
	private String name;
	private ArrayList<Card> cards;
	private int winCount = 0;
	private boolean isWin;
	private boolean isDraw;
	
	public Player(String name) {
		this.name = name;
		cards = new ArrayList<Card>();
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}
	
	public void subCard(Card card) {
		cards.remove(card);
	}
	
	public void increaseWin() {
		winCount++;
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Card> getCards() {
		return cards;
	}
	
	public Card getCurrentCard() {
		return cards.get(0);
	}
	
	public int getWinCount() {
		return winCount;
	}
	
	public void setWin(boolean isWin) {
		this.isWin = isWin;
	}
	
	public void setDraw(boolean isDraw) {
		this.isDraw = isDraw;
	}
	
	public boolean getIsWin() {
		return isWin;
	}
	
	public boolean getIsDraw() {
		return isDraw;
	}
}
