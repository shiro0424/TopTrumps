package commandLine;

public class Card {
	private String description;
	private int size;
	private int speed;
	private int range;
	private int firepower;
	private int cargo;
	
	public Card(String description, int size, int speed, 
			int range, int firepower, int cargo) {
		this.description = description;
		this.size = size;
		this.speed = speed;
		this.range = range;
		this.firepower = firepower;
		this.cargo = cargo;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getAttribute(int category) {
		if(category == 1) {
			return size;
		}else if(category == 2) {
			return speed;
		}else if(category == 3) {
			return range;
		}else if(category == 4) {
			return firepower;
		}else {
			return cargo;
		}
	}
	
	public String toString() {
		String cardInfo = description + ": " + size + ", " + speed + ", " + range + ", " + firepower + ", " + cargo;
		return cardInfo;
	}
}
