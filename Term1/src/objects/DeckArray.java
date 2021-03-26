package objects;

public class DeckArray {
	private Card[] deck= new Card [52];
	
	public DeckArray() {
		int count=1;
		for (int i=0;i<deck.length;i+=4) {
			deck[i]=new Card (count,"Heart");
			deck[i+1]=new Card(count,"Spade");
			deck[i+2]= new Card (count,"Club");
			deck[i+3]= new Card (count,"Diamond");
			count++;
		}
	}
	
	public void display () {
		for (Card d:deck) {
			System.out.println(d.toString ());
		}
	}
	
	public Card getRandom () {
		int random= (int)(Math.random()*52);
		return deck[random];
	}
	
	public Card [] getFirstN (int n) {
		Card []newCard = new Card [n];
		int count=0;
		for (Card d:deck) {
			if (count<n) {
				newCard[count]=d;
				count++;
			}
		}
		return newCard;
		
	}
	
	public void shuffle () {
		Card store= deck[0];
		for (int i=0;i<deck.length;i++) {
			int random= (int)(Math.random()*52);
			store=deck[random];
			deck[random]=deck[i];
			deck[i]=store;
			
		}
	}
	
	public void sort () {
		Card store= deck[0];
		boolean swap= true;
		for (int i=0;i<deck.length-1;i++) {
			swap=false;
			for (int j=0;j<deck.length-i-1;j++) {
				if (deck[j].getNumber ()>deck[j+1].getNumber()) {
					store=deck[j+1];
					deck[j+1]=deck[j];
					deck[j]=store;
					swap=true;
				}
			}
			if (swap==false) {
				break;
			}
		}
	}

}
