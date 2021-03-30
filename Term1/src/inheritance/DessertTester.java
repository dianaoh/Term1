package inheritance;

public class DessertTester {
	public static void main (String []args) {
		Icecream a = new Icecream ("strawberry cheesecake icecream","frozen", 10,50, "icecream", "strawberry cheesecake", "classic cup", 10);
		a.changeIcecreamType("gelato");
		a.changeFlavor("matcha");
		a.increaseThickness(10,20);
		System.out.println(a);
	}
}
