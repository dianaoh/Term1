package objects;

public class Card {
	private int number;
	private String suit;
	
	public Card (int number,String suit) {
		this.number= number;
		this.suit= suit;
	}
	
	public String toString () {
		return suit+","+number;
	}
	
	public int getNumber () {
		return number;
	}
	public String getSuit () {
		return suit;
	}
	
	public void print() {
		System.out.println(suit+","+number);
	}

	
}
