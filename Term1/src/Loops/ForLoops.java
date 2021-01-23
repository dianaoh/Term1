package Loops;
import java.util.Scanner;

public class ForLoops {
	Scanner scanner= new Scanner (System.in);
	
	///Print out the sum of all numbers from 1 to x (x is a parameter).
	public void Easy2 (int x) {
		int sum=0;
		for (int i=0;i<=x;i++) {
			sum+=i;
		}
		System.out.println(sum);
	}
	
	//Ask the user for answers until they give the right solution to the riddle.
	public void Easy3 () {
		System.out.println("What digit is the most frequent between the numbers 1 and 1,000 (inclusive)?");
		int answer= scanner.nextInt();
		while (answer!=1) {
			System.out.println("Incorrect- Enter again");
			answer= scanner.nextInt();
		}
		System.out.println("Congradulations you are correct!");
	}
	
	//Print out the multiplication table for 1-12.
	public void Hard1() {
		for (int i=1;i<=12;i++) {
			for (int j=1;j<=12;j++) {
				System.out.print(i*j+" ");
			}
			System.out.println();
		}
	}
	
	//Print out all prime numbers from 1 to x 
	public void Hard2(int x) {
		int count=0;
		for (int i=1;i<=x;i++) {
			for (int j=1;j<=i;j++) {
				if (i%j==0) {
					count++;
				}
			}
			if (count==2) {
				System.out.println(i);
			}
			count=0;
		}
		
	}
	
	//Print out an “X” of stars that is n rows tall 
	public void Hard4 (int n) {
		for (int i=1;i<=n;i++) {
			for (int j=0;j<=n;j++) {
				if (i==j) {
					System.out.print("*");
				}
				else if (i+j==n+1) {
						System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}System.out.println();
		}

	}

	
	public static void main(String args[]) {
		ForLoops a = new ForLoops ();
		a.Easy2(5);
		a.Easy3 ();
		a.Hard1();
		a.Hard2 (53);
		a.Hard4(10);
		
	}
}
