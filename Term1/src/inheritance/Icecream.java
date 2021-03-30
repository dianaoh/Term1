package inheritance;

public class Icecream extends Frozen{
	private String flavor;
	private String icecreamType;
	private int cream;
	
	public Icecream (String name,String type,int sweetness,int frozen, String typeFrozen,String flavor,String icecreamType, int cream) {
		super (name,type,sweetness,frozen,typeFrozen);
		this.flavor= flavor;
		this.icecreamType=icecreamType;
		this.cream= cream;
		
	}
	
	public void changeIcecreamType (String type) {
		icecreamType= type;
	}
	
	public void changeFlavor (String flavor) {
		this.flavor= flavor;
	}
	
	public void increaseThickness (int frozen, int creamVolume) { 
		super.increaseFrozen(frozen);
		cream+=creamVolume;
	}
	
	public String toString() {
		String output= super.toString();
		return output+"\nflavor: "+flavor+"\nicecreamType: "+icecreamType+"\ncream: "+cream;
	}
}
