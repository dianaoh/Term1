package inheritance;

public class Frozen extends Dessert{
	private int frozen;
	private String typeFrozen;
	private int cream;
	
	public Frozen (String name,String type,int sweetness,int frozen, String typeFrozen) {
		super (name, type, sweetness);
		this.frozen= frozen;
		this.typeFrozen= typeFrozen;
	}
	
	public void increaseFrozen (int n) {
		frozen+=n;
	}
	
	public void changeTypeFrozen (String type) {
		typeFrozen=type;
	}
	
	public String toString () {
		String output= super.toString();
		return output+"\nfrozen: "+frozen+"\ntypeFrozen: "+typeFrozen;
	}
}
