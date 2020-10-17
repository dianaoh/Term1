import java.util.Scanner;

public class starter {
	
	public void sqrt (int x) {
		System.out.println(Math.sqrt (x));
	}
	
	public void number (double x) {
		if (x%2==0) {
			System.out.println("even");
		}
		else if (x%2==1) {
			System.out.println("odd");
		}
		else
			System.out.println("whole number");
	}
	
	public void factor(double x, double y) {
		if (x%y==0) {
			System.out.println("factor");
		}
		else {
			System.out.println("not factor");
		}
	}
	
	public void three (double x, double y) {
		if (x-y<3 || x-y>-3)
		{
			System.out.println("within three numbers");
		}
	}
	
	private static String answer;

	public static void main(String args[])
	{
		
		System.out.println("press s,e,d or w");
		starter a= new starter ();
		Scanner scanner = new Scanner (System.in);
		answer = scanner.nextLine ();

		if (answer.equals("s")) {
			a.sqrt (7);
		}
		else if (answer.equals("e")) {
			a.number(2);
		}
		else if (answer.equals("d")) {
			a.factor(8, 4);
		}
		else if (answer.equals("w")) {
			a.three(4, 2);
		}
		else {
			System.out.println("you have not pressed a correct button");
		}
	}

}
