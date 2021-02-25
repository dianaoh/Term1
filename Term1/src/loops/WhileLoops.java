package loops;
import java.util.*;
public class WhileLoops {
	Scanner scanner= new Scanner (System.in);
	
	//definite finite
	public void include() {
		System.out.println("enter two numbers, first smaller than the second");
		int first=scanner.nextInt ();
		int second=scanner.nextInt();
		while (first<= second) {
			System.out.println(first);
			first++;	
		}
	}
	//definite finite
	public void exponential() {
		System.out.println("enter two numbers");
		int x=0;
		double first=scanner.nextDouble ();
		double second=scanner.nextDouble();
		while (x<6) {
			System.out.println(second);
			second = first*second;
			x++;
		}
	}
	
	//definite finite
	public void root() {
		System.out.println("enter a number");
		int num=scanner.nextInt ();
		int x=0;
		while (x*x<=num) {
			if (x*x==num) {
				System.out.println(x);
				break;
			}
			x++;
		}
		
		if (x*x!=num) {
			System.out.println("does not have root");
		}
	}
	public static void main(String args[]) {
		
		WhileLoops a= new WhileLoops ();
		a.include ();
		a.exponential();
		a.root();
		
	}

}
