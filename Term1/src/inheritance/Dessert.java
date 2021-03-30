package inheritance;

public class Dessert {
	private String name;
	private String type;
	private int sweetness;
	
	public Dessert (String name,String type,int sweetness) {
		this.name= name;
		this.type=type;
		this.sweetness= sweetness;
	}
	
	public String toString (){
		return "name: "+name+"\ntype: "+type+"\nsweetness: "+sweetness;
	}
	
	public void changeType (String type) {
		this.type=type;
	}
	
	public void increaseSweet (int n) {
		sweetness+=n;
	}
}
