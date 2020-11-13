package Loops;
public class WarmUp {
	public void rectangle (int x, int y) {
		for (int i=0;i<y;i++) {
			for (int j=0;j<x;j++) {
				System.out.print("X");
			}
			System.out.println();
		}
	}
	
	public void digit(int x) {
		while (x>=1) {
			System.out.println(x%10);
			x= (int)x/10;
		}
	}
	
	public void factors (int n) {
		for (int i=1;i<=n;i++) {
			for (int j=1;j<=i;j++) {
				if (i%j==0) {
					System.out.print(j+ " ");
				}
			}
			System.out.println();
		}
	}
	public static void main(String args[]) { 
		WarmUp a= new WarmUp ();
		a.rectangle (3,2);
		a.digit(253);
		a.factors(8);
	}
}
