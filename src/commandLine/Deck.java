package commandLine;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Deck {
	private ArrayList<Card> cards;
	private int cardIndex = -1;
	
	public Deck() {
		cards = new ArrayList<Card>();
		initDeck();
	}
	
	public void initDeck() {
		String fileName = "StarCitizenDeck.txt";
		
		try {
			FileReader fr = new FileReader(fileName);
			Scanner s = new Scanner(fr);
			String cardText = s.nextLine();
			while(s.hasNextLine()) {
				cardText = s.nextLine();
				String[] cardInfo = cardText.split(" ");
				String description = cardInfo[0];
				int size = Integer.parseInt(cardInfo[1]);
				int speed = Integer.parseInt(cardInfo[2]);
				int range = Integer.parseInt(cardInfo[3]);
				int firepower = Integer.parseInt(cardInfo[4]);
				int cargo = Integer.parseInt(cardInfo[5]);
				Card card = new Card(description, size, speed, range, firepower, cargo);
				cards.add(card);
			}
			fr.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Card> getCards(){
		return cards;
	}
	
	public void shuffleCards() {
		for(int i = 0; i < 3; i++) {
			Collections.shuffle(cards);
		}
	}
	
	public Card getNextCard() {
		cardIndex++;
		return cards.get(cardIndex);
	}
	
	public static void main(String[] args) {
		Deck deck = new Deck();
		ArrayList<Card> cards = deck.getCards();
		System.out.println(cards.size());
		for(Card c : cards) {
			System.out.println(c);
		}
		deck.shuffleCards();
		System.out.println(cards.size());
		for(Card c : cards) {
			System.out.println(c);
		}
	}
}
