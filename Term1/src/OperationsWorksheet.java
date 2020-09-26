public class OperationsWorksheet {
	public void changeToCharacter (int x) {
		System.out.println((char) x);
	}
	
	public void lastDigit (int x) {
		System.out.println(x%10);
	}
	
	public void average(int x, int y) {
		System.out.println(((double)x+y)/2);
	}
	
	public static void main(String[] args) {
		OperationsWorksheet a = new OperationsWorksheet();
		a.changeToCharacter (65);
		a.average(6, 7);
		a.lastDigit(103);
	}
	
	
	

}
