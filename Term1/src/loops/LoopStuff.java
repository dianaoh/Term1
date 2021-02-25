package loops;
import java.util.Scanner;
public class LoopStuff {
	public static void main (String args[]) {
		LoopStuff a= new LoopStuff ();
		a.biggest(17);
		
	}
	
	public void biggest (int n) {
		Scanner scanner= new Scanner (System.in);
		System.out.println ("Enter "+n+" numbers");
		
		int max = Integer.MIN_VALUE;
		for (int i=0;i<n;i++) {
			int num= scanner.nextInt();
			
			if (num>max) {
				max=num;
					
			}
		}
		System.out.println(max);
	}
}

