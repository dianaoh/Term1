package Loops;

public class Contest {
	public void problem1 (int n) {
		for (int i=1;i<=n;i++) {
			for (int j=i;j<n+i;j++) {
				System.out.print(j<=5 ? j : j-5);
			}
			System.out.println();
		}
	}
	
	public void problem2 (int n) {
		for (int i=0;i<=n;i++) {
			for (int j=0;j<i;j++) {
				System.out.print("X");
			}
			System.out.println();
		}
	}
	
	public void problem3 (int x, int y) {
		int multi=1;
		for (int i=0;i<=y;i++) {
			if (multi>=y) {
				System.out.println(i);
				break;
			}
			multi= multi*x;
			
		}
	}
	
	public void problem4 (int x) {
		for (int i=0;i<=x;i++) {
			for (int j=x; j>i;j--) {
				System.out.print(" ");
			}
			for (int j=0;j<i;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
		for (int i=0;i<=x;i++) {
			for (int j=0;j<=i;j++) {
				System.out.print(" ");
			}
			for (int j=x-1;j>i;j--) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	public static void main(String args[]) {
		Contest a= new Contest ();
		a.problem1(5);
		a.problem2 (4);
		a.problem3 (2,64);
		a.problem4 (4);
	
	}
}
