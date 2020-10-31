import java.util.Scanner;
public class WhileLoops2 {
	Scanner scanner = new Scanner (System.in);
	
	public void Easy3() {
		System.out.println("Enter a number");
		int count= scanner.nextInt();
		while (count>0) {
			System.out.println("hi");
			count--;
		}
	}
	
	public void Medium3() {
		System.out.println("Enter a number");
		int num= scanner.nextInt();
		int count=1;
		while (count<=num) {
			if (num%count==0) {
				System.out.println(count);
			}
			count++;
		}
	}
	public void Hard1(){
		System.out.println("Enter two number");
		int num1=scanner.nextInt();
		int num2=scanner.nextInt();
		int gcd=1;
		if (num1>num2) {
			gcd=num2;
		}
		else if (num2>num1) {
			gcd=num1;
		}
		
		while (gcd>=1 && gcd>=1) {
			if (num1%gcd==0 && num2%gcd==0) {
				System.out.println(gcd);
				break;
			}
			gcd--;
		}
	}
	
	public void Hard2() {
		System.out.println("Enter two numbers");
		int num1=scanner.nextInt();
		int num2=scanner.nextInt();
		int lcm=1;
		if (num1>num2) {
			lcm=num1;
		}
		else if (num2>num1) {
			lcm=num2;
		}
		
		while (lcm>=num1 && lcm>=num2) {
			if (lcm%num1==0 && lcm%num2==0) {
				System.out.println(lcm);
				break;
			}
			lcm++;
		}
	}
	
	public void Hard3() {
		System.out.println("Enter a number");
		int num=scanner.nextInt();
		int count=1;
		int primecount=0;
		while (count<=num) {
			if (num%count==0) {
				primecount++;
			}
			count++;
		}
		if (primecount==2) {
			System.out.println("prime");
		}
		else {
			System.out.println("not prime");
		}
	}
	
	public void Challenge(){
		System.out.println("Enter how many magic squares you would like");
		int num=scanner.nextInt();
		int number=1;
		int square=1;
		int sum=0;
		int count=0;
		
		while (num>0) {
			number++;
			while (square*square<=number) {
				if (square*square==number) {
					while (sum<=number) {
						if (sum==number) {
							System.out.println(number);
							num--;
						}
						count++;
						sum= sum+count;
					}
				}
				square++;
			}
		}
	}
	
	public static void main(String args[]) {
		WhileLoops2 a = new WhileLoops2 ();
		a.Easy3 ();
		a.Medium3();
		a.Hard3();
		a.Hard1();
		a.Hard2();
		a.Challenge();
	}
}
	
